class Editor {
    var editorState: String = ""

    fun setState(x: String) {
        editorState = x
    }

    fun createSnapshot(): Snapshot {
        return Snapshot(editorState)
    }

    fun showState() {
        println(editorState)
    }
}

class Snapshot(state: String) {
    var state: String = state

    fun restore(): String {
        return state
    }
}

class Command(editor: Editor) {
    lateinit var backup: Snapshot
    var editor: Editor = editor

    fun makeBackup() {
        backup = editor.createSnapshot()
    }

    fun undo() {
        editor.setState(backup.restore())
    }
}

fun main() {
    val editor: Editor = Editor()
    val command: Command = Command(editor)

    editor.setState("开头")
    editor.showState()
    command.makeBackup()
    editor.setState("结尾")
    editor.showState()
    command.undo()
    editor.showState()
}