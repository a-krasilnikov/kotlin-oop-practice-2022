@file:Suppress("UNCHECKED_CAST")

package lab6

import lab6.shapeCollector.ShapeCollector
import lab6.shapes.Circle
import lab6.shapes.Rectangle
import lab6.shapes.Square
import lab6.shapes.Triangle
import lab6.shapesInterface.ColoredShape2d
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.*
import lab6.serializationUtil.ShapeCollectorSerializationUtil
import lab6.serializationUtil.ShapeSerializationUtil


fun main() {
    val color1 = ColorRGBA(1, 1, 1, 1.0)
    val color2 = ColorRGBA(2, 2, 2, 0.5)
    val color3 = ColorRGBA(3, 3, 3, 0.0)

    val circle1 = Circle(1.0, color1, color2)
    val circle2 = Circle(2.0, color1, color3)
    val triangle = Triangle(3.0, 4.0, 5.0, color2, color1)
    val rectangle = Rectangle(6.0, 7.0, color2, color3)
    val square1 = Square(8.0, color3, color1)
    val square2 = Square(9.0, color3, color2)

    val shapeCollection = ShapeCollector(listOf(circle1, rectangle, square1, triangle))

    val json = Json {
        prettyPrint = true
        serializersModule = SerializersModule {
            polymorphic(ColoredShape2d::class) {
                subclass(Circle::class)
                subclass(Rectangle::class)
                subclass(Square::class)
                subclass(Triangle::class)
            }

        }
    }

    val shapeCollectionJson = ShapeCollectorSerializationUtil.serialization(shapeCollection)
    println(shapeCollectionJson)

    val shapeJson = ShapeSerializationUtil.serialization(triangle)
    println(shapeJson)

    println(ShapeSerializationUtil.deserialization(shapeJson))
}