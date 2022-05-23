package lab2

fun main() {
    //Main for lab 6
    val emptyList = mutableListOf<ColoredShape2d>()
    val serializationsDeserializationJson = SerializationsDeserializationJson()

    val shapes = ShapeCollector(emptyList).also {
        it.addShapeToList(Rectangle(100.0, 100.0, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
        it.addShapeToList(Square(1.1, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
        it.addShapeToList(Triangle(30.0, 40.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
        it.addShapeToList(Circle(0.2, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
    }

    val listJson = serializationsDeserializationJson.serialization(shapes.allShapesInList())

    serializationsDeserializationJson.outputToFile(listJson,
        "C:\\Users\\DASHA\\IdeaProjects\\kotlin-oop-practice-2022\\src\\main\\kotlin\\lab2\\out.json")


    val input =
        serializationsDeserializationJson.inputFromFile("C:\\Users\\DASHA\\IdeaProjects\\kotlin-oop-practice-2022\\src\\main\\kotlin\\lab2\\out.json")
    val deserializationList = serializationsDeserializationJson.deserialization(input)
    println(deserializationList)
    val newShapesDeserialisation = ShapeCollector(deserializationList)

    println(newShapesDeserialisation.shapeWithMaxArea()?.calcArea())
    println(newShapesDeserialisation.shapeWithMinArea()?.calcArea())
    println(newShapesDeserialisation.sumAreaOfAllShapes())
    println(newShapesDeserialisation.searchForAllShapesByFillColor(Color(7, 8, 5, 78)))
    println(newShapesDeserialisation.searchForAllShapesByBorderColor(Color(1, 2, 3, 96)))
    println(newShapesDeserialisation.quantityAllShapesInList())
    println(newShapesDeserialisation.allShapesInList())
    println(newShapesDeserialisation.groupByBorderColor())
    println(newShapesDeserialisation.groupByColorFill())


    //Main for lab 2 and 5
    /*val newShapes = ShapeCollector(emptyList).also {
        it.addShapeToList(Rectangle(100.0, 100.0, Color(1, 8, 9, 78), Color(7, 5, 5, 17)))
        it.addShapeToList(Square(1.1, Color(5, 6, 3, 87), Color(81, 9, 45, 5)))
        it.addShapeToList(Triangle(30.0, 40.0, Color(1, 4, 7, 81), Color(43, 45, 14, 58)))
        it.addShapeToList(Circle(0.2, Color(6, 7, 4, 96), Color(46, 44, 12, 47)))
    }

    val newShapesOne = ShapeCollector(emptyList).also {
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

    newShapes.getSorted(compareBy(ColoredShape2d::calcArea))
    println("after get sorted by area")
    println(newShapes.allShapesInList())
    //newShapes.getSorted(r)*/
}




