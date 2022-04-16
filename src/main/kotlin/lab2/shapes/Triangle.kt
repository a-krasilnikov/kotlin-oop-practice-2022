package lab2.shapes

import lab2.ColorRGBA
import lab2.shapesInterface.ColoredShape2d
import kotlin.math.sqrt

class Triangle(
    private val a: Double,
    private val b: Double,
    private val c: Double,
    override val borderColorRGBA: ColorRGBA,
    override val fillColorRGBA: ColorRGBA
) :
    ColoredShape2d {
//    private val angleAB: Double
//    private val angleAC: Double
//    private val angleAD: Double

    override val area: Double
        get() {
            val p = (a + b + c) / 2
            return sqrt(p * (p - a) * (p - b) * (p - c))
        }

    init {
        if (a <= 0 || b <= 0 || c <= 0)
            throw IllegalArgumentException("Size of the sides should be positive")

        if (a + b <= c || a + c <= b || b + c <= a)
            throw IllegalArgumentException("Sum of two sides should be greater than third side")
    }

    override fun toString(): String {
        return "\nTriangle(\n" +
                "\ta: $a\n" +
                "\tb: $b\n" +
                "\tc: $c\n" +
                "\tborderColorRGBA: $borderColorRGBA\n" +
                "\tfillColorRGBA: $fillColorRGBA)"
    }
}