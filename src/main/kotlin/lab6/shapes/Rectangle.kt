package lab6.shapes

import lab6.ColorRGBA
import lab6.shapesInterface.ColoredShape2d
import kotlinx.serialization.Serializable

@Serializable
class Rectangle(
    val a: Double,
    val b: Double,
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