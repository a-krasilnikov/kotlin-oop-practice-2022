package lab2

import kotlinx.serialization.Serializable

@Serializable
data class ColorRGBA(val red: Int, val green: Int, val blue: Int, val alpha: Double) {

    init {
        if (red !in 0..255) throw error("red should be in 0..255")
        if (green !in 0..255) throw error("green should be in 0..255")
        if (blue !in 0..255) throw error("blue should be in 0..255")
        if (!(0.0..1.0).contains(alpha)) throw error("alpha should be in 0..1")
    }

    override fun toString(): String {
        return "ColorRGBA( $red, $green, $blue, $alpha)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ColorRGBA

        if (red != other.red) return false
        if (green != other.green) return false
        if (blue != other.blue) return false
        if (alpha != other.alpha) return false

        return true
    }

    override fun hashCode(): Int {
        var result = red
        result = 31 * result + green
        result = 31 * result + blue
        result = 31 * result + alpha.hashCode()
        return result
    }
}