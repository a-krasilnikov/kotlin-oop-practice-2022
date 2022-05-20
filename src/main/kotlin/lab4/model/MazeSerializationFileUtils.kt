package lab4.model

import java.io.File

object MazeSerializationFileUtils {
    fun serializationToFile(mazeData: MutableList<MutableList<Maze.Cell>>, fileName: String) {
        File(fileName).writeText(MazeSerializationUtils.serialization(mazeData))
    }

    fun deserializationFromFile(fileName: String): Maze {
        val file = File(fileName)
        if (!file.exists())
            throw IllegalArgumentException("Incorrect file name")

        return Maze(MazeSerializationUtils.deserialization(file.readText()))
    }
}