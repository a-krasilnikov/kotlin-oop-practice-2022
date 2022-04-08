package lab2.shapes

import lab2.ColorRGBA
import lab2.shapesInterface.ColoredShape2d

class Square(_a: Double, _borderColorRGBA: ColorRGBA, _fillColorRGBA: ColorRGBA) : ColoredShape2d {
    private val a: Double
    override val borderColorRGBA: ColorRGBA
    override val fillColorRGBA: ColorRGBA
    override val area: Double
        get() = a * a

    init {
        if (_a <= 0)
            throw IllegalArgumentException("Size of the sides should be positive")
        a = _a

        borderColorRGBA = _borderColorRGBA
        fillColorRGBA = _fillColorRGBA
    }

    override fun toString(): String {
        return "\nSquare(\n" +
                "\ta: $a\n" +
                "\tborderColorRGBA: $borderColorRGBA\n" +
                "\tfillColorRGBA: $fillColorRGBA)"
    }
}