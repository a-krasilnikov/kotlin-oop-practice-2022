package lab6.serializationUtil

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import lab6.shapes.Circle
import lab6.shapes.Rectangle
import lab6.shapes.Square
import lab6.shapes.Triangle
import lab6.shapesInterface.ColoredShape2d
import java.io.File


object ShapeSerializationUtil {
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

    fun serialization(shape: ColoredShape2d) = json.encodeToString(shape)

    inline fun <reified T : ColoredShape2d> deserialization(stringToDecoder: String) =
        json.decodeFromString<T>(stringToDecoder)


    fun serializationToFile(shape: ColoredShape2d, fileName: String) {
        File(fileName).writeText(serialization(shape))
    }

    fun deserializationFromFile(fileName: String): ColoredShape2d {
        val file = File(fileName)
        if (!file.exists())
            throw IllegalArgumentException("Incorrect file name")

        return deserialization(file.readText())
    }

}