@file:Suppress("UNCHECKED_CAST")

package lab6

import lab6.shapeCollector.ShapeCollector
import lab6.shapes.Circle
import lab6.shapes.Rectangle
import lab6.shapes.Square
import lab6.shapes.Triangle
import lab6.serializationUtil.ShapeCollectorSerializationUtil


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

    var shapeCollection = ShapeCollector(listOf(circle1, rectangle, square1, triangle))

    //write shapeCollection to the file1.txt
    ShapeCollectorSerializationUtil.serializationToFile(shapeCollection, "file1.txt")

    //read shapeCollection from the file1.txt
    shapeCollection = ShapeCollectorSerializationUtil.deserializationFromFile("file1.txt")


    //add new shapes to the shapeCollection
    shapeCollection.add(circle2)
    shapeCollection.add(square2)

    //write shapeCollection to the file2.txt
    ShapeCollectorSerializationUtil.serializationToFile(shapeCollection, "file2.txt")
}