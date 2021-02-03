abstract class GameAI {
    fun takeTurn() {
        collectResources()
        buildStructures()
        buildUnits()
        attack()
    }

    abstract fun collectResources()
    abstract fun buildStructures()
    abstract fun buildUnits()
    abstract fun attack()
}

class OrcsAI: GameAI() {
    override fun collectResources() {
        println("Orcs collecting resources...")
    }

    override fun buildStructures() {
        println("Orcs building structures...")
    }

    override fun buildUnits() {
        println("Orcs building units...")
    }

    override fun attack() {
        println("Orcs attacking...")
    }
}

class MonstersAI: GameAI() {
    override fun collectResources() {
        println("Monsters will not collect resources...")
    }

    override fun buildStructures() {
        println("Monsters will not build structures...")
    }

    override fun buildUnits() {
        println("Monsters will not build units...")
    }

    override fun attack() {
        println("Monsters attacking...")
    }
}

fun main() {
    val monster: MonstersAI = MonstersAI()
    val orc: OrcsAI = OrcsAI()

    monster.takeTurn()
    orc.takeTurn()
}