package lab2

class ColorRGBA(_red: Double, _green: Double, _blue: Double, _alpha: Double) {

    val red: Double
    val green: Double
    val blue: Double
    val alpha: Double

    init {
        if (!(0.0..255.0).contains(_red)) throw error("red should be in 0..255")
        if (!(0.0..255.0).contains(_green)) throw error("green should be in 0..255")
        if (!(0.0..255.0).contains(_blue)) throw error("blue should be in 0..255")
        if (!(0.0..1.0).contains(_alpha)) throw error("alpha should be in 0..1")
        red = _red
        green = _green
        blue = _blue
        alpha = _alpha
    }

    override fun toString(): String {
        return "ColorRGBA( $red, $green, $blue, $alpha)"
    }
}