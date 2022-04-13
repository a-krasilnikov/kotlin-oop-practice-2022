package lab2

fun main() {


    val newShapes = ShapeCollector<ColoredShape2d>().also {
        it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
        it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
        it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
        it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
    }

    val newShapesOne = ShapeCollector<ColoredShape2d>().also {
        it.addShapeToList(Rectangle(2.3, 5.5, Color(28, 71, 93, 7), Color(85, 71, 17, 77)))
    }

    println(newShapes.shapeWithMaxArea()?.calcArea())
    println(newShapesOne.shapeWithMinArea()?.calcArea())
    println(newShapes.sumAreaOfAllShapes())
    println(newShapes.searchForAllShapesByFillColor(Color(7, 8, 5, 78)))
    println(newShapesOne.searchForAllShapesByBorderColor(Color(1, 2, 3, 96)))
    println(newShapes.quantityAllShapesInList())
    println(newShapes.allShapesInList())
    println(newShapesOne.groupByBorderColor())
    println(newShapes.groupByColorFill())


}