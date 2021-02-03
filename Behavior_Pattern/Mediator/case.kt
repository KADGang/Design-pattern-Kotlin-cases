interface Component {
    fun operation()
}

class ComponentA(mediator: Mediator): Component {
    val m: Mediator = mediator

    override fun operation() {
        m.notify(this)
    }
}

class ComponentB(mediator: Mediator): Component {
    val m: Mediator = mediator

    override fun operation() {
        m.notify(this)
    }
}

class ComponentC(mediator: Mediator): Component {
    val m: Mediator = mediator

    override fun operation() {
        m.notify(this)
    }
}

interface Mediator {
    fun notify(sender: Component)
}

class ConcreteMediator(): Mediator {

    override fun notify(sender: Component) {
        if (sender is ComponentA)
            reactOnA()
        else if (sender is ComponentB)
            reactOnB()
        else
            println("Unknown type.")
    }

    fun reactOnA() {
        println("This is a ComponentA.")
    }

    fun reactOnB() {
        println("This is a ComponentB.")
    }
}

fun main() {
    val mediator: ConcreteMediator = ConcreteMediator()
    val ca: ComponentA = ComponentA(mediator)
    val cb: ComponentB = ComponentB(mediator)
    val cc: ComponentC = ComponentC(mediator)

    ca.operation()
    cb.operation()
    cc.operation()
}