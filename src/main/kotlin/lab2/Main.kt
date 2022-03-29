@file:Suppress("UNCHECKED_CAST")

package lab2

import lab2.shapes.Circle
import lab2.shapes.Rectangle
import lab2.shapes.Square
import lab2.shapes.Triangle

fun main() {
    val color1 = ColorRGBA(1.0, 1.0, 1.0, 1.0)
    val color2 = ColorRGBA(2.0, 2.0, 2.0, 2.0)
    val color3 = ColorRGBA(3.0, 3.0, 3.0, 3.0)

    val circle1 = Circle(1.0, color1, color2)
    val circle2 = Circle(2.0, color1, color3)
    val rectangle = Rectangle(4.0, 5.0, color2, color1)
    val square1 = Square(6.0, color2, color3)
    val square2 = Square(7.0, color3, color1)
    val triangle = Triangle(8.0, 9.0, 10.0, color3, color1)

    val shapeCollection = ShapeCollector(listOf(circle1, rectangle, square1, triangle))
    println("ShapeCollection: ${shapeCollection.getShapeList()}")
    println("Size of shapeCollection: ${shapeCollection.getShapeListSize()}\n")

    println("Adding second circle and square...")
    shapeCollection.add(circle2)
    shapeCollection.add(square2)
    println("ShapeCollection: ${shapeCollection.getShapeList()}")
    println("Size of shapeCollection: ${shapeCollection.getShapeListSize()}\n")

    println("Total area: ${shapeCollection.getTotalArea()}\n")
    println("Min areas: ${shapeCollection.minAreaFilter()}\n")
    println("Max areas: ${shapeCollection.maxAreaFilter()}\n")

    println("Filter by borderColor(ColorRGBA( 1.0, 1.0, 1.0, 1.0)): ${shapeCollection.borderColorRGBAFilter(color1)}\n")
    println("Filter by fillColor(ColorRGBA( 1.0, 1.0, 1.0, 1.0)): ${shapeCollection.fillColorRGBAFilter(color1)}\n")

    println("Group by fillColor: ${shapeCollection.groupByFillColorRGBA()}\n")
    println("Group by borderColor: ${shapeCollection.groupByBorderColorRGBA()}\n")

    println("Group by type: ${shapeCollection.groupByType()}\n")
}