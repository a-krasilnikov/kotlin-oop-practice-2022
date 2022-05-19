package lab2.shapeCollector

import lab2.ColorRGBA
import lab2.shapesInterface.ColoredShape2d

interface ShapeCollectorInterface<T : ColoredShape2d> {
    fun add(shape: T)

    fun minAreaFilter(): List<T>

    fun maxAreaFilter(): List<T>

    fun getTotalArea(): Double

    fun borderColorRGBAFilter(borderColorRGBA: ColorRGBA): List<T>

    fun fillColorRGBAFilter(fillColorRGBA: ColorRGBA): List<T>

    fun getShapeList(): List<T>

    fun getShapeListSize(): Int

    fun groupByBorderColorRGBA(): Map<ColorRGBA, List<T>>

    fun groupByFillColorRGBA(): Map<ColorRGBA, List<T>>

    fun groupByType(): Map<Class<Any>, List<T>>
}