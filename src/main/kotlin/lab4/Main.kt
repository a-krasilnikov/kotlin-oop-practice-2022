package lab4

import lab4.controller.Controller
import lab4.model.Maze
import lab4.view.ConsoleMazeUi

fun main() {
    val fileName = "inputModel.txt"
    val maze = Maze(fileName)
    val view = ConsoleMazeUi(maze)
    val controller = Controller(maze)
}
