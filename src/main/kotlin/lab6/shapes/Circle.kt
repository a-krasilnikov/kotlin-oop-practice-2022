package lab6.shapes

import lab6.ColorRGBA
import lab6.shapesInterface.ColoredShape2d
import kotlinx.serialization.Serializable

@Serializable
class Circle(
    val radius: Double,
    override val borderColorRGBA: ColorRGBA,
    override val fillColorRGBA: ColorRGBA
) : ColoredShape2d {
    override val area: Double
        get() = Math.PI * radius * radius

    init {
        if (radius <= 0)
            throw IllegalArgumentException("Radius should be positive")
    }

    override fun toString(): String {
        return "\nCircle(\n" +
                "\tradius: $radius\n" +
                "\tborderColorRGBA: $borderColorRGBA\n" +
                "\tfillColorRGBA: $fillColorRGBA)"
    }
}