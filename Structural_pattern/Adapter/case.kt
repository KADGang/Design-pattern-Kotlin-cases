import kotlin.math.sqrt

open class RoundPeg() {
    private var radius: Int = 0

    constructor(r : Int): this() {
        radius = r
    }

    open fun getRadius(): Int {
        return radius
    }
}

class SquarePeg {
    private var width: Int = 0

    constructor(w: Int) {
        width = w
    }

    fun getWidth(): Int {
        return width
    }
}

class SquarePegAdapter: RoundPeg {
    private var peg: SquarePeg? = null

    constructor(p: SquarePeg) {
        peg = p
    }

    override fun getRadius(): Int {
        return (peg?.getWidth()?.times(sqrt(2.0)) ?: 0).toInt() / 2
    }
}

class RoundHole {
    private var radius: Int = 0

    constructor(r: Int) {
        radius = r
    }

    fun getRadius(): Int {
        return radius
    }

    fun fits(peg: RoundPeg): Boolean {
        val pr = peg.getRadius()
        return pr == radius || pr < radius
    }
}

fun main() {
    val hole = RoundHole(5)
    val rpeg = RoundPeg(5)
    println(hole.fits(rpeg))

    val small_sqpeg = SquarePeg(5)
    val large_sqpeg = SquarePeg(10)

    val small_sqpeg_adapter = SquarePegAdapter(small_sqpeg)
    val large_sqpeg_adapter = SquarePegAdapter(large_sqpeg)
    println(hole.fits(small_sqpeg_adapter))
    println(hole.fits(large_sqpeg_adapter))
}