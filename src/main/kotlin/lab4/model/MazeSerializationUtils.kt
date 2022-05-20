package lab4.model

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

object MazeSerializationUtils {
    private val json = Json

    fun serialization(maze: MutableList<MutableList<Maze.Cell>>) =
        json.encodeToString(maze)

    fun deserialization(stringToDecoder: String) =
        json.decodeFromString<MutableList<MutableList<Maze.Cell>>>(stringToDecoder)

}
