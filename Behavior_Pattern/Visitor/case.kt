interface Shape  {
    fun move(x: Int, y: Int)
    fun draw()
    fun accept(v: Visitor)
}

class Dot(x: Int, y: Int): Shape {
    var x: Int = x
    var y: Int = y

    override fun move(x: Int, y: Int) {
        this.x = x + this.x
        this.y = y + this.y
    }

    override fun draw() {
        println("This is a dot on ($x, $y).")
    }

    override fun accept(v: Visitor) {
        v.visitDot(this)
    }
}

class Circle(x: Int, y: Int): Shape {
    var x: Int = x
    var y: Int = y

    override fun move(x: Int, y: Int) {
        this.x = x + this.x
        this.y = y + this.y
    }

    override fun draw() {
        println("This is a circle on ($x, $y).")
    }

    override fun accept(v: Visitor) {
        v.visitCircle(this)
    }
}

interface Visitor {
    fun visitDot(d: Dot)
    fun visitCircle(c: Circle)
}

class XMLExportVisitor: Visitor {
    override fun visitDot(d: Dot) {
        println("Exporting a dot to XML...")
        d.draw()
    }

    override fun visitCircle(c: Circle) {
        println("Exporting a circle to XML...")
        c.draw()
    }
}

fun main() {
    val circle: Circle = Circle(12,3)
    val dot: Dot = Dot(43,76)
    val circle2: Circle = Circle(14,34)
    val dot2: Dot = Dot(65,725)
    val circle3: Circle = Circle(53,92)
    val dot3: Dot = Dot(324,63)

    val shapeArr: Array<Shape> = arrayOf(circle, dot, circle2, dot2, circle3, dot3)
    val visitor: XMLExportVisitor = XMLExportVisitor()

    for (shape in shapeArr) {
        shape.accept(visitor)
    }
}