//TODO: 没有学会调用父类构造函数的方法

abstract class Shape() {
    abstract var x: Int
    abstract var y: Int
    abstract var color: String

    init {
        this.x = 0
        this.y = 0
        this.color = ""
    }

    constructor(source: Shape) : this() {
        this.x = source.x
        this.y = source.y
        this.color = source.color
    }

    abstract fun clone(): Shape
}

class Rectangle() : Shape() {
    override var x: Int = 0
    override var y: Int = 0
    override lateinit var color: String

    var width: Int = 0
    var height: Int = 0

    init {
        width = 0
        height = 0
    }

    constructor(source: Rectangle) : this() {
        this.x = source.x
        this.y = source.y
        this.color = source.color

        this.width = source.width
        this.height = source.height
    }

    override fun clone(): Rectangle {
        return Rectangle(this)
    }

    fun printMessage() {
        println("x: $x")
        println("y: $y")
        println("color: $color")
        println("height: $height")
        println("width: $width")
        println()
    }
}

class Circle() : Shape() {
    override var x: Int = 0
    override var y: Int = 0
    override lateinit var color: String

    var radius: Int = 0

    init {
        radius = 0
    }

    constructor(source: Circle) : this() {
        this.x = source.x
        this.y = source.y
        this.color = source.color

        this.radius = source.radius
    }

    override fun clone(): Circle {
        return Circle(this)
    }

    fun printMessage() {
        println("x: $x")
        println("y: $y")
        println("color: $color")
        println("radius: $radius")
        println()
    }
}

fun main() {
    val rectangle : Rectangle = Rectangle()

    rectangle.x = 1
    rectangle.y = 5
    rectangle.color = "red"
    rectangle.width = 3
    rectangle.height = 9

    val rectangleClone = rectangle.clone()
    rectangle.printMessage()
    rectangleClone.printMessage()

    val circle : Circle = Circle()
    circle.x = 2
    circle.y = 9
    circle.color = "green"
    circle.radius = 32

    val circleClone = circle.clone()
    circle.printMessage()
    circleClone.printMessage()
}