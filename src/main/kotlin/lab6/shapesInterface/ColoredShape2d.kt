package lab6.shapesInterface

import lab6.ColorRGBA


interface ColoredShape2d : Shape2d {
    val borderColorRGBA: ColorRGBA
    val fillColorRGBA: ColorRGBA
}
