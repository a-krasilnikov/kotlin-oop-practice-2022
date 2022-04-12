package lab2.shapeCollector

import lab2.ColorRGBA
import lab2.shapesInterface.ColoredShape2d

class ShapeCollector(_shapeList: List<ColoredShape2d>) :ShapeCollectorInterface{
    private val shapeList: MutableList<ColoredShape2d>

    init {
        shapeList = _shapeList.toMutableList()
    }

    override fun add(shape: ColoredShape2d) {
        shapeList.add(shape)
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

    override fun groupByBorderColorRGBA(): Map<ColorRGBA, List<ColoredShape2d>> = shapeList.groupBy { it.borderColorRGBA }

    override fun groupByFillColorRGBA(): Map<ColorRGBA, List<ColoredShape2d>> = shapeList.groupBy { it.fillColorRGBA }

    override fun groupByType(): Map<Class<Any>, List<ColoredShape2d>> = shapeList.groupBy { it.javaClass }


//+    в который можно добавлять фигуры
//+    который умеет возвращать фигуру с наименьшей/наибольшей площадью
//+    суммарную площадь всех фигур
//+    искать все фигуры по цвету границы
//+    искать все фигуры по цвету заливки
//+    возвращать список всех фигур, которые сейчас хранятся
//+    возвращать количество, которые сейчас хранятся
//+    возвращать фигуры, сгруппированные по цвету границы (Map<Color, List<ColoredShape2d)
//+    возвращать фигуры, сгруппированные по цвету заливки (Map<Color, List<ColoredShape2d)
//+    возвращать фигуры определенного типа // при этом, при появлении
//+           новой фигуры в иерархии не должно быть необходимости менять код
//    Unit-тесты на ShapeCollector

}