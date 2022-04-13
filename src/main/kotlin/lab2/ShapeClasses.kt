package lab2


interface Shape2d {
    fun calcArea() : Double
}


interface ColoredShape2d : Shape2d {
    val borderColor : Color               //граница
    val fillColor : Color                 //заливка
}

data class Color(val red : Int, val green : Int, val blue : Int, val transparency : Int) {
    init {
        if ((red !in (0..255))) {
            throw IllegalAccessException("not included in the specified interval")
        }

        if ((green !in (0..255))) {
            throw IllegalAccessException("not included in the specified interval")
        }

        if ((blue !in (0..255))) {
            throw IllegalAccessException("not included in the specified interval")
        }
        if ((transparency !in (0..100))) {
            throw IllegalAccessException("not included in the specified interval")
        }
    }

}


// квадрат, прямогольник, треугольник,круг)
class Square(
    private val side : Double,
    override val borderColor : Color,
    override val fillColor : Color,
) : ColoredShape2d {

    override fun calcArea() : Double = side * side
}

class Rectangle(
    private val height : Double,
    private val width : Double,
    override val borderColor : Color,
    override val fillColor : Color,
) : ColoredShape2d {

    override fun calcArea() : Double = height * width
}

class Triangle(
    private val height : Double,
    private val side : Double,
    override val borderColor : Color,
    override val fillColor : Color,
) : ColoredShape2d {

    override fun calcArea() : Double = height * side * 0.5
}

class Circle(
    private val radius : Double,
    override val borderColor : Color,
    override val fillColor : Color,
) : ColoredShape2d {

    override fun calcArea() : Double = radius * radius * 3.14
}