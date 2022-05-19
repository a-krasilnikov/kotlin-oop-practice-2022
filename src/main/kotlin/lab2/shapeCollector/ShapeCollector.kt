package lab2.shapeCollector

import lab2.ColorRGBA
import lab2.shapesInterface.ColoredShape2d

class ShapeCollector<T : ColoredShape2d>(_shapeList: List<T>) : ShapeCollectorInterface<T> {
    private val shapeList: MutableList<T>

    init {
        shapeList = _shapeList.toMutableList()
    }

    override fun add(shape: T) {
        shapeList.add(shape)
    }

    override fun minAreaFilter(): List<T> {
        if (shapeList.isEmpty()) return emptyList()
        val minArea = shapeList.minOf { it.area }
        return shapeList.filter { it.area == minArea }
    }

    override fun maxAreaFilter(): List<T> {
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

    override fun borderColorRGBAFilter(borderColorRGBA: ColorRGBA): List<T> =
        shapeList.filter { it.borderColorRGBA == borderColorRGBA }

    override fun fillColorRGBAFilter(fillColorRGBA: ColorRGBA): List<T> =
        shapeList.filter { it.fillColorRGBA == fillColorRGBA }

    override fun getShapeList(): List<T> = shapeList.toList()

    override fun getShapeListSize(): Int = shapeList.size

    override fun groupByBorderColorRGBA(): Map<ColorRGBA, List<T>> =
        shapeList.groupBy { it.borderColorRGBA }

    override fun groupByFillColorRGBA(): Map<ColorRGBA, List<T>> = shapeList.groupBy { it.fillColorRGBA }

    override fun groupByType(): Map<Class<Any>, List<T>> = shapeList.groupBy { it.javaClass }

    fun addAll(newShapesList: List<@UnsafeVariance T>) {
        newShapesList.forEach {
            shapeList.add(it)
        }
    }

    fun getSorted(shapesComparator: Comparator<@UnsafeVariance T>): List<T> {
        val sortedShapeList = shapeList
        sortedShapeList.sortWith(shapesComparator)
        return sortedShapeList.toList()
    }
}


