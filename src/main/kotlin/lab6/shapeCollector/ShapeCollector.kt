package lab6.shapeCollector

import lab6.ColorRGBA
import lab6.shapesInterface.ColoredShape2d
import kotlinx.serialization.Serializable

@Serializable
class ShapeCollector(private var _shapeList: List<ColoredShape2d>) : ShapeCollectorInterface {
    private val shapeList: MutableList<ColoredShape2d> = _shapeList.toMutableList()

    override fun add(shape: ColoredShape2d) {
        shapeList.add(shape)
        _shapeList = shapeList.toList()
    }

    override fun minAreaFilter(): List<ColoredShape2d> {
        if (shapeList.isEmpty()) return emptyList()
        val minArea = shapeList.minOf { it.area }
        return shapeList.filter { it.area == minArea }
    }

    override fun maxAreaFilter(): List<ColoredShape2d> {
        if (shapeList.isEmpty()) return emptyList()
        val maxArea = shapeList.maxOf { it.area }
        return shapeList.filter { it.area == maxArea }
    }

    override fun getTotalArea(): Double {
        var totalArea = 0.0
        shapeList.forEach {
            totalArea += it.area
        }
        return totalArea
    }

    override fun borderColorRGBAFilter(borderColorRGBA: ColorRGBA): List<ColoredShape2d> =
        shapeList.filter { it.borderColorRGBA == borderColorRGBA }

    override fun fillColorRGBAFilter(fillColorRGBA: ColorRGBA): List<ColoredShape2d> =
        shapeList.filter { it.fillColorRGBA == fillColorRGBA }

    override fun getShapeList(): List<ColoredShape2d> = shapeList.toList()

    override fun getShapeListSize(): Int = shapeList.size

    override fun groupByBorderColorRGBA(): Map<ColorRGBA, List<ColoredShape2d>> =
        shapeList.groupBy { it.borderColorRGBA }

    override fun groupByFillColorRGBA(): Map<ColorRGBA, List<ColoredShape2d>> = shapeList.groupBy { it.fillColorRGBA }

    override fun groupByType(): Map<Class<Any>, List<ColoredShape2d>> = shapeList.groupBy { it.javaClass }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ShapeCollector

        if (_shapeList != other._shapeList) return false
        if (shapeList != other.shapeList) return false

        return true
    }

    override fun hashCode(): Int {
        var result = _shapeList.hashCode()
        result = 31 * result + shapeList.hashCode()
        return result
    }
}