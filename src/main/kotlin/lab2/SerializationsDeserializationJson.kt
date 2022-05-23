package lab2

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import java.io.File

object SerializationLogic {
    val json = Json {
        serializersModule = SerializersModule {
            polymorphic(ColoredShape2d::class) {
                subclass(Square::class)
                subclass(Rectangle::class)
                subclass(Triangle::class)
                subclass(Circle::class)
            }
        }
    }
}


class SerializationsDeserializationJson {

    fun serialization(list : List<ColoredShape2d>):String = SerializationLogic.json.encodeToString(list)

    fun deserialization(list : String): List<ColoredShape2d> = SerializationLogic.json.decodeFromString(list)

    fun inputFromFile(inputFile : String) : String {
        return File(inputFile).readText()
    }

    fun outputToFile(answer :String, outputFile : String) {
        File(outputFile).writeText(answer)
    }
}
