package CheckersGame

import java.lang.Math.abs


enum class CheckersMode {
    QUEEN, CHECKERS, EMPTY,
}

enum class State(val textValue : String) {
    WHITE_MOVE("Waiting for WHITE move..."), BLACK_MOVE("Waiting for BLACK move..."), WHITE_WIN("Game finished. WHITE win, congrats!!!"), BLACK_WIN(
        "Game finished. BLACK win, congrats!!!"),
}

enum class Player {
    WHITE, BLACK, EMPTY,
}

private val FIRST_MOVE = State.WHITE_MOVE
val GAME_NOT_FINISHED = setOf(State.WHITE_MOVE, State.BLACK_MOVE, State.BLACK_WIN, State.WHITE_WIN)

interface ModelChangeListener {
    fun onModelChanged()
}

data class CheckerParameters(val col : Int, val row : Int, val player : Player, val Checker : CheckersMode) {}

class ModelGame {
    var piecesBoard = mutableSetOf<CheckerParameters>()
    var state : State = FIRST_MOVE

    init {

        resetGame()
    }

    fun clear() {
        piecesBoard.clear()
    }

    fun addPiece(piece : CheckerParameters) {
        piecesBoard.add(piece)
    }

    fun delPiece(piece : CheckerParameters) {
        piecesBoard.remove(piece)
    }

    fun resetGame() {
        clear()
        addPiece(CheckerParameters(0, 0, Player.EMPTY, CheckersMode.EMPTY))
        for (i in 0 until 3) {//row
            var check = 0
            if (i.mod(2) != 0) {
                for (j in 0 until 8) {//col
                    if (j.mod(2) == 0) {
                        addPiece(CheckerParameters(j, i, Player.WHITE, CheckersMode.CHECKERS))
                        check = 1
                    } else {
                        addPiece(CheckerParameters(j, i, Player.EMPTY, CheckersMode.EMPTY))
                    }
                }
            } else {
                for (j in 0 until 8) {//col
                    if (j.mod(2) != 0) {
                        addPiece(CheckerParameters(j, i, Player.WHITE, CheckersMode.CHECKERS))
                        check = 1
                    } else {
                        addPiece(CheckerParameters(j, i, Player.EMPTY, CheckersMode.EMPTY))
                    }
                }


            }
            if (check == 0) {
                for (j in 0 until 8) {
                    addPiece(CheckerParameters(j, i, Player.EMPTY, CheckersMode.EMPTY))
                }

            }
        }
        for (i in 3 until 5) {
            for (j in 0 until 8) {
                addPiece(CheckerParameters(j, i, Player.EMPTY, CheckersMode.EMPTY))
            }
        }
        for (i in 5 until 8) {//row
            var check = 0
            if (i.mod(2) != 0) {
                for (j in 0 until 8) {//col
                    if (j.mod(2) == 0) {
                        addPiece(CheckerParameters(j, i, Player.BLACK, CheckersMode.CHECKERS))
                        check = 1
                    } else {
                        addPiece(CheckerParameters(j, i, Player.EMPTY, CheckersMode.EMPTY))
                    }
                }
            } else {
                for (j in 0 until 8) {//col
                    if (j.mod(2) != 0) {
                        addPiece(CheckerParameters(j, i, Player.BLACK, CheckersMode.CHECKERS))
                        check = 1
                    } else {
                        addPiece(CheckerParameters(j, i, Player.EMPTY, CheckersMode.EMPTY))
                    }
                }


            }
            if (check == 0) {
                for (j in 0 until 8) {
                    addPiece(CheckerParameters(j, i, Player.EMPTY, CheckersMode.EMPTY))
                }

            }
        }
    }

    fun pgnBoard() : String {
        var desc = " \n"
        //desc += "  a b c d e f g h\n"
        for (row in 7 downTo 0) {
            //desc += "${row + 1}"
            desc += boardRow(row)
            //desc += " ${row + 1}"
            desc += "\n"
        }
        //desc += "  a b c d e f g h"

        return desc
    }

