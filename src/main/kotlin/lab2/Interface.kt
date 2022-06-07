package lab2


interface ShapeCollectorView<T : ColoredShape2d> {
    fun addShapeToList(newShape : T)
    fun shapeWithMaxArea() : ColoredShape2d?
    fun shapeWithMinArea() : ColoredShape2d?
    fun sumAreaOfAllShapes() : Double
    fun searchForAllShapesByFillColor(fillColor : Color) : List<ColoredShape2d>?
    fun searchForAllShapesByBorderColor(borderColor : Color) : List<ColoredShape2d>?
    fun quantityAllShapesInList() : Int
    fun allShapesInList() : List<ColoredShape2d>?
    fun groupByBorderColor() : Map<Color, List<ColoredShape2d>>
    fun groupByColorFill() : Map<Color, List<ColoredShape2d>>
    fun filterByType(shape : Class<out T>) : List<T>
    fun addAll(newShapes : List<T>)
    fun getSorted(comparatorForShape : Comparator<in T>)

}