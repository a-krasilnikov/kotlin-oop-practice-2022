package lab2.shapes

import kotlinx.serialization.Serializable
import lab2.ColorRGBA
import lab2.shapesInterface.ColoredShape2d

@Serializable
class Circle(
    public val radius: Double,
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Circle

        if (radius != other.radius) return false
        if (borderColorRGBA != other.borderColorRGBA) return false
        if (fillColorRGBA != other.fillColorRGBA) return false

        return true
    }

    override fun hashCode(): Int {
        var result = radius.hashCode()
        result = 31 * result + borderColorRGBA.hashCode()
        result = 31 * result + fillColorRGBA.hashCode()
        return result
    }
}