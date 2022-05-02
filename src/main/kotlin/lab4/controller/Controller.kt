package lab4.controller

import lab4.model.Direction
import lab4.model.Maze

class Controller(private val maze: Maze) {
    init {
        startGame()
    }

    private fun startGame() {
        var isExit = false
        while (!maze.isWin && !isExit) {
            val input = readln()
            for (i in input.indices) {
                try {
                    when (input[i]) {
                        'w' -> maze.doMove(Direction.UP)
                        's' -> maze.doMove(Direction.DOWN)
                        'd' -> maze.doMove(Direction.RIGHT)
                        'a' -> maze.doMove(Direction.LEFT)
                        'e' -> {
                            println("Get the FileName...")
                            val fileName = readln()
                            maze.writeMazeToFile(fileName)
                            isExit = true
                            break
                        }
                        else -> throw IllegalArgumentException("Incorrect direction")
                    }

                } catch (e: Exception) {
                    println(e.message)
                }
            }
        }
    }

}