interface Button {
    fun paint()
}

class WinButton : Button {
    override fun paint() {
        println("A WinButton has been painted.")
    }
}

class MacButton : Button {
    override fun paint() {
        println("A MacButton has been painted.")
    }
}

interface Checkbox {
    fun paint()
}

class WinCheckbox : Checkbox {
    override fun paint() {
        println("A WinCheckbox has been painted.")
    }
}

class MacCheckbox : Checkbox {
    override fun paint() {
        println("A MacCheckbox has been painted.")
    }
}

interface GUIFactory {
    fun createButton(): Button
    fun createCheckbox(): Checkbox
}

class WinFactory : GUIFactory {
    override fun createButton(): WinButton {
        return WinButton()
    }

    override fun createCheckbox(): WinCheckbox {
        return WinCheckbox()
    }
}

class MacFactory : GUIFactory {
    override fun createButton(): MacButton {
        return MacButton()
    }

    override fun createCheckbox(): MacCheckbox {
        return MacCheckbox()
    }
}

class Application {
    lateinit var factory: GUIFactory

    fun initialize() {
        val config = "Mac"

        if(config == "Windows") {
            factory = WinFactory()
        } else if (config == "Mac") {
            factory = MacFactory()
        } else {
            throw Exception("未知操作系统")
        }
    }
}

fun main() {
    val app = Application()
    app.initialize()
    app.factory.createButton().paint()
    app.factory.createCheckbox().paint()
}