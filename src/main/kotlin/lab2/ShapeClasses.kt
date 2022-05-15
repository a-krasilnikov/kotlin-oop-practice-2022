package lab2


interface Shape2d {
    fun calcArea() : Double
}


interface ColoredShape2d : Shape2d {
    val borderColor : Color
    val fillColor : Color
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


data class Square(
    val side : Double,
    override val borderColor : Color,
    override val fillColor : Color,
) : ColoredShape2d {

    override fun calcArea() : Double = side * side
}

data class Rectangle(
    val height : Double,
    val width : Double,
    override val borderColor : Color,
    override val fillColor : Color,
) : ColoredShape2d {
    init {
        if ((height <= 0.0) || (width <= 0.0)) {
            throw IllegalArgumentException("The value must be between 1 and +inf: ")
        }
    }

    override fun calcArea() : Double = height * width
}

data class Triangle(
    val height : Double,
    val side : Double,
    override val borderColor : Color,
    override val fillColor : Color,
) : ColoredShape2d {
    init {
        if ((height <= 0.0) || (side <= 0.0)) {
            throw IllegalArgumentException("The value must be between 1 and +inf: ")
        }
    }

    override fun calcArea() : Double = height * side * 0.5
}

data class Circle(
    val radius : Double,
    override val borderColor : Color,
    override val fillColor : Color,
) : ColoredShape2d {

    init {
        if (radius <= 0.0) {
            throw IllegalArgumentException("The value must be between 1 and +inf: ")
        }
    }

    override fun calcArea() : Double = radius * radius * 3.14
}