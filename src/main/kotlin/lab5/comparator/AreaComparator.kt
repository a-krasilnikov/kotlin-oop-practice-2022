package lab5.comparator

import lab2.shapesInterface.ColoredShape2d

class AreaComparator : Comparator<ColoredShape2d> {
    override fun compare(a: ColoredShape2d, b: ColoredShape2d): Int {
        return if (a.area == b.area)
            0
        else
            if (a.area > b.area)
                1
            else
                -1
    }
}