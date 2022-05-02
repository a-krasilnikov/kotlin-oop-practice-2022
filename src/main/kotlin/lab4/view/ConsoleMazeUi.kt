package lab4.view

import lab4.model.Maze
import lab4.model.ModelChangeListener

class ConsoleMazeUi(private val maze: Maze) {
    init {
        println("Welcome to maze!\n" +
                "You can run using the 'w'-'a'-'s'-'d'\n" +
                "or escape and save using 'e'\n" +
                "Catch the ⚑! Good luck!\n")

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