package CheckersGame

class Controller(private val model: ModelGame) {
    init {
        startGame()
    }

    private fun startGame() {
        while (model.state in GAME_NOT_FINISHED) {
            val input = readln()
            try {
                val col = input.substringBefore(" ").toInt() - 1
                val row = input.substringAfter(" ").toInt() - 1

                //model.doMove(col, row)
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}