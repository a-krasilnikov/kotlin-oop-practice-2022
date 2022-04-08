package lab2.shapes

import lab2.ColorRGBA
import lab2.shapesInterface.ColoredShape2d

class Circle(_radius: Double, _borderColorRGBA: ColorRGBA, _fillColorRGBA: ColorRGBA) : ColoredShape2d {
    private val radius: Double
    override val borderColorRGBA: ColorRGBA
    override val fillColorRGBA: ColorRGBA
    override val area: Double
        get() = Math.PI * radius * radius

    init {
        if (_radius <= 0)
            throw IllegalArgumentException("Radius should be positive")
        radius = _radius

        borderColorRGBA = _borderColorRGBA.copy()
        fillColorRGBA = _fillColorRGBA.copy()
    }

    override fun toString(): String {
        return "\nCircle(\n" +
                "\tradius: $radius\n" +
                "\tborderColorRGBA: $borderColorRGBA\n" +
                "\tfillColorRGBA: $fillColorRGBA)"
    }
}