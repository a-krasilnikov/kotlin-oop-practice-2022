package lab6.serializationUtil

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import lab6.shapeCollector.ShapeCollector
import lab6.shapes.Circle
import lab6.shapes.Rectangle
import lab6.shapes.Square
import lab6.shapes.Triangle
import lab6.shapesInterface.ColoredShape2d
import java.io.File

object ShapeCollectorSerializationUtil {
    val json = Json {
        serializersModule = SerializersModule {
            polymorphic(ColoredShape2d::class) {
                subclass(Circle::class)
                subclass(Rectangle::class)
                subclass(Square::class)
                subclass(Triangle::class)
            }
        }
    }

    fun serialization(shapeCollection: ShapeCollector) =
        json.encodeToString(shapeCollection)

    fun deserialization(stringToDecoder: String) =
        json.decodeFromString<ShapeCollector>(stringToDecoder)

    fun serializationToFile(shapeCollection: ShapeCollector, fileName: String) {
        File(fileName).writeText(serialization(shapeCollection))
    }

    fun deserializationFromFile(fileName: String): ShapeCollector {
        val file = File(fileName)
        if (!file.exists())
            throw IllegalArgumentException("Incorrect file name")

        return deserialization(file.readText())
    }

}