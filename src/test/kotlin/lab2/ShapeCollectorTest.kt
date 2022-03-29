package lab2

import lab2.shapes.Circle
import lab2.shapes.Rectangle
import lab2.shapes.Square
import lab2.shapes.Triangle
import lab2.shapesInterface.ColoredShape2d
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ShapeCollectorTest {
    private val color1 = ColorRGBA(1.0, 1.0, 1.0, 1.0)
    private val color2 = ColorRGBA(2.0, 2.0, 2.0, 2.0)
    private val color3 = ColorRGBA(3.0, 3.0, 3.0, 3.0)

    private val circle1 = Circle(1.0, color1, color2)
    private val circle2 = Circle(2.0, color1, color3)
    private val triangle = Triangle(3.0, 4.0, 5.0, color2, color1)
    private val rectangle = Rectangle(6.0, 7.0, color2, color3)
    private val square1 = Square(8.0, color3, color1)
    private val square2 = Square(9.0, color3, color2)

    private val fullShapeList = listOf(circle1, rectangle, square1, triangle, circle2, square2)
    private val emptyShapeList = emptyList<ColoredShape2d>()

    private val fullShapeCollection = ShapeCollector(fullShapeList)
    private val emptyShapeCollection = ShapeCollector(emptyShapeList)

    @Test
    fun getShapeList() {
        assertEquals(fullShapeList, fullShapeCollection.getShapeList())

        assertEquals(emptyShapeList, emptyShapeCollection.getShapeList())
    }

    @Test
    fun add() {
        val smallShapeCollection = ShapeCollector(listOf(circle1, rectangle, square1, triangle))
        smallShapeCollection.add(circle2)
        smallShapeCollection.add(square2)

        assertEquals(fullShapeCollection.getShapeList(), smallShapeCollection.getShapeList())
    }

    @Test
    fun minAreaFilter() {
        fullShapeCollection.minAreaFilter().forEach {
            assertEquals(Math.PI, it.area)
        }

        assertEquals(emptyShapeList, emptyShapeCollection.minAreaFilter())
    }

    @Test
    fun maxAreaFilter() {
        fullShapeCollection.maxAreaFilter().forEach {
            assertEquals(9.0 * 9.0, it.area)
        }

        assertEquals(emptyShapeList, emptyShapeCollection.maxAreaFilter())
    }

    @Test
    fun getTotalArea() {
        assertEquals(Math.PI + 4 * Math.PI + 6 + 6 * 7 + 8 * 8 + 9 * 9, fullShapeCollection.getTotalArea())
        assertEquals(0.0, emptyShapeCollection.getTotalArea())
    }

    @Test
    fun borderColorRGBAFilter() {
        assertEquals(listOf<ColoredShape2d>(circle1, circle2), fullShapeCollection.borderColorRGBAFilter(color1))
        assertEquals(listOf(rectangle, triangle), fullShapeCollection.borderColorRGBAFilter(color2))
        assertEquals(listOf<ColoredShape2d>(square1, square2), fullShapeCollection.borderColorRGBAFilter(color3))

        assertEquals(emptyShapeList, emptyShapeCollection.borderColorRGBAFilter(color1))
    }

    @Test
    fun fillColorRGBAFilter() {
        assertEquals(listOf( square1, triangle), fullShapeCollection.fillColorRGBAFilter(color1))
        assertEquals(listOf(circle1, square2), fullShapeCollection.fillColorRGBAFilter(color2))
        assertEquals(listOf(rectangle, circle2), fullShapeCollection.fillColorRGBAFilter(color3))

        assertEquals(emptyShapeList, emptyShapeCollection.fillColorRGBAFilter(color1))
    }

    @Test
    fun getShapeListSize() {
        assertEquals(6, fullShapeCollection.getShapeListSize())

        assertEquals(0, emptyShapeCollection.getShapeListSize())
    }

    @Test
    fun groupByBorderColorRGBA() {
        fullShapeCollection.groupByBorderColorRGBA().forEach{
            assertEquals(it.key, it.value[0].borderColorRGBA)
        }
    }

    @Test
    fun groupByFillColorRGBA() {
        fullShapeCollection.groupByFillColorRGBA().forEach{
            assertEquals(it.key, it.value[0].fillColorRGBA)
        }
    }

    @Test
    fun groupByType() {
        fullShapeCollection.groupByType().forEach{
            assertEquals(it.key, it.value[0].javaClass)
        }
    }
}