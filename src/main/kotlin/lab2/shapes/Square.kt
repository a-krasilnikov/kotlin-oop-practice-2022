package lab2.shapes

import lab2.ColorRGBA
import lab2.shapesInterface.ColoredShape2d

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