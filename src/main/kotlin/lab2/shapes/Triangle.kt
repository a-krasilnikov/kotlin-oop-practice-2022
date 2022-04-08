package lab2.shapes

import lab2.ColorRGBA
import lab2.shapesInterface.ColoredShape2d
import kotlin.math.sqrt

class Triangle(_a: Double, _b: Double, _c: Double, _borderColorRGBA: ColorRGBA, _fillColorRGBA: ColorRGBA) :
    ColoredShape2d {
    private val a: Double
    private val b: Double
    private val c: Double

//    private val angleAB: Double
//    private val angleAC: Double
//    private val angleAD: Double

    override val borderColorRGBA: ColorRGBA
    override val fillColorRGBA: ColorRGBA
    override val area: Double
        get() {
            val p = (a + b + c) / 2
            return sqrt(p * (p - a) * (p - b) * (p - c))
        }

    init {
        if (_a <= 0 || _b <= 0 || _c <= 0)
            throw IllegalArgumentException("Size of the sides should be positive")
        a = _a
        b = _b
        c = _c

        borderColorRGBA = _borderColorRGBA.copy()
        fillColorRGBA = _fillColorRGBA.copy()
    }

    override fun toString(): String {
        return "\nTriangle(\n" +
                "\ta: $a\n" +
                "\tb: $b\n" +
                "\tc: $c\n" +
                "\tborderColorRGBA: $borderColorRGBA\n" +
                "\tfillColorRGBA: $fillColorRGBA)"
    }
}