package lab2.shapeCollector

import lab2.ColorRGBA
import lab2.shapesInterface.ColoredShape2d

interface ShapeCollectorInterface {
    fun add(shape: ColoredShape2d)

    fun minAreaFilter(): List<ColoredShape2d>

    fun maxAreaFilter(): List<ColoredShape2d>

    fun getTotalArea(): Double

    fun borderColorRGBAFilter(borderColorRGBA: ColorRGBA): List<ColoredShape2d>

    fun fillColorRGBAFilter(fillColorRGBA: ColorRGBA): List<ColoredShape2d>

    fun getShapeList(): List<ColoredShape2d>

    fun getShapeListSize(): Int

    fun groupByBorderColorRGBA(): Map<ColorRGBA, List<ColoredShape2d>>

    fun groupByFillColorRGBA(): Map<ColorRGBA, List<ColoredShape2d>>

    fun groupByType(): Map<Class<Any>, List<ColoredShape2d>>
}