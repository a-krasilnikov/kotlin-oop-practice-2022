package lab2

data class ColorRGBA(val red: Double, val green: Double, val blue: Double, val alpha: Double) {

    init {
        if (!(0.0..255.0).contains(red)) throw error("red should be in 0..255")
        if (!(0.0..255.0).contains(green)) throw error("green should be in 0..255")
        if (!(0.0..255.0).contains(blue)) throw error("blue should be in 0..255")
        if (!(0.0..1.0).contains(alpha)) throw error("alpha should be in 0..1")
    }
    override fun toString(): String {
        return "ColorRGBA( $red, $green, $blue, $alpha)"
    }
}