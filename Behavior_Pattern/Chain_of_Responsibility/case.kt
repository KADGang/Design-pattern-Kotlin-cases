//TODO:不是很懂这个代码
interface ComponentWithContextualHelp {
    fun showHelp()
}

open class Component: ComponentWithContextualHelp {
    var container: Container? = null
    val tooltipText: String? = null

    override fun showHelp() {
        if (tooltipText != null)
            println(tooltipText)
        else
            container?.showHelp()
    }
}

open class Container: Component() {
    private val children: Array<Component?> = arrayOfNulls(10)
    var index = 0

    fun add(child: Component) {
        if (index < 10) {
            children[index] = child
            index++
        }
        child.container = this
    }
}

class Panel(helpText: String?): Container() {
    private val modalHelpText: String? = helpText

    override fun showHelp() {
        if (modalHelpText != null)
            println(modalHelpText)
        else
            super.showHelp()
    }
}

class Dialog(wikiURL: String?): Container() {
    private val wikiPageURL: String? = wikiURL

    override fun showHelp() {
        if (wikiPageURL != null)
            println("Loading wiki: $wikiPageURL")
        else
            super.showHelp()
    }
}

fun main() {
    var dialog: Dialog = Dialog("https://wiki.com")
    var panel: Panel = Panel(null)
    var dialog1: Dialog = Dialog("https://wiki1.com")
    var panel2: Panel = Panel("本面板2用于...")

    dialog1.add(panel2)
    panel.add(dialog1)
    dialog.add(panel)
    dialog.showHelp()
}