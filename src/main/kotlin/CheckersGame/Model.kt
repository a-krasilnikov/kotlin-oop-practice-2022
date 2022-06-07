package CheckersGame

import java.lang.Math.abs

data class Square(val col : Int, val row : Int)

enum class CheckersMode {
    //состояние шашки
    QUEEN,
    CHECKERS,
    EMPTY,

}
enum class State(val textValue: String) {
    WHITE_MOVE("Waiting for WHITE move..."),
    BLACK_MOVE("Waiting for BLACK move..."),
    WHITE_WIN("Game finished. WHITE win, congrats!!!"),
    BLACK_WIN("Game finished. BLACK win, congrats!!!"),
    DRAW("Game finished. Draw")
}
enum class Player {
    WHITE,
    BLACK,
    EMPTY,
}
private val FIRST_MOVE = State.WHITE_MOVE
val GAME_NOT_FINISHED = setOf(State.WHITE_MOVE, State.BLACK_MOVE)

interface ModelChangeListener {
    fun onModelChanged()
}

data class CheckerParameters(val col : Int, val row : Int, val player : Player, val Checker : CheckersMode) {}

class ModelGame {
     var piecesBoard = mutableSetOf<CheckerParameters>()

    init {
        resetGame()
    }

    fun initBoard() {
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
        for (i in 5 until 8) {//row
            if (i.mod(2) != 0) {
                for (j in 0 until 8) {//col
                    if (j.mod(2) == 0) {
                        addPiece(CheckerParameters(j, i, Player.BLACK, CheckersMode.CHECKERS))

                    }
                }
            } else {
                for (j in 0 until 8) {//col
                    if (j.mod(2) != 0) {
                        addPiece(CheckerParameters(j, i, Player.BLACK, CheckersMode.CHECKERS))

                    }
                }


            }
        }

        for (i in 0 until 3) {//row
            if (i.mod(2) != 0) {
                for (j in 0 until 8) {//col
                    if (j.mod(2) == 0) {
                        addPiece(CheckerParameters(j, i, Player.WHITE, CheckersMode.CHECKERS))

                    }
                }
            } else {
                for (j in 0 until 8) {//col
                    if (j.mod(2) != 0) {
                        addPiece(CheckerParameters(j, i, Player.WHITE, CheckersMode.CHECKERS))

                    }
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

    fun pieceAt(square : Square) : CheckerParameters? {
        return pieceAt(square.col, square.row)
    }

    private fun pieceAt(col : Int, row : Int) : CheckerParameters? {
        for (piece in piecesBoard) {
            if (col == piece.col && row == piece.row) {
                return piece
            }
        }
        return null
    }

    fun checkColor( nextCol :Int , nextRow : Int,) : Boolean {
        var elem : CheckerParameters?
        elem = pieceAt(nextCol, nextRow)
        return (elem == CheckerParameters(nextCol, nextRow, Player.WHITE, CheckersMode.CHECKERS))
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


                    if (((elemBlack == CheckerParameters(col, row, Player.BLACK, CheckersMode.CHECKERS)) ||
                                (elemBlack == CheckerParameters(col, row, Player.BLACK, CheckersMode.QUEEN))) &&
                        ((elemNew == CheckerParameters(col - 1, row + 1, Player.BLACK, CheckersMode.CHECKERS)) ||
                                (elemNew == CheckerParameters(col - 1,
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
                    if (((elemBlack == CheckerParameters(col, row, Player.BLACK, CheckersMode.CHECKERS)) ||
                                (elemBlack == CheckerParameters(col, row, Player.BLACK, CheckersMode.QUEEN))) &&
                        ((elemNew == CheckerParameters(col + 1, row + 1, Player.BLACK, CheckersMode.CHECKERS)) ||
                                (elemNew == CheckerParameters(col + 1,
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
                    if (((elemBlack == CheckerParameters(col, row, Player.WHITE, CheckersMode.CHECKERS)) ||
                                (elemBlack == CheckerParameters(col, row, Player.WHITE, CheckersMode.QUEEN))) &&
                        ((elemNew == CheckerParameters(col - 1, row + 1, Player.WHITE, CheckersMode.CHECKERS)) ||
                                (elemNew == CheckerParameters(col - 1,
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
                    if (((elemBlack == CheckerParameters(col, row, Player.WHITE, CheckersMode.CHECKERS)) ||
                                (elemBlack == CheckerParameters(col, row, Player.WHITE, CheckersMode.QUEEN))) &&
                        ((elemNew == CheckerParameters(col + 1, row + 1, Player.WHITE, CheckersMode.CHECKERS)) ||
                                (elemNew == CheckerParameters(col + 1,
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
                    if (((elemBlack == CheckerParameters(col, row, Player.WHITE, CheckersMode.CHECKERS)) ||
                                (elemBlack == CheckerParameters(col, row, Player.WHITE, CheckersMode.QUEEN))) &&
                        ((elemNew == CheckerParameters(col - 1, row + 1, Player.BLACK, CheckersMode.CHECKERS)) ||
                                (elemNew == CheckerParameters(col - 1,
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
                    if (((elemBlack == CheckerParameters(col, row, Player.WHITE, CheckersMode.CHECKERS)) ||
                                (elemBlack == CheckerParameters(col, row, Player.WHITE, CheckersMode.QUEEN))) &&
                        ((elemNew == CheckerParameters(col + 1, row + 1, Player.BLACK, CheckersMode.CHECKERS)) ||
                                (elemNew == CheckerParameters(col + 1,
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
                    if (((elemBlack == CheckerParameters(col, row, Player.BLACK, CheckersMode.CHECKERS)) ||
                                (elemBlack == CheckerParameters(col, row, Player.BLACK, CheckersMode.QUEEN))) &&
                        ((elemNew == CheckerParameters(col - 1, row + 1, Player.WHITE, CheckersMode.CHECKERS)) ||
                                (elemNew == CheckerParameters(col - 1,
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
                    if (((elemBlack == CheckerParameters(col, row, Player.BLACK, CheckersMode.CHECKERS)) ||
                                (elemBlack == CheckerParameters(col, row, Player.BLACK, CheckersMode.QUEEN))) &&
                        ((elemNew == CheckerParameters(col + 1, row + 1, Player.WHITE, CheckersMode.CHECKERS)) ||
                                (elemNew == CheckerParameters(col + 1,
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

            println("rationew ")

            print(ratio)

            if ((ratio < ratioNew) || (ratioNew == 0)) {
                println("rgfdhfjyfy ")
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

    fun whiteMove(startCol : Int,startRow : Int,  nextRow : Int, nextCol : Int) {
        var elemNext : CheckerParameters?
        var elemStart : CheckerParameters?
        elemStart = pieceAt(startCol, startRow)
        elemNext = pieceAt(nextCol, nextRow)
        //обычный ход
        if (elemStart == CheckerParameters(startCol, startRow, Player.WHITE, CheckersMode.CHECKERS)) {
            if (elemNext == null) {
                if (((startCol == nextCol + 1) || (startCol == nextCol - 1)) && (startRow + 1 == nextRow)) {
                    addPiece(CheckerParameters(nextCol, nextRow, Player.WHITE, CheckersMode.CHECKERS))
                    delPiece(CheckerParameters(startCol, startRow, Player.WHITE, CheckersMode.CHECKERS))
                }
            }
        }
        //рубка шашкой
        var scan : Int
        scan = (nextCol - startCol) / (abs(nextCol - startCol))
        if (elemNext == null) {
            if (((startCol == nextCol + 2) || (startCol == nextCol - 2)) && (startRow + 2 == nextRow)) {

                addPiece(CheckerParameters(nextCol, nextRow, Player.WHITE, CheckersMode.CHECKERS))
                delPiece(CheckerParameters(startCol, startRow, Player.WHITE, CheckersMode.CHECKERS))
                delPiece(CheckerParameters(startCol + 1 * scan, startRow + 1,
                    Player.BLACK, CheckersMode.CHECKERS))
            }
            if (((startCol == nextCol + 2) || (startCol == nextCol - 2)) && (startRow - 2 == nextRow)) {


                addPiece(CheckerParameters(nextCol, nextRow, Player.WHITE, CheckersMode.CHECKERS))
                delPiece(CheckerParameters(startCol, startRow, Player.WHITE, CheckersMode.CHECKERS))
                delPiece(CheckerParameters(startCol + 1 * scan, startRow - 1,
                    Player.BLACK, CheckersMode.CHECKERS))
            }
        }

        //рубка дамкой
        if (elemStart == CheckerParameters(startCol, startRow, Player.WHITE, CheckersMode.QUEEN)) {
            var doubleBlack = checkDouble(startCol, startRow, nextCol, nextRow)
            println("doubleBlack-")
            println(doubleBlack)
            println("-")
            if (elemNext == null) {

                if (((startCol - startRow == nextCol - nextRow) || (startCol + startRow == nextCol + nextRow)) && (doubleBlack == 0)) {
                    for (row in 0 until 8) {
                        for (col in 0 until 8) {
                            if (((startCol - startRow == col - row) || (startCol + startRow == col + row))) {
                                if ((((startCol < col) && (col < nextCol)) || ((startCol > col) && (col < nextCol))) &&
                                    ((startRow < row) && (row < nextRow)) || ((startRow > row) && (row < nextRow))
                                ) {
                                    delPiece(CheckerParameters(col, row, Player.BLACK, CheckersMode.CHECKERS))
                                }
                            }
                        }
                    }
                    addPiece(CheckerParameters(nextCol, nextRow, Player.WHITE, CheckersMode.QUEEN))
                    delPiece(CheckerParameters(startCol, startRow, Player.WHITE, CheckersMode.QUEEN))
                }

            }
        }
    }

    fun blackMove( startCol : Int, startRow : Int, nextRow : Int, nextCol : Int){
        var elemNext : CheckerParameters?
        var elemStart : CheckerParameters?
        elemStart = pieceAt(startCol, startRow)
        elemNext = pieceAt(nextCol, nextRow)

        //обычный ход
        if ((elemStart == CheckerParameters(startCol, startRow, Player.WHITE, CheckersMode.CHECKERS)) ||
            (elemStart == CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.CHECKERS))
        ) {
            if (elemNext == null) {
                    if (((startCol == nextCol + 1) || (startCol == nextCol - 1)) && (startRow - 1 == nextRow)) {
                        addPiece(CheckerParameters(nextCol, nextRow, Player.BLACK, CheckersMode.CHECKERS))
                        delPiece(CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.CHECKERS))

                    }
            }
        }
        //рубка дамкой
        if (elemStart == CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.QUEEN)) {
            var doubleBlack = checkDouble(startCol, startRow, nextCol, nextRow)
            println("doubleBlack-")
            println(doubleBlack)
            println("-")
            var check = 0
            if (elemNext == null) {

                if (((startCol - startRow == nextCol - nextRow) || (startCol + startRow == nextCol + nextRow)) && (doubleBlack == 0)) {
                    for (row in 0 until 8) {
                        for (col in 0 until 8) {
                            if (((startCol - startRow == col - row) || (startCol + startRow == col + row))) {
                                if ((((startCol < col) && (col < nextCol)) || ((startCol > col) && (col < nextCol))) &&
                                    ((startRow < row) && (row < nextRow)) || ((startRow > row) && (row < nextRow))
                                ) {
                                    println("Nere-")
                                    delPiece(CheckerParameters(col, row, Player.WHITE, CheckersMode.CHECKERS))
                                    delPiece(CheckerParameters(col, row, Player.WHITE, CheckersMode.QUEEN))
                                }
                            }
                        }
                    }
                    check++
                    addPiece(CheckerParameters(nextCol, nextRow, Player.BLACK, CheckersMode.QUEEN))
                    delPiece(CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.QUEEN))
                }

            }
        }
         //рубка шашка
        if (elemNext == null) {
            var scan : Int
            scan = (nextCol - startCol) / (abs(nextCol - startCol))

            if (((startCol == nextCol + 2) || (startCol == nextCol - 2)) && (startRow + 2 == nextRow)) {
                    addPiece(CheckerParameters(nextCol, nextRow, Player.BLACK, CheckersMode.CHECKERS))
                    delPiece(CheckerParameters(startCol + 1 * scan, startRow + 1,
                        Player.WHITE, CheckersMode.CHECKERS))
                    delPiece(CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.CHECKERS))
            }

            if (((startCol == nextCol + 2) || (startCol == nextCol - 2)) && (startRow - 2 == nextRow)) {
                    println(CheckerParameters(startCol + 1 * scan, startRow - 1,
                        Player.BLACK, CheckersMode.CHECKERS))
                    addPiece(CheckerParameters(nextCol, nextRow, Player.BLACK, CheckersMode.CHECKERS))
                    delPiece(CheckerParameters(startCol + 1 * scan, startRow - 1,
                        Player.WHITE, CheckersMode.CHECKERS))
                    delPiece(CheckerParameters(startCol, startRow, Player.BLACK, CheckersMode.CHECKERS))

            }
        }


    }

    fun moveCheckers(startCol : Int,startRow : Int,  nextRow : Int, nextCol : Int,win:Int) {

       if (win==0){
           whiteMove(startCol,startRow ,nextRow , nextCol)
       }
        else{
           blackMove(startCol,startRow , nextRow , nextCol)
        }
        //notifyListeners()
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


   var state: State = FIRST_MOVE
        private set

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

}


/*if (((checkColor( nextRow,nextCol))&&(checkColor( startRow,startCol)))||
                    ((!checkColor(nextRow,nextCol))&&(!checkColor(startRow,startCol)))){ //одинаковые белые или черные
                 print ("сюда нельзя ходить!!")
            }
            else {


            }*/


//ход дамки
/*if ((elemStart == CheckerParameters(startCol, startRow, Player.WHITE, CheckersMode.QUEEN))) {
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
}*/