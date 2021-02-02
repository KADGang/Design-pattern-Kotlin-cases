import java.util.*

abstract class Command(app: Application, editor: Editor) {
    protected var app = app
    protected var editor = editor
    private var backup = ""

    fun saveBackup() {
        backup = editor.text
    }

    fun undo() {
        editor.text = backup
    }

    abstract fun execute(): Boolean
}

class Editor {
    var text: String = ""

    fun getSelection(): String {
        return text
    }

    fun deleteSelection() {
        text = ""
    }

    fun replaceSelection(text: String) {
        this.text = text
    }
}

class CommandHistory {
    var history: Stack<Command> = Stack<Command>()

    fun push(c: Command) {
        history.push(c)
    }

    fun pop(): Command {
        return history.pop()
    }
}

class Application {
    var activeEditor: Editor = Editor()
    var clipboard: String = ""
    var history: CommandHistory = CommandHistory()

    fun executeCommand(command: Command) {
        if (command.execute()) {
            history.push(command)
        }
        println(activeEditor.text)
    }

    fun undo() {
        val command: Command = history.pop()
        if (command != null)
            command.undo()
    }
}

class CopyCommand(app: Application, editor: Editor) : Command(app, editor) {
    override fun execute(): Boolean {
        app.clipboard = editor.getSelection()
        return false
    }
}

class CutCommand(app: Application, editor: Editor) : Command(app, editor) {
    override fun execute(): Boolean {
        saveBackup()
        app.clipboard = editor.getSelection()
        editor.deleteSelection()
        return true
    }
}

class PasteCommand(app: Application, editor: Editor) : Command(app, editor) {
    override fun execute(): Boolean {
        saveBackup()
        editor.replaceSelection(app.clipboard)
        return true
    }
}

class UndoCommand(app: Application, editor: Editor) : Command(app, editor) {
    override fun execute(): Boolean {
        app.undo()
        return false
    }
}

fun main() {
    val app: Application = Application()
    app.activeEditor.replaceSelection("asldfjasldkfjlaskdjf")

    app.executeCommand(CopyCommand(app, app.activeEditor))
    app.executeCommand(PasteCommand(app, app.activeEditor))
    app.executeCommand(CutCommand(app, app.activeEditor))
    app.executeCommand(PasteCommand(app, app.activeEditor))
    app.executeCommand(UndoCommand(app, app.activeEditor))
    app.executeCommand(UndoCommand(app, app.activeEditor))
    app.executeCommand(UndoCommand(app, app.activeEditor))
}