package lab4

import java.io.File



enum class State(private val textValue : String) {
    MOVE_PROCESS("lETS GO"),
    YOU_LOSE("YOU LOSE GAME"),
    YOU_WIN("YOU WIN GAME"),
    YOU_ESC("YOU STOPED GAME");

    override fun toString() : String = textValue
}


fun inputMaze() : Map<Pair<Int, Int>, Char> {
    var condition = "1"
    val input = emptyMap<Pair<Int, Int>, Char>()

    println("New Game? (press 1) to continue (press 0)")
    condition = readln()

    if (condition == "1") {
        val inputNew =
            File("C:\\Users\\DASHA\\IdeaProjects\\kotlin-oop-practice-2022\\src\\main\\kotlin\\lab4\\input").readLines()
                .withIndex().flatMap { indexedValue ->
                    val xCoordinate = indexedValue.index
                    indexedValue.value.toCharArray().withIndex().map { indexedChar ->
                        val yCoordinate = indexedChar.index
                        (xCoordinate to yCoordinate) to indexedChar.value
                    }
                }.toMap()
        return (inputNew)

    } else if (condition == "0") {
        val inputOut =
            File("C:\\Users\\DASHA\\IdeaProjects\\kotlin-oop-practice-2022\\src\\main\\kotlin\\lab4\\out.txt").readLines()
                .withIndex().flatMap { indexedValue ->
                    val xCoordinate = indexedValue.index
                    indexedValue.value.toCharArray().withIndex().map { indexedChar ->
                        val yCoordinate = indexedChar.index
                        (xCoordinate to yCoordinate) to indexedChar.value
                    }
                }.toMap()
        return (inputOut)
    }
    return (input)

}


interface ModelChangeListener {
    fun onModelChanged()
}

data class Cell(var length : Int, var width : Int)

enum class Move(private val textValue : String) {
    UP_MOVE("Up"),
    DOWN_MOVE("Down"),
    LEFT_MOVE("Left"),
    RIGHT_MOVE("Right"),
    ESC("ESC"),
    SAVE("SAVEmaze");

    override fun toString() : String = textValue
}

class ModelMaze {


    var state : State = State.MOVE_PROCESS
    private val listeners : MutableSet<ModelChangeListener> = mutableSetOf()
    private fun notifyListeners() {
        listeners.forEach { it.onModelChanged() }
    }

    var area = inputMaze().toMutableMap()


    var startMaze =
        Cell(area.filter { it.value == 'P' }.keys.first().first,
            area.filter { it.value == 'P' }.keys.first().second)

    var endMaze =
        Cell(area.filter { it.value == 'E' }.keys.first().first,
            area.filter { it.value == 'E' }.keys.first().second)

    var currentPosition = startMaze

    fun doMove(move : Move) {

        require(state == State.MOVE_PROCESS) { "Result" }
        if (((move == Move.RIGHT_MOVE) && (area[Pair(currentPosition.length, currentPosition.width + 1)] == '#')) ||
            ((move == Move.LEFT_MOVE) && (area[Pair(currentPosition.length, currentPosition.width - 1)] == '#')) ||
            ((move == Move.UP_MOVE) && (area[Pair(currentPosition.length - 1, currentPosition.width)] == '#')) ||
            ((move == Move.DOWN_MOVE) && (area[Pair(currentPosition.length + 1, currentPosition.width)] == '#'))
        ) {
            state = State.YOU_LOSE
            println("YOU LOOOOOOOSE!!!!!!!!!!!!!!!!!!!!!!!!!!!!")

        } else if (((move == Move.UP_MOVE) && (currentPosition.length == 0)) ||
            ((move == Move.DOWN_MOVE) && (currentPosition.length == area.keys.maxOf { it.first })) ||
            ((move == Move.RIGHT_MOVE) && (currentPosition.width == area.keys.maxOf { it.second })) ||
            ((move == Move.LEFT_MOVE) && (currentPosition.width == 0))
        ) {
            throw IllegalArgumentException("Meaning beyond the maze")
        } else {


            if (move != Move.SAVE) {
                area[Pair(currentPosition.length, currentPosition.width)] = '-'
            }

            when (move) {

                Move.UP_MOVE -> currentPosition.length--
                Move.LEFT_MOVE -> currentPosition.width--
                Move.RIGHT_MOVE -> currentPosition.width++
                Move.DOWN_MOVE -> currentPosition.length++
                Move.SAVE -> outputMaze(area)
                Move.ESC -> state = State.YOU_ESC
                else -> return

            }
            area[Pair(currentPosition.length, currentPosition.width)] = 'P'
        }

        println(endMaze.length)
        println(endMaze.width)
        println(currentPosition.length)
        println(currentPosition.width)

        if ((currentPosition.length == endMaze.length) && (currentPosition.width == endMaze.width)) {
            state = State.YOU_WIN

        } else {
            if (state == State.YOU_LOSE) {
                state = State.YOU_LOSE

            } else {
                if (state != State.YOU_ESC) {
                    State.MOVE_PROCESS
                } else {
                    notifyListeners()
                }
            }
        }
        notifyListeners()
    }

    private fun outputMaze(map : Map<Pair<Int, Int>, Char>) {

        val newFile = File("C:\\Users\\DASHA\\IdeaProjects\\kotlin-oop-practice-2022\\src\\main\\kotlin\\lab4\\out.txt")
        newFile.writer().use { writer ->
            for ((key, value) in map) {
                if ((key.second == 0) && (key.first != 0)) {
                    writer.appendLine()
                }
                writer.write("$value")

            }
        }
    }


    fun addModelChangeListener(listener : ModelChangeListener) {
        listeners.add(listener)
    }

    override fun toString() : String {
        return buildString {
            append(state).appendLine()

            for (i in 0..area.keys.maxOf { it.first }) {
                for (j in 0..area.keys.maxOf { it.second }) {
                    if (i == currentPosition.length && j == currentPosition.width) append('P')
                    else append(area[Pair(i, j)])
                }
                appendLine()
            }
        }
    }

}
