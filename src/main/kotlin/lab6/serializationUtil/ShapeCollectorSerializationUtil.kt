package lab6.serializationUtil

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import lab2.shapes.Circle
import lab2.shapes.Rectangle
import lab2.shapes.Square
import lab2.shapes.Triangle
import lab2.shapesInterface.ColoredShape2d
import java.io.File

object ShapeCollectorSerializationUtil {
    public val json = Json {
        serializersModule = SerializersModule {
            polymorphic(ColoredShape2d::class) {
                subclass(Circle::class)
                subclass(Rectangle::class)
                subclass(Square::class)
                subclass(Triangle::class)
            }
        }
    }

    fun serialization(shapeList: List<ColoredShape2d>) =
        json.encodeToString(shapeList)

    fun deserialization(stringToDecoder: String) =
        json.decodeFromString<List<ColoredShape2d>>(stringToDecoder)

    fun serializationToFile(shapeList: List<ColoredShape2d>, fileName: String) {
        File(fileName).writeText(serialization(shapeList))
    }

    fun deserializationFromFile(fileName: String): List<ColoredShape2d> {
        val file = File(fileName)
        if (!file.exists())
            throw IllegalArgumentException("Incorrect file name")

        return deserialization(file.readText())
    }

}