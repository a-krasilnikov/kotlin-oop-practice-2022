package lab4.model

import kotlinx.serialization.Serializable

interface ModelChangeListener {
    fun onModelChanged()
}

enum class Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;
}

class Maze(_mazeData: List<List<Cell>>) {

    private var mazeData: MutableList<MutableList<Cell>>

    var isWin: Boolean
        private set

    private var currI: Int

    private var currJ: Int

    init {
        //copy mazeData
        mazeData = mutableListOf()
        for (i in _mazeData.indices)
            mazeData.add(_mazeData[i].toMutableList())

        //find current location
        currI = -1
        currJ = -1
        isWin = true


        for (i in _mazeData.indices)
            for (j in 0 until _mazeData[0].size) {
                if (_mazeData[i][j] == Cell.PLAYER) {
                    currI = i
                    currJ = j
                }
                if (_mazeData[i][j] == Cell.FINISH)
                    isWin = false
            }

        if (currI == -1 || currJ == -1)
            throw IllegalArgumentException("Maze should have player")
    }

    @Serializable
    enum class Cell(private val textValue: String) {
        WALL("■"),
        EMPTY(" "),
        PLAYER("\uD83D\uDE0A"),
        FINISH("⚑");

        override fun toString(): String = textValue
    }

    private val listeners: MutableSet<ModelChangeListener> = mutableSetOf()

    fun addModelChangeListener(listener: ModelChangeListener) {
        listeners.add(listener)
    }

    fun removeModelChangeListener(listener: ModelChangeListener) {
        listeners.remove(listener)
    }

    private fun notifyListeners() {
        listeners.forEach { it.onModelChanged() }
    }

    fun getMazeData() = mazeData.toMutableList()

    private fun isCellEmpty(i: Int, j: Int) =
        i >= 0 && j >= 0 && i < mazeData.size && j < mazeData[0].size && (mazeData[i][j] == Cell.EMPTY || mazeData[i][j] == Cell.FINISH)

    private fun moveThePlayer(i: Int, j: Int) {
        if (isCellEmpty(i, j)) {
            mazeData[currI][currJ] = Cell.EMPTY
            isWin = (mazeData[i][j] == Cell.FINISH)
            mazeData[i][j] = Cell.PLAYER
            currI = i
            currJ = j
        } else
            throw IllegalArgumentException("Can't move there!")

    }

    fun doMove(playersMove: Direction) {
        require(!isWin) { "Game is over!" }
        when (playersMove) {
            Direction.UP -> moveThePlayer(currI - 1, currJ)
            Direction.DOWN -> moveThePlayer(currI + 1, currJ)
            Direction.LEFT -> moveThePlayer(currI, currJ - 1)
            Direction.RIGHT -> moveThePlayer(currI, currJ + 1)
        }
        notifyListeners()
    }

    override fun toString(): String {
        return buildString {
            mazeData.forEach { line ->
                line.forEach {
                    if (it == Cell.PLAYER) append(it).append(' ')
                    else
                        append(it).append(' ')
                }
                append('|').appendLine()
            }
            for (i in 0 until mazeData[0].size)
                append("‾ ")
        }
    }
}
