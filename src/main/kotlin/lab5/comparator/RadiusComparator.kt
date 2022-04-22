package lab5.comparator

import lab2.shapes.Circle

class RadiusComparator : Comparator<Circle> {
    override fun compare(a: Circle, b: Circle): Int {
        return if (a.radius == b.radius)
            0
        else
            if (a.radius > b.radius)
                1
            else
                -1
    }
}