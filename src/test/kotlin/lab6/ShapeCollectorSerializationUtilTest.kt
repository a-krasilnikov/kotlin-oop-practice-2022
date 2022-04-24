package lab6

import lab2.ColorRGBA
import lab2.shapeCollector.ShapeCollector
import lab2.shapes.Circle
import lab2.shapes.Rectangle
import lab2.shapes.Square
import lab2.shapes.Triangle
import lab2.shapesInterface.ColoredShape2d
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ShapeCollectorSerializationUtilTest {
    private val color1 = ColorRGBA(1, 1, 1, 1.0)
    private val color2 = ColorRGBA(2, 2, 2, 0.5)
    private val color3 = ColorRGBA(3, 3, 3, 0.0)

    private val circle1 = Circle(1.0, color1, color2)
    private val circle2 = Circle(2.0, color1, color3)
    private val triangle = Triangle(3.0, 4.0, 5.0, color2, color1)
    private val rectangle = Rectangle(6.0, 7.0, color2, color3)
    private val square1 = Square(8.0, color3, color1)
    private val square2 = Square(9.0, color3, color2)

    private val shapeList1 = listOf(circle1, rectangle, square1, triangle)
    private val shapeList2 = listOf(circle1, triangle, circle2, square2)
    private val shapeList3 = listOf(circle1, rectangle, square1, triangle, circle2, square2)
    private val emptyShapeList = emptyList<ColoredShape2d>()

    private val shapeCollection1 = ShapeCollector(shapeList1)
    private val shapeCollection2 = ShapeCollector(shapeList2)
    private val shapeCollection3 = ShapeCollector(shapeList3)
    private val emptyShapeCollection = ShapeCollector(emptyShapeList)


    @Test
    fun serialization() {
    }

    @Test
    fun deserialization() {
    }

    @Test
    fun serializationToFile() {
    }

    @Test
    fun deserializationFromFile() {
    }
}