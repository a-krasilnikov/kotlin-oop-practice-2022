package lab2.shapesInterface

import lab2.ColorRGBA

interface ColoredShape2d : Shape2d {
    val borderColorRGBA: ColorRGBA
    val fillColorRGBA: ColorRGBA
}
