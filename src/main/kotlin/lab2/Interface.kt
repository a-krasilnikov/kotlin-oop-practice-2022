package lab2


interface ShapeCollectorView {
    fun addShapeToList(newShape : ColoredShape2d)
    fun shapeWithMaxArea() : ColoredShape2d?
    fun shapeWithMinArea() : ColoredShape2d?
    fun sumAreaOfAllShapes() : Double
    fun searchForAllShapesByFillColor(fillColor : Color) : List<ColoredShape2d>?
    fun searchForAllShapesByBorderColor(borderColor : Color) : List<ColoredShape2d>?
    fun quantityAllShapesInList() : Int
    fun allShapesInList() : List<ColoredShape2d>?
    fun groupByBorderColor() : Map<Color, List<ColoredShape2d>>
    fun groupByColorFill() : Map<Color, List<ColoredShape2d>>
    fun sortByType(sort : String) : List<ColoredShape2d>
}