package lab2

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
}