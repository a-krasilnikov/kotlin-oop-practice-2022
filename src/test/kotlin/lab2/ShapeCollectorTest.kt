package lab2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ShapeCollectorTest {

    @Test
    fun addShapeToList() {
        val newShapes = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }
        val newShapesOne = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(newShapes.quantityAllShapesInList(), newShapesOne.quantityAllShapesInList())


    }

    @Test
    fun shapeWithMaxArea() {

        val newShapesOne = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(50.0, 55.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(newShapesOne.allShapesInList()[0], newShapesOne.shapeWithMaxArea())


    }

    @Test
    fun shapeWithMinArea() {

        val newShapesOne = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(50.0, 55.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(newShapesOne.allShapesInList()[2], newShapesOne.shapeWithMinArea())

    }

    @Test
    fun sumAreaOfAllShapes() {
        val newShapes = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }
        val newShapesOne = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(newShapes.sumAreaOfAllShapes(), newShapesOne.sumAreaOfAllShapes())

    }

    @Test
    fun searchForAllShapesByFillColor() {

        val newShapes = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }
        val newShapesOne = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(newShapes.searchForAllShapesByFillColor(Color(7, 8, 5, 78)),
            newShapesOne.searchForAllShapesByFillColor(Color(7, 8, 5, 78)))
    }

    @Test
    fun searchForAllShapesByBorderColor() {
        val newShapes = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }
        val newShapesOne = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(newShapes.searchForAllShapesByBorderColor(Color(7, 8, 5, 78)),
            newShapesOne.searchForAllShapesByBorderColor(Color(7, 8, 5, 78)))

    }

    @Test
    fun quantityAllShapesInList() {
        val newShapes = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }
        val newShapesOne = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(newShapes.quantityAllShapesInList(), 4)

    }

    @Test
    fun allShapesInList() {
        val newShapes = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }
        val newShapesOne = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(newShapes.allShapesInList(), newShapesOne.allShapesInList())
    }

    @Test
    fun groupByBorderColor() {

        val newShapes = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }
        val newShapesOne = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(newShapes.groupByColorFill(), newShapesOne.groupByColorFill())
    }

    @Test
    fun groupByColorFill() {

        val newShapes = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }
        val newShapesOne = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(newShapes.groupByColorFill(), newShapesOne.groupByColorFill())
    }

    @Test
    fun sortByType() {
        val newShapes = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }
        val newShapesOne = ShapeCollector<ColoredShape2d>().also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(newShapes.sortByType("Rectangle"), newShapesOne.sortByType("Rectangle"))
    }
}