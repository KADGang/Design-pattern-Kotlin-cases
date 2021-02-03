interface Strategy {
    fun execute(a: Int, b: Int): Int
}

class ConcreteStrategyAdd: Strategy {
    override fun execute(a: Int, b: Int): Int {
        return a + b
    }
}

class ConcreteStrategySubtract: Strategy {
    override fun execute(a: Int, b: Int): Int {
        return a - b
    }
}

class ConcreteStrategyMultiply: Strategy {
    override fun execute(a: Int, b: Int): Int {
        return a * b
    }
}

class Context {
    private var strategy: Strategy? = null

    fun setStrategy(s: Strategy) {
        strategy = s
    }

    fun executeStrategy(a: Int, b: Int): Int? {
        return strategy?.execute(a, b)
    }
}

fun main() {
    val context: Context = Context()
    val add: ConcreteStrategyAdd = ConcreteStrategyAdd()
    val subtract: ConcreteStrategySubtract = ConcreteStrategySubtract()
    val multiply: ConcreteStrategyMultiply = ConcreteStrategyMultiply()

    context.setStrategy(add)
    println(context.executeStrategy(23, 54))
    context.setStrategy(subtract)
    println(context.executeStrategy(23, 54))
    context.setStrategy(multiply)
    println(context.executeStrategy(23, 54))
}