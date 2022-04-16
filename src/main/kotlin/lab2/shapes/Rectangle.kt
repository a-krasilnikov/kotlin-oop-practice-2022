package lab2.shapes

import lab2.ColorRGBA
import lab2.shapesInterface.ColoredShape2d

class Rectangle(
    private val a: Double,
    private val b: Double,
    override val borderColorRGBA: ColorRGBA,
    override val fillColorRGBA: ColorRGBA
) : ColoredShape2d {
    override val area: Double
        get() = a * b

    init {
        if (a <= 0 || b <= 0)
            throw IllegalArgumentException("Size of the sides should be positive")
    }

    override fun toString(): String {
        return "\nRectangle(\n" +
                "\ta: $a\n" +
                "\tb: $b\n" +
                "\tborderColorRGBA: $borderColorRGBA\n" +
                "\tfillColorRGBA: $fillColorRGBA)"
    }
}