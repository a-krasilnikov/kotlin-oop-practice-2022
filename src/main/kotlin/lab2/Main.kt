@file:Suppress("UNCHECKED_CAST")

package lab2

import lab2.shapes.Circle
import lab2.shapes.Rectangle
import lab2.shapes.Square
import lab2.shapes.Triangle
import lab2.shapesInterface.ColoredShape2d

fun main(){
    val color1  = ColorRGBA(1.0, 0.0, 0.0, 0.0)
    val color2  = ColorRGBA(2.0, 0.0, 0.0, 0.0)
    val color3  = ColorRGBA(3.0, 0.0, 0.0, 0.0)
    val circle = Circle(1.0, color1, color1)
    val rectangle = Rectangle( 4.0, 5.0, color2, color1  )
    val square = Square(2.0, color1, color2)
    val triangle = Triangle(3.0, 4.0, 6.8, color1, color2)
    val circle2 = Circle(1.0, color1, color1)

    val shapeCollection = ShapeCollector( listOf(circle, rectangle, square, triangle, circle2) as List<ColoredShape2d>)
    val groupedList = shapeCollection.groupByType()
    print (groupedList)
    //val shapeList = listOf(circle, rectangle, square, triangle)
    //print(shapeList[0].javaClass)

}