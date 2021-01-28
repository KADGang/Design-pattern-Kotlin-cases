interface Button {
    fun render()
    fun onClick()
}

class WindowsButton : Button {
    override fun render() {
        println("WindowsButton Rendering")
    }

    override fun onClick() {
        println("WindowsButton onClicked!")
    }
}

class HTMLButton : Button {
    override fun render() {
        println("HTMLButton Rendering")
    }

    override fun onClick() {
        println("HTMLButton onClicked!")
    }
}

abstract class Dialog {
    fun render() {
        val okButton : Button = createButton()
        okButton.onClick()
        okButton.render()
    }

    abstract fun createButton() : Button
}

class WindowsDialog : Dialog() {
    override fun createButton() : WindowsButton {
        println("This is a WindowsButton")
        return WindowsButton()
    }
}

class HTMLDialog : Dialog() {
    override fun createButton() : HTMLButton{
        println("This is a HTMLsButton")
        return HTMLButton()
    }
}

class Application {
    lateinit var dialog : Dialog

    fun initialize() {
        val config = "Windows"

        if(config == "Windows") {
            dialog = WindowsDialog()
        } else if (config == "Web") {
            dialog = HTMLDialog()
        } else {
            throw Exception("未知操作系统")
        }
    }
}

fun main() {
    val app = Application()
    app.initialize()
    app.dialog.render()
}