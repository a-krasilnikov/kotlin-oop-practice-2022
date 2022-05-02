package lab6

import kotlinx.serialization.encodeToString
import lab6.serializationUtil.ShapeCollectorSerializationUtil
import lab6.shapeCollector.ShapeCollector
import lab6.shapes.Circle
import lab6.shapes.Rectangle
import lab6.shapes.Square
import lab6.shapes.Triangle
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertTrue

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

    private val shapeCollection1 = ShapeCollector(shapeList1)
    private val shapeCollection2 = ShapeCollector(shapeList2)
    private val shapeCollection3 = ShapeCollector(shapeList3)

    private val jsonShapeCollection1: String = ShapeCollectorSerializationUtil.serialization(shapeCollection1)
    private val jsonShapeCollection2: String = ShapeCollectorSerializationUtil.serialization(shapeCollection2)
    private val jsonShapeCollection3: String = ShapeCollectorSerializationUtil.serialization(shapeCollection3)


    @Test
    fun serialization() {
        assertEquals(ShapeCollectorSerializationUtil.json.encodeToString(shapeCollection1), jsonShapeCollection1)
        assertEquals(ShapeCollectorSerializationUtil.json.encodeToString(shapeCollection2), jsonShapeCollection2)
        assertEquals(ShapeCollectorSerializationUtil.json.encodeToString(shapeCollection3), jsonShapeCollection3)

    }


    @Test
    fun deserialization() {
        assertEquals(shapeCollection1, ShapeCollectorSerializationUtil.deserialization(jsonShapeCollection1))
        assertEquals(shapeCollection2, ShapeCollectorSerializationUtil.deserialization(jsonShapeCollection2))
        assertEquals(shapeCollection3, ShapeCollectorSerializationUtil.deserialization(jsonShapeCollection3))

    }

    @Test
    fun serializationToFile() {
        ShapeCollectorSerializationUtil.serializationToFile(shapeCollection1, "shapeCollection1.txt")
        ShapeCollectorSerializationUtil.serializationToFile(shapeCollection2, "shapeCollection2.txt")
        ShapeCollectorSerializationUtil.serializationToFile(shapeCollection3, "shapeCollection3.txt")

        val file1 = File("shapeCollection1.txt")
        val file2 = File("shapeCollection2.txt")
        val file3 = File("shapeCollection3.txt")
        assertTrue(file1.exists())
        assertTrue(file2.exists())
        assertTrue(file3.exists())



        assertEquals(jsonShapeCollection1, file1.readText())
        assertEquals(jsonShapeCollection2, file2.readText())
        assertEquals(jsonShapeCollection3, file3.readText())
    }

    @Test
    fun deserializationFromFile() {
        ShapeCollectorSerializationUtil.serializationToFile(shapeCollection1, "shapeCollection1.txt")
        ShapeCollectorSerializationUtil.serializationToFile(shapeCollection2, "shapeCollection2.txt")
        ShapeCollectorSerializationUtil.serializationToFile(shapeCollection3, "shapeCollection3.txt")

        assertEquals(shapeCollection1, ShapeCollectorSerializationUtil.deserializationFromFile("shapeCollection1.txt"))
        assertEquals(shapeCollection2, ShapeCollectorSerializationUtil.deserializationFromFile("shapeCollection2.txt"))
        assertEquals(shapeCollection3, ShapeCollectorSerializationUtil.deserializationFromFile("shapeCollection3.txt"))
    }
}