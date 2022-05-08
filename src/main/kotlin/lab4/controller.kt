package lab4

import lab4.ModelMaze
import lab4.State
import lab4.Move

class Controller(private val model : ModelMaze) {
    init {
        newGame()
    }

    private fun newGame() {
        while (model.state == State.MOVE_PROCESS) {

            val input = readln().toCharArray()[0]
            try {
                val action = when (input) {

                    'w' -> Move.UP_MOVE
                    's' -> Move.DOWN_MOVE
                    'a' -> Move.LEFT_MOVE
                    'd' -> Move.RIGHT_MOVE
                    'o' -> Move.SAVE
                    'e' -> Move.ESC
                    else -> {
                        return
                    }

                }
                model.doMove(action)


            } catch (e : Exception) {
                println(e.message)
            }

        }
    }

}