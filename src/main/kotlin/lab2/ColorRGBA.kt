package lab2

data class ColorRGBA(val red: Double, val green: Double, val blue: Double, val alpha: Double) {
    override fun toString(): String {
        return "ColorRGBA( $red, $green, $blue, $alpha)"
    }
}