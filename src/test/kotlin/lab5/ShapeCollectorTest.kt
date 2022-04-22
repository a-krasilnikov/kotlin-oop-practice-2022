package lab5

import lab2.ColorRGBA
import lab5.shapeCollector.ShapeCollector
import lab2.shapes.Circle
import lab2.shapes.Rectangle
import lab2.shapes.Square
import lab2.shapes.Triangle
import lab2.shapesInterface.ColoredShape2d
import lab5.comparator.AreaComparator
import lab5.comparator.RadiusComparator
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ShapeCollectorTest { //Tests only for new funs
    private val color1 = ColorRGBA(1, 1, 1, 1.0)
    private val color2 = ColorRGBA(2, 2, 2, 0.5)
    private val color3 = ColorRGBA(3, 3, 3, 0.0)

    private val circle1 = Circle(1.0, color1, color2)
    private val circle2 = Circle(2.0, color1, color3)
    private val triangle = Triangle(3.0, 4.0, 5.0, color2, color1)
    private val rectangle = Rectangle(6.0, 7.0, color2, color3)
    private val square1 = Square(8.0, color3, color1)
    private val square2 = Square(9.0, color3, color2)

    private val fullShapeList = listOf(circle1, rectangle, square1, triangle, circle2, square2)

    private val fullShapeCollection = ShapeCollector(fullShapeList)

    @Test
    fun addAll() {

        val testShapeCollection = ShapeCollector(emptyList<ColoredShape2d>())
        val shapeList = fullShapeCollection.getShapeList()

        testShapeCollection.addAll(shapeList)
        assertEquals(shapeList, testShapeCollection.getShapeList())

        val smallShapeList = listOf(circle1, rectangle)
        testShapeCollection.addAll(smallShapeList)
        val fullShapeList = shapeList + smallShapeList

        assertEquals(fullShapeList, testShapeCollection.getShapeList())
    }

    @Test
    fun getSorted() {
        fullShapeCollection.getSorted(AreaComparator())
        val sortedList = listOf(circle1, triangle, circle2, rectangle, square1, square2)
        assertEquals(sortedList, fullShapeCollection.getShapeList())

        val circleList = listOf(circle2, circle1)
        val sortedCircleList = listOf(circle1, circle2)
        val circleCollection = ShapeCollector(circleList)
        circleCollection.getSorted(RadiusComparator())
        assertEquals(sortedCircleList, circleCollection.getShapeList())
        assertFalse(circleList == circleCollection.getShapeList())
    }
}