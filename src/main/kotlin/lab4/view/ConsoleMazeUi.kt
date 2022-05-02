package lab4.view

import lab4.model.Maze
import lab4.model.ModelChangeListener

class ConsoleMazeUi(private val maze: Maze) {
    init {
        val listener = object : ModelChangeListener {
            override fun onModelChanged() {
                repaint()
            }
        }
        maze.addModelChangeListener(listener)

        repaint()
    }

    private fun repaint() {
        //Runtime.getRuntime().exec("clear") // Doesn't work
        println(maze)
        if (maze.isWin)
            println("You win!")
    }
}