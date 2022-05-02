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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rectangle

        if (a != other.a) return false
        if (b != other.b) return false
        if (borderColorRGBA != other.borderColorRGBA) return false
        if (fillColorRGBA != other.fillColorRGBA) return false

        return true
    }

    override fun hashCode(): Int {
        var result = a.hashCode()
        result = 31 * result + b.hashCode()
        result = 31 * result + borderColorRGBA.hashCode()
        result = 31 * result + fillColorRGBA.hashCode()
        return result
    }
}