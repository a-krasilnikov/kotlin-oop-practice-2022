package lab6.shapes

import lab6.ColorRGBA
import lab6.shapesInterface.ColoredShape2d
import kotlinx.serialization.Serializable

@Serializable
class Square(val a: Double, override val borderColorRGBA: ColorRGBA, override val fillColorRGBA: ColorRGBA) :
    ColoredShape2d {

    override val area: Double
        get() = a * a

    init {
        if (a <= 0)
            throw IllegalArgumentException("Size of the sides should be positive")
    }

    override fun toString(): String {
        return "\nSquare(\n" +
                "\ta: $a\n" +
                "\tborderColorRGBA: $borderColorRGBA\n" +
                "\tfillColorRGBA: $fillColorRGBA)"
    }
}