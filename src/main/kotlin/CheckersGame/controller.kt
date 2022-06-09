package CheckersGame

class Controller(private val model: ModelGame) {
    init {
        startGame()
    }

    private fun startGame() {
        while (model.state in GAME_NOT_FINISHED) {
            val input = readln()
            try {
                val colStart = input.substringBefore(" ").toInt() - 1
                val rowStart = input.substringAfter(" ").toInt() - 1
                val colEnd = input.substringBefore(" ").toInt() - 1
                val rowEnd = input.substringAfter(" ").toInt() - 1
                println(colStart)
                print(rowStart)
                println("---")

                println(colEnd)
                print(rowEnd)

                //model.moveCheckers(colStart, colStart,colEnd,rowEnd)
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}