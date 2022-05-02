package lab4.model

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

object MazeSerializationUtils {
    private val json = Json

    private fun serialization(maze: MutableList<MutableList<Maze.Cell>>) =
        json.encodeToString(maze)

    private fun deserialization(stringToDecoder: String) =
        json.decodeFromString<MutableList<MutableList<Maze.Cell>>>(stringToDecoder)

    fun serializationToFile(maze: MutableList<MutableList<Maze.Cell>>, fileName: String) {
        File(fileName).writeText(serialization(maze))
    }

    fun deserializationFromFile(fileName: String): MutableList<MutableList<Maze.Cell>> {
        val file = File(fileName)
        if (!file.exists())
            throw IllegalArgumentException("Incorrect file name")

        return deserialization(file.readText())
    }

}
