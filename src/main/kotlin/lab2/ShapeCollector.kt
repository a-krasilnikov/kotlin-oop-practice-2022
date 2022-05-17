package lab2


class ShapeCollector<T : ColoredShape2d>(newList : List<T>) : ShapeCollectorView<T> {


    private val listOfAllShape : MutableList<T>

    init {
        listOfAllShape = newList.toMutableList()
    }


    override fun addShapeToList(newShape : T) {
        listOfAllShape.add(newShape)
    }

    override fun addAll(newShapes : List<T>) {
        listOfAllShape += newShapes
    }

    override fun shapeWithMaxArea() : ColoredShape2d? = listOfAllShape.maxByOrNull { it.calcArea() }
    override fun shapeWithMinArea() : ColoredShape2d? = listOfAllShape.minByOrNull { it.calcArea() }
    override fun sumAreaOfAllShapes() : Double = listOfAllShape.sumOf { it.calcArea() }
    override fun searchForAllShapesByFillColor(fillColor : Color) : List<T> =
        listOfAllShape.filter { it.fillColor == fillColor }

    override fun searchForAllShapesByBorderColor(borderColor : Color) : List<T> =
        listOfAllShape.filter { it.borderColor == borderColor }

    override fun quantityAllShapesInList() : Int = listOfAllShape.size
    override fun allShapesInList() : List<T> = listOfAllShape
    override fun groupByBorderColor() : Map<Color, List<T>> = listOfAllShape.groupBy { it.borderColor }
    override fun groupByColorFill() : Map<Color, List<T>> = listOfAllShape.groupBy { it.fillColor }
    override fun filterByType(shape : Class<out T>) : List<T> = listOfAllShape.filterIsInstance(shape)
    override fun getSorted(comparatorForShape : Comparator<in T>) = listOfAllShape.sortWith(comparatorForShape)
}

//inline fun <reified T> isType(value: Any) = value is T ?
//https://russianblogs.com/article/7145452244/
//http://developer.alexanderklimov.ru/android/kotlin/collection.php#filter






















