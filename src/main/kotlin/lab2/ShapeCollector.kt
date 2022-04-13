package lab2


class ShapeCollector<T : ColoredShape2d> : ShapeCollectorView {


    private val listOfAllShape = mutableListOf<ColoredShape2d>()

    //http://developer.alexanderklimov.ru/android/kotlin/collection.php#filter
    override fun addShapeToList(newShape : ColoredShape2d) {
        listOfAllShape.add(newShape)
    }

    override fun shapeWithMaxArea() : ColoredShape2d? = listOfAllShape.maxByOrNull { it.calcArea() }
    override fun shapeWithMinArea() : ColoredShape2d? = listOfAllShape.minByOrNull { it.calcArea() }
    override fun sumAreaOfAllShapes() : Double = listOfAllShape.sumOf { it.calcArea() }
    override fun searchForAllShapesByFillColor(fillColor : Color) : List<ColoredShape2d> =
        listOfAllShape.filter { it.fillColor == fillColor }

    override fun searchForAllShapesByBorderColor(borderColor : Color) : List<ColoredShape2d> =
        listOfAllShape.filter { it.borderColor == borderColor }

    override fun quantityAllShapesInList() : Int = listOfAllShape.size
    override fun allShapesInList() : List<ColoredShape2d> = listOfAllShape
    override fun groupByBorderColor() : Map<Color, List<ColoredShape2d>> = listOfAllShape.groupBy { it.borderColor }
    override fun groupByColorFill() : Map<Color, List<ColoredShape2d>> = listOfAllShape.groupBy { it.fillColor }
    override fun sortByType(sort : String) : List<ColoredShape2d> = listOfAllShape.filter { it.toString() == sort }

}
