    override fun toString() : String {
        var desc = " \n"
        for (row in 7 downTo 0) {
            desc += "$row"
            desc += boardRow(row)
            desc += "\n"
        }
        desc += "  0 1 2 3 4 5 6 7"

        return desc
    }

    fun pieceAt(col : Int, row : Int) : CheckerParameters? {
        for (piece in piecesBoard) {
            if (col == piece.col && row == piece.row) {
                return piece
            }
        }
        return null
    }

    fun checkDouble(startCol : Int, startRow : Int, nextCol : Int, nextRow : Int) : Int {
        var doubleBlack = 0
        var check = 0
        val ratio = abs(startCol - nextCol)
        val elemNext : CheckerParameters?
        val elemStart : CheckerParameters?
        elemStart = pieceAt(startCol, startRow)
        elemNext = pieceAt(nextCol, nextRow)
        var ratioNew = 0
        for (row in 0 until 7) {
            for (col in 0 until 7) {
                if (((startCol - startRow == col - row) || (startCol + startRow == col + row))) {
                    println("Зашел ")
                    print(col)
                    print(row)
                    println("Вышел ")
                    var elemBlack : CheckerParameters?
                    elemBlack = pieceAt(col, row)
                    var elemNew : CheckerParameters?
                    elemNew = pieceAt(col - 1, row + 1)


                    if (((elemBlack == CheckerParameters(col,
                            row,
                            Player.BLACK,
                            CheckersMode.CHECKERS)) || (elemBlack == CheckerParameters(col,
                            row,
                            Player.BLACK,
                            CheckersMode.QUEEN))) && ((elemNew == CheckerParameters(col - 1,
                            row + 1,
                            Player.BLACK,
                            CheckersMode.CHECKERS)) || (elemNew == CheckerParameters(col - 1,
                            row + 1,
                            Player.BLACK,
                            CheckersMode.QUEEN)))
                    ) {
                        ratioNew = abs(startCol - col)
                        print(ratioNew)
                        println("ratio ")
                        /*if ((ratio < ratioNew)&&(check==0)) {
                            if ((startCol - startRow == nextCol - nextRow) || (startCol + startRow == nextCol + nextRow)) {
                                addPiece(CheckerParameters(nextCol, nextRow, Player.BLACK, CheckersMode.QUEEN))
                                delPiece(CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.QUEEN))
                                check = 1
                            }
                        }*/
                        doubleBlack++
                    }
                    elemNew = pieceAt(col + 1, row + 1)
                    if (((elemBlack == CheckerParameters(col,
                            row,
                            Player.BLACK,
                            CheckersMode.CHECKERS)) || (elemBlack == CheckerParameters(col,
                            row,
                            Player.BLACK,
                            CheckersMode.QUEEN))) && ((elemNew == CheckerParameters(col + 1,
                            row + 1,
                            Player.BLACK,
                            CheckersMode.CHECKERS)) || (elemNew == CheckerParameters(col + 1,
                            row + 1,
                            Player.BLACK,
                            CheckersMode.QUEEN)))
                    ) {
                        ratioNew = abs(startCol - col)
                        print(ratioNew)
                        println("ratio ")
                        /*f ((ratio < ratioNew)&&(check==0)) {
                            if ((startCol - startRow == nextCol - nextRow) || (startCol + startRow == nextCol + nextRow)) {
                                addPiece(CheckerParameters(nextCol, nextRow, Player.BLACK, CheckersMode.QUEEN))
                                delPiece(CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.QUEEN))
                                check = 1
                            }
                        }*/
                        doubleBlack++
                    }
                    //bb
                    elemNew = pieceAt(col - 1, row + 1)
                    if (((elemBlack == CheckerParameters(col,
                            row,
                            Player.WHITE,
                            CheckersMode.CHECKERS)) || (elemBlack == CheckerParameters(col,
                            row,
                            Player.WHITE,
                            CheckersMode.QUEEN))) && ((elemNew == CheckerParameters(col - 1,
                            row + 1,
                            Player.WHITE,
                            CheckersMode.CHECKERS)) || (elemNew == CheckerParameters(col - 1,
                            row + 1,
                            Player.WHITE,
                            CheckersMode.QUEEN)))
                    ) {
                        println("bb")
                        ratioNew = abs(startCol - col)
                        print(ratioNew)
                        println("ratio ")
                        /* if ((ratio < ratioNew)&&(check==0)) {
                             if ((startCol - startRow == nextCol - nextRow) || (startCol + startRow == nextCol + nextRow)) {
                                 addPiece(CheckerParameters(nextCol, nextRow, Player.BLACK, CheckersMode.QUEEN))
                                 delPiece(CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.QUEEN))
                                 check = 1
                             }
                         }*/
                        doubleBlack++
                    }
                    elemNew = pieceAt(col + 1, row + 1)
                    if (((elemBlack == CheckerParameters(col,
                            row,
                            Player.WHITE,
                            CheckersMode.CHECKERS)) || (elemBlack == CheckerParameters(col,
                            row,
                            Player.WHITE,
                            CheckersMode.QUEEN))) && ((elemNew == CheckerParameters(col + 1,
                            row + 1,
                            Player.WHITE,
                            CheckersMode.CHECKERS)) || (elemNew == CheckerParameters(col + 1,
                            row + 1,
                            Player.WHITE,
                            CheckersMode.QUEEN)))
                    ) {
                        ratioNew = abs(startCol - col)
                        print(ratioNew)
                        println("ratio ")
                        /*if ((ratio < ratioNew)&&(check==0)) {
                            if ((startCol - startRow == nextCol - nextRow) || (startCol + startRow == nextCol + nextRow)) {
                                addPiece(CheckerParameters(nextCol, nextRow, Player.BLACK, CheckersMode.QUEEN))
                                delPiece(CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.QUEEN))
                                check = 1
                            }
                        }*/
                        doubleBlack++
                    }
                    //белые черные
                    elemNew = pieceAt(col - 1, row + 1)
                    if (((elemBlack == CheckerParameters(col,
                            row,
                            Player.WHITE,
                            CheckersMode.CHECKERS)) || (elemBlack == CheckerParameters(col,
                            row,
                            Player.WHITE,
                            CheckersMode.QUEEN))) && ((elemNew == CheckerParameters(col - 1,
                            row + 1,
                            Player.BLACK,
                            CheckersMode.CHECKERS)) || (elemNew == CheckerParameters(col - 1,
                            row + 1,
                            Player.BLACK,
                            CheckersMode.QUEEN)))
                    ) {
                        ratioNew = abs(startCol - col)
                        print(ratioNew)
                        println("ratio ")
                        /* if ((ratio < ratioNew)&&(check==0)) {
                             if ((startCol - startRow == nextCol - nextRow) || (startCol + startRow == nextCol + nextRow)) {
                                 addPiece(CheckerParameters(nextCol, nextRow, Player.BLACK, CheckersMode.QUEEN))
                                 delPiece(CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.QUEEN))
                                 check = 1
                             }
                         }*/

                        doubleBlack++
                    }
                    elemNew = pieceAt(col + 1, row + 1)
                    if (((elemBlack == CheckerParameters(col,
                            row,
                            Player.WHITE,
                            CheckersMode.CHECKERS)) || (elemBlack == CheckerParameters(col,
                            row,
                            Player.WHITE,
                            CheckersMode.QUEEN))) && ((elemNew == CheckerParameters(col + 1,
                            row + 1,
                            Player.BLACK,
                            CheckersMode.CHECKERS)) || (elemNew == CheckerParameters(col + 1,
                            row + 1,
                            Player.BLACK,
                            CheckersMode.QUEEN)))
                    ) {
                        ratioNew = abs(startCol - col)
                        print(ratioNew)
                        println("ratio ")
                        /*if ((ratio < ratioNew)&&(check==0)) {
                            if ((startCol - startRow == nextCol - nextRow) || (startCol + startRow == nextCol + nextRow)) {
                                addPiece(CheckerParameters(nextCol, nextRow, Player.BLACK, CheckersMode.QUEEN))
                                delPiece(CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.QUEEN))
                                check = 1
                            }
                        }*/
                        doubleBlack++
                    }

                    //Черно белые
                    elemNew = pieceAt(col - 1, row + 1)
                    if (((elemBlack == CheckerParameters(col,
                            row,
                            Player.BLACK,
                            CheckersMode.CHECKERS)) || (elemBlack == CheckerParameters(col,
                            row,
                            Player.BLACK,
                            CheckersMode.QUEEN))) && ((elemNew == CheckerParameters(col - 1,
                            row + 1,
                            Player.WHITE,
                            CheckersMode.CHECKERS)) || (elemNew == CheckerParameters(col - 1,
                            row + 1,
                            Player.WHITE,
                            CheckersMode.QUEEN)))
                    ) {
                        ratioNew = abs(startCol - col)
                        print(ratioNew)
                        println("ratio ")
                        /*if ((ratio < ratioNew)&&(check==0)) {
                            if ((startCol - startRow == nextCol - nextRow) || (startCol + startRow == nextCol + nextRow)) {
                                addPiece(CheckerParameters(nextCol, nextRow, Player.BLACK, CheckersMode.QUEEN))
                                delPiece(CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.QUEEN))
                                check = 1
                            }
                        }*/
                        doubleBlack++
                    }
                    elemNew = pieceAt(col + 1, row + 1)
                    if (((elemBlack == CheckerParameters(col,
                            row,
                            Player.BLACK,
                            CheckersMode.CHECKERS)) || (elemBlack == CheckerParameters(col,
                            row,
                            Player.BLACK,
                            CheckersMode.QUEEN))) && ((elemNew == CheckerParameters(col + 1,
                            row + 1,
                            Player.WHITE,
                            CheckersMode.CHECKERS)) || (elemNew == CheckerParameters(col + 1,
                            row + 1,
                            Player.WHITE,
                            CheckersMode.QUEEN)))
                    ) {
                        ratioNew = abs(startCol - col)
                        print(ratioNew)
                        check = 1
                        println("ratio ")
                        /*if ((ratio < ratioNew)&&(check==0)) {
                            if ((startCol - startRow == nextCol - nextRow) || (startCol + startRow == nextCol + nextRow)) {
                                addPiece(CheckerParameters(nextCol, nextRow, Player.BLACK, CheckersMode.QUEEN))
                                delPiece(CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.QUEEN))
                                check = 1
                            }
                        }*/
                        doubleBlack++
                    }

                }
            }



            print(ratio)

            if ((ratio < ratioNew) || (ratioNew == 0)) {

                if ((elemStart == CheckerParameters(startCol, startRow, Player.WHITE, CheckersMode.QUEEN))) {
                    if (elemNext == null) {

                        if ((startCol - startRow == nextCol - nextRow) || (startCol + startRow == nextCol + nextRow)) {
                            addPiece(CheckerParameters(nextCol, nextRow, Player.WHITE, CheckersMode.QUEEN))
                            delPiece(CheckerParameters(startCol, startRow, Player.WHITE, CheckersMode.QUEEN))
                        }
                    }
                }

                if (elemStart == CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.QUEEN)) {
                    if (elemNext == null) {

                        if ((startCol - startRow == nextCol - nextRow) || (startCol + startRow == nextCol + nextRow)) {
                            addPiece(CheckerParameters(nextCol, nextRow, Player.BLACK, CheckersMode.QUEEN))
                            delPiece(CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.QUEEN))
                        }
                    }
                }
            }
        }


        return doubleBlack
    }

    fun whiteMove(startCol : Int, startRow : Int, nextCol : Int, nextRow : Int) : Boolean {
        println("white")
        var elemNext : CheckerParameters?
        var elemStart : CheckerParameters?
        var moveWas = false
        elemStart = pieceAt(startCol, startRow)
        elemNext = pieceAt(nextCol, nextRow)


        if (elemStart == CheckerParameters(startCol, startRow, Player.WHITE, CheckersMode.CHECKERS)) {

            if (elemNext == CheckerParameters(nextCol, nextRow, Player.EMPTY, CheckersMode.EMPTY)) {
                if (((startCol == nextCol + 1) || (startCol == nextCol - 1)) && (startRow + 1 == nextRow)) {
                    moveWas = true
                    delPiece(CheckerParameters(nextCol, nextRow, Player.EMPTY, CheckersMode.EMPTY))
                    addPiece(CheckerParameters(nextCol, nextRow, Player.WHITE, CheckersMode.CHECKERS))
                    delPiece(CheckerParameters(startCol, startRow, Player.WHITE, CheckersMode.CHECKERS))
                    addPiece(CheckerParameters(startCol, startRow, Player.EMPTY, CheckersMode.EMPTY))

                }
            }

            //рубка шашкой
            var scan : Int
            scan = (nextCol - startCol) / (abs(nextCol - startCol))
            if (elemNext == CheckerParameters(nextCol, nextRow, Player.EMPTY, CheckersMode.EMPTY)) {
                if (((startCol == nextCol + 2) || (startCol == nextCol - 2)) && (startRow + 2 == nextRow)) {
                    delPiece(CheckerParameters(nextCol, nextRow, Player.EMPTY, CheckersMode.EMPTY))
                    addPiece(CheckerParameters(nextCol, nextRow, Player.WHITE, CheckersMode.CHECKERS))
                    delPiece(CheckerParameters(startCol, startRow, Player.WHITE, CheckersMode.CHECKERS))
                    addPiece(CheckerParameters(startCol, startRow, Player.EMPTY, CheckersMode.EMPTY))
                    delPiece(CheckerParameters(startCol + 1 * scan, startRow + 1, Player.BLACK, CheckersMode.CHECKERS))
                    addPiece(CheckerParameters(startCol + 1 * scan, startRow + 1, Player.EMPTY, CheckersMode.EMPTY))
                    moveWas = true
                }
                if (((startCol == nextCol + 2) || (startCol == nextCol - 2)) && (startRow - 2 == nextRow)) {
                    delPiece(CheckerParameters(nextCol, nextRow, Player.EMPTY, CheckersMode.EMPTY))
                    addPiece(CheckerParameters(nextCol, nextRow, Player.WHITE, CheckersMode.CHECKERS))
                    delPiece(CheckerParameters(startCol, startRow, Player.WHITE, CheckersMode.CHECKERS))
                    addPiece(CheckerParameters(startCol, startRow, Player.EMPTY, CheckersMode.EMPTY))
                    delPiece(CheckerParameters(startCol + 1 * scan, startRow - 1, Player.BLACK, CheckersMode.CHECKERS))
                    addPiece(CheckerParameters(startCol + 1 * scan, startRow - 1, Player.EMPTY, CheckersMode.EMPTY))
                    moveWas = true
                }
            }
        }
        if (elemNext == (CheckerParameters(nextCol, 7, Player.WHITE, CheckersMode.CHECKERS))) {
            delPiece(CheckerParameters(nextCol, 7, Player.WHITE, CheckersMode.CHECKERS))
            addPiece(CheckerParameters(nextCol, 7, Player.WHITE, CheckersMode.QUEEN))
        }




        if (elemStart == CheckerParameters(startCol, startRow, Player.WHITE, CheckersMode.QUEEN)) {
            var doubleBlack = checkDouble(startCol, startRow, nextCol, nextRow)
            println("doubleBlack-")
            println(doubleBlack)
            doubleBlack = 0
            if (elemNext == CheckerParameters(nextCol, nextRow, Player.EMPTY, CheckersMode.EMPTY)) {

                if (((startCol - startRow == nextCol - nextRow) || (startCol + startRow == nextCol + nextRow)) && (doubleBlack == 0)) {
                    for (row in 0 until 8) {
                        for (col in 0 until 8) {
                            if (((startCol - startRow == col - row) || (startCol + startRow == col + row))) {
                                if ((((startCol < col) && (col < nextCol)) || ((startCol > col) && (col > nextCol))) && ((startRow > row) && (row > nextRow)) || ((startRow < row) && (row < nextRow))) {
                                    delPiece(CheckerParameters(col, row, Player.BLACK, CheckersMode.CHECKERS))
                                    addPiece(CheckerParameters(col, row, Player.EMPTY, CheckersMode.EMPTY))
                                    delPiece(CheckerParameters(col, row, Player.BLACK, CheckersMode.QUEEN))
                                    addPiece(CheckerParameters(col, row, Player.EMPTY, CheckersMode.EMPTY))
                                }
                            }
                        }
                    }
                    delPiece(CheckerParameters(nextCol, nextRow, Player.EMPTY, CheckersMode.EMPTY))
                    addPiece(CheckerParameters(nextCol, nextRow, Player.WHITE, CheckersMode.QUEEN))
                    delPiece(CheckerParameters(startCol, startRow, Player.WHITE, CheckersMode.QUEEN))
                    addPiece(CheckerParameters(startCol, startRow, Player.EMPTY, CheckersMode.EMPTY))
                    moveWas = true
                }

            }
        }
        return moveWas


    }

    fun blackMove(startCol : Int, startRow : Int, nextCol : Int, nextRow : Int) : Boolean {
        var elemNext : CheckerParameters?
        var elemStart : CheckerParameters?
        elemStart = pieceAt(startCol, startRow)
        elemNext = pieceAt(nextCol, nextRow)

        println("black")
        var moveWas = false



        if (elemStart == CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.CHECKERS)) {
            if (elemNext == CheckerParameters(nextCol, nextRow, Player.EMPTY, CheckersMode.EMPTY)) {
                if (((startCol == nextCol + 1) || (startCol == nextCol - 1)) && (startRow - 1 == nextRow)) {
                    delPiece(CheckerParameters(nextCol, nextRow, Player.EMPTY, CheckersMode.EMPTY))
                    addPiece(CheckerParameters(nextCol, nextRow, Player.BLACK, CheckersMode.CHECKERS))
                    moveWas = true
                    delPiece(CheckerParameters(nextCol, nextRow, Player.EMPTY, CheckersMode.EMPTY))
                    addPiece(CheckerParameters(nextCol, nextRow, Player.BLACK, CheckersMode.CHECKERS))
                    delPiece(CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.CHECKERS))
                    addPiece(CheckerParameters(startCol, startRow, Player.EMPTY, CheckersMode.EMPTY))
                }
            }

            if (elemNext == CheckerParameters(nextCol, nextRow, Player.EMPTY, CheckersMode.EMPTY)) {
                var scan : Int
                scan = (nextCol - startCol) / (abs(nextCol - startCol))

                if (((startCol == nextCol + 2) || (startCol == nextCol - 2)) && (startRow + 2 == nextRow)) {
                    delPiece(CheckerParameters(nextCol, nextRow, Player.EMPTY, CheckersMode.EMPTY))
                    addPiece(CheckerParameters(nextCol, nextRow, Player.BLACK, CheckersMode.CHECKERS))

                    moveWas = true
                    delPiece(CheckerParameters(startCol + 1 * scan, startRow + 1, Player.WHITE, CheckersMode.CHECKERS))
                    addPiece(CheckerParameters(startCol + 1 * scan, startRow + 1, Player.EMPTY, CheckersMode.EMPTY))


                    delPiece(CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.CHECKERS))
                    addPiece(CheckerParameters(startCol, startRow, Player.EMPTY, CheckersMode.EMPTY))


                }

                if (((startCol == nextCol + 2) || (startCol == nextCol - 2)) && (startRow - 2 == nextRow)) {
                    moveWas = true
                    delPiece(CheckerParameters(nextCol, nextRow, Player.EMPTY, CheckersMode.EMPTY))
                    addPiece(CheckerParameters(nextCol, nextRow, Player.BLACK, CheckersMode.CHECKERS))
                    delPiece(CheckerParameters(startCol + 1 * scan, startRow - 1, Player.WHITE, CheckersMode.CHECKERS))
                    addPiece(CheckerParameters(startCol + 1 * scan, startRow - 1, Player.EMPTY, CheckersMode.EMPTY))
                    delPiece(CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.CHECKERS))
                    addPiece(CheckerParameters(startCol, startRow, Player.EMPTY, CheckersMode.EMPTY))
                }
            }
        }
        if (elemNext == (CheckerParameters(nextCol, 0, Player.BLACK, CheckersMode.CHECKERS))) {
            delPiece(CheckerParameters(nextCol, 0, Player.BLACK, CheckersMode.CHECKERS))
            addPiece(CheckerParameters(nextCol, 0, Player.BLACK, CheckersMode.QUEEN))
        }

        if (elemStart == CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.QUEEN)) {
            var doubleBlack = checkDouble(startCol, startRow, nextCol, nextRow)

            doubleBlack = 0
            var check = 0
            if (elemNext == CheckerParameters(nextCol, nextRow, Player.EMPTY, CheckersMode.EMPTY)) {

                if (((startCol - startRow == nextCol - nextRow) || (startCol + startRow == nextCol + nextRow)) && (doubleBlack == 0)) {
                    for (row in 0 until 8) {
                        for (col in 0 until 8) {
                            if (((startCol - startRow == col - row) || (startCol + startRow == col + row))) {
                                if ((((startCol < col) && (col < nextCol)) || ((startCol > col) && (col > nextCol))) && ((startRow < row) && (row < nextRow)) || ((startRow > row) && (row > nextRow))) {
                                    delPiece(CheckerParameters(col, row, Player.WHITE, CheckersMode.CHECKERS))
                                    addPiece(CheckerParameters(col, row, Player.EMPTY, CheckersMode.EMPTY))
                                    delPiece(CheckerParameters(col, row, Player.WHITE, CheckersMode.QUEEN))
                                    addPiece(CheckerParameters(col, row, Player.EMPTY, CheckersMode.EMPTY))
                                }
                            }
                        }
                    }
                    check++
                    delPiece(CheckerParameters(nextCol, nextRow, Player.EMPTY, CheckersMode.EMPTY))
                    addPiece(CheckerParameters(nextCol, nextRow, Player.BLACK, CheckersMode.QUEEN))
                    delPiece(CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.QUEEN))
                    addPiece(CheckerParameters(startCol, startRow, Player.EMPTY, CheckersMode.EMPTY))
                    moveWas = true
                }

            }
        }
        return moveWas
    }

    fun boardRow(row : Int) : String {
        var desc = ""
        for (col in 0 until 8) {
            desc += " "
            desc += pieceAt(col, row)?.let {

                val white = it.player == Player.WHITE
                when (it.Checker) {

                    CheckersMode.QUEEN -> if (white) "q" else "Q"
                    CheckersMode.CHECKERS -> if (white) "w" else "b"
                    CheckersMode.EMPTY -> if (white) "." else "."
                }
            } ?: "."
        }
        return desc
    }

    private val listeners : MutableSet<ModelChangeListener> = mutableSetOf()

    fun addModelChangeListener(listener : ModelChangeListener) {
        listeners.add(listener)
    }

    fun removeModelChangeListener(listener : ModelChangeListener) {
        listeners.remove(listener)
    }

    private fun notifyListeners() {
        listeners.forEach { it.onModelChanged() }
    }
}


