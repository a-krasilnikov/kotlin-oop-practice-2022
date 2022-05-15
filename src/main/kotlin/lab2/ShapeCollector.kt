package lab2


class ShapeCollector<T : ColoredShape2d>(newList : List<T>) : ShapeCollectorView<T> {


    private val listOfAllShape : MutableList<T>

    //http://developer.alexanderklimov.ru/android/kotlin/collection.php#filter
    override fun addShapeToList(newShape : T) {
        listOfAllShape.add(newShape)
    }
    override fun addAll(newShapes : List<T>) {
        listOfAllShape += newShapes
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
    override fun <T : ColoredShape2d> filterByType(shape : Class<T>) : List<ColoredShape2d> = listOfAllShape.filterIsInstance(shape)
    override fun getSorted(comparatorForShape : Comparator<T>) = listOfAllShape.sortWith(comparatorForShape)

    init {
        listOfAllShape = newList.toMutableList()
    }

}
























