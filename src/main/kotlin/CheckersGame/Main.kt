package CheckersGame
import CheckersGame.View.UI
import javax.swing.SwingUtilities

fun main() {
    SwingUtilities.invokeLater {
        val сheckersGame = UI()
        сheckersGame.isVisible = true
    }
}
