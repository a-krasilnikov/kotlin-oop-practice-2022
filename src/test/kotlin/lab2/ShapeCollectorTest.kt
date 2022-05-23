package lab2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ShapeCollectorTest {

    @Test
    fun addShapeToList() {
        val emptyList = mutableListOf<ColoredShape2d>()
        val newShapes = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }
        val newShapesOne = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(newShapes.quantityAllShapesInList(), newShapesOne.quantityAllShapesInList())


    }

    @Test
    fun shapeWithMaxArea() {
        val emptyList = mutableListOf<ColoredShape2d>()
        val newShapesOne = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(50.0, 55.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(newShapesOne.allShapesInList()[0], newShapesOne.shapeWithMaxArea())


    }

    @Test
    fun shapeWithMinArea() {
        val emptyList = mutableListOf<ColoredShape2d>()
        val newShapesOne = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(50.0, 55.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(newShapesOne.allShapesInList()[2], newShapesOne.shapeWithMinArea())

    }

    @Test
    fun sumAreaOfAllShapes() {

        val emptyList = mutableListOf<ColoredShape2d>()
        val newShapes = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }
        val newShapesOne = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(newShapes.sumAreaOfAllShapes(), newShapesOne.sumAreaOfAllShapes())

    }

    @Test
    fun searchForAllShapesByFillColor() {
        val emptyList = mutableListOf<ColoredShape2d>()
        val newShapes = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }
        val newShapesOne = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(
            newShapes.searchForAllShapesByFillColor(Color(7, 8, 5, 78)),
            newShapesOne.searchForAllShapesByFillColor(Color(7, 8, 5, 78))
        )
    }

    @Test
    fun searchForAllShapesByBorderColor() {
        val emptyList = mutableListOf<ColoredShape2d>()
        val newShapes = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }
        val newShapesOne = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(
            newShapes.searchForAllShapesByBorderColor(Color(7, 8, 5, 78)),
            newShapesOne.searchForAllShapesByBorderColor(Color(7, 8, 5, 78))
        )

    }

    @Test
    fun quantityAllShapesInList() {
        val emptyList = mutableListOf<ColoredShape2d>()
        val newShapes = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }


        assertEquals(newShapes.quantityAllShapesInList(), 4)

    }

    @Test
    fun allShapesInList() {
        val emptyList = mutableListOf<ColoredShape2d>()
        val newShapes = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }
        val newShapesOne = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(newShapes.allShapesInList(), newShapesOne.allShapesInList())
    }

    @Test
    fun groupByBorderColor() {
        val emptyList = mutableListOf<ColoredShape2d>()
        val newShapes = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }
        val newShapesOne = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(newShapes.groupByColorFill(), newShapesOne.groupByColorFill())
    }

    @Test
    fun groupByColorFill() {
        val emptyList = mutableListOf<ColoredShape2d>()
        val newShapes = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }
        val newShapesOne = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }

        assertEquals(newShapes.groupByColorFill(), newShapesOne.groupByColorFill())
    }

    @Test
    fun sortByType() {

        val emptyList = mutableListOf<ColoredShape2d>()
        val newShapes = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }
        val newShapesOne = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
        }
        assertEquals(newShapes.filterByType(Rectangle::class.java), newShapesOne.allShapesInList())
    }

    @Test
    fun addAll() {

        val emptyList = mutableListOf<ColoredShape2d>()
        val newShapes = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
        }


        val newShapesOne = ShapeCollector(emptyList).also {
            it.addShapeToList(Rectangle(2.3, 5.5, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
            it.addShapeToList(Square(9.0, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
            it.addShapeToList(Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
        }
        newShapes.addAll(
            listOf(
                Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)),
                Circle(3.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47))
            )

        )
        assertEquals(newShapes.quantityAllShapesInList(), newShapesOne.quantityAllShapesInList())

    }

    @Test
    fun getSorted() {

        val emptyList = mutableListOf<ColoredShape2d>()
        val newShapes = ShapeCollector(emptyList).also {
            it.addShapeToList(Circle(100.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))

        }

        newShapes.getSorted(compareBy(ColoredShape2d::calcArea))
        assertEquals(
            newShapes.allShapesInList(), listOf(
                (Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58))),
                Circle(100.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47))
            )
        )


    }

    @Test
    fun SerializationsDeserializationJsonLogic() {
        val emptyList = mutableListOf<ColoredShape2d>()
        val serializationsDeserializationJsonLogic = lab2.SerializationsDeserializationJson()

        val shapeCollection = ShapeCollector(emptyList).also {
            it.addShapeToList(Circle(100.0, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
            it.addShapeToList(Triangle(2.5, 4.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
        }

        val listJson = serializationsDeserializationJsonLogic.serialization(shapeCollection.allShapesInList())

        serializationsDeserializationJsonLogic.outputToFile(listJson,
            "C:\\Users\\DASHA\\IdeaProjects\\kotlin-oop-practice-2022\\src\\main\\kotlin\\lab2\\out.json")


        val input =
            serializationsDeserializationJsonLogic.inputFromFile("C:\\Users\\DASHA\\IdeaProjects\\kotlin-oop-practice-2022\\src\\main\\kotlin\\lab2\\out.json")
        val deserializationList = serializationsDeserializationJsonLogic.deserialization(input)
        println(deserializationList)

        val newShapesDeserialisation = ShapeCollector(deserializationList)

        assertEquals(
            newShapesDeserialisation.allShapesInList(), shapeCollection.allShapesInList()
        )
    }
}