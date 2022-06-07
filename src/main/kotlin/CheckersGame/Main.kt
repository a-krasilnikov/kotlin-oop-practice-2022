package CheckersGame

import CheckersGame.View.UI
import javax.swing.SwingUtilities

fun main() {
     var piecesBoard = mutableSetOf<CheckerParameters>()
    /*println(pgnBoard())
    moveCheckers(2,0,3,1,0);
    println(pgnBoard())
    moveCheckers(2,2,3,3,0);
    println(pgnBoard())
    moveCheckers(5,1,4,0,1);
    println(pgnBoard())
    //moveCheckers(1,3,2,2);
   // println(pgnBoard())

    /*moveCheckers(4,0,1,3);
    println(pgnBoard())*/
    moveCheckers(2,2,4,4,1);
    println(pgnBoard())
    moveCheckers(4,4,2,2,1);
    println(pgnBoard())*/
    SwingUtilities.invokeLater {
        val ticTacToeUi = UI()
        ticTacToeUi.isVisible = true
    }
}
