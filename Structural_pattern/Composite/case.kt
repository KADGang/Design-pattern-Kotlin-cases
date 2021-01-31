interface Graphic {
    fun move(x: Int, y: Int)
    fun draw()
}

open class Dot(setX: Int, setY: Int): Graphic {
    var X: Int = setX
    var Y: Int = setY

    override fun move(x: Int, y: Int) {
        X += x
        Y += y
    }

    override fun draw() {
        println("This is a dot on ($X, $Y)")
    }
}

class Circle(setX: Int, setY: Int, setR: Int) : Dot(setX, setY) {
    val radius = setR

    override fun draw() {
        println("This is a Circle on ($X, $Y), radius is $radius")
    }
}

class CompoundGraphic: Graphic {
    private var index = 0
    private val children: Array<Graphic?> = arrayOfNulls<Graphic>(20)

    fun add(child: Graphic) {
        if(index <= 20) {
            children[index] = child
            index++
        }
    }

    fun remove(child: Graphic) {
        for (i in 0..19) {
            if (children[i] == child) {
                children[i] = null
            }
        }
    }

    override fun move(x: Int, y: Int) {
        for (keyChild in children) {
            keyChild?.move(x, y)
        }
    }

    override fun draw() {
        println("Children: ")
        for (keyChild in children) {
            if (keyChild is CompoundGraphic)
                print("Child CompoundGraphic -> ")
            keyChild?.draw()
        }
    }
}

fun main() {
    val dot1: Dot = Dot(3, 5)
    val circle1: Circle = Circle(2, 7, 8)
    val compoundGraphic1: CompoundGraphic = CompoundGraphic()

    compoundGraphic1.add(dot1)
    compoundGraphic1.add(circle1)
    compoundGraphic1.draw()
    println()

    val dot2: Dot = Dot(23, 41)
    val circle2: Circle = Circle(33, 12,54)
    val compoundGraphic2: CompoundGraphic = CompoundGraphic()

    compoundGraphic2.add(dot2)
    compoundGraphic2.add(circle2)
    compoundGraphic2.add(compoundGraphic1)
    compoundGraphic2.draw()
    println()
}