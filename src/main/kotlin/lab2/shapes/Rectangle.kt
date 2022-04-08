package lab2.shapes

import lab2.ColorRGBA
import lab2.shapesInterface.ColoredShape2d

class Rectangle(_a: Double, _b: Double, _borderColorRGBA: ColorRGBA, _fillColorRGBA: ColorRGBA) : ColoredShape2d {
    private val a: Double
    private val b: Double
    override val area: Double
        get() = a * b
    override val borderColorRGBA: ColorRGBA
    override val fillColorRGBA: ColorRGBA

    init {
        if (_a <= 0 || _b <= 0)
            throw IllegalArgumentException("Size of the sides should be positive")
        a = _a
        b = _b

        borderColorRGBA = _borderColorRGBA
        fillColorRGBA = _fillColorRGBA

    }

    override fun toString(): String {
        return "\nRectangle(\n" +
                "\ta: $a\n" +
                "\tb: $b\n" +
                "\tborderColorRGBA: $borderColorRGBA\n" +
                "\tfillColorRGBA: $fillColorRGBA)"
    }
}