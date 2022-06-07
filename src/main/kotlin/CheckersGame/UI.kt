package CheckersGame.View
import CheckersGame.*
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Component
import java.awt.GridLayout
import javax.swing.*

private const val GAP = 0

class UI : JFrame("Checkers Game"), ModelChangeListener {
    private var gameModel: ModelGame = ModelGame()
    private val statusLabel = JLabel("Status", JLabel.CENTER)
    private val buttons = mutableListOf<MutableList<JButton>>()
    private var BOARD_SIZE=8
    init {
        setSize(500, 500)
        defaultCloseOperation = EXIT_ON_CLOSE

        updateFont(statusLabel, 20.0f)

        rootPane.contentPane = JPanel(BorderLayout(GAP, GAP)).apply {
            add(statusLabel, BorderLayout.NORTH)
            add(createBoardPanel(), BorderLayout.CENTER)
            add(createRestartButton(), BorderLayout.SOUTH)
            border = BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP)
        }

        resubscribe()
    }

    private fun createRestartButton(): Component {
        val restartButton = JButton("Restart")
        updateFont(restartButton, 20.0f)
        restartButton.addActionListener {
            if (gameModel.state in GAME_NOT_FINISHED) {
                val dialogOption = JOptionPane.showConfirmDialog(
                    this,
                    "Game not finished, are you sure?",
                    "Restart",
                    JOptionPane.OK_CANCEL_OPTION
                )

                if (dialogOption == JOptionPane.OK_OPTION) {
                    resubscribe()
                }
            } else {
                resubscribe()
            }
        }

        return restartButton
    }

    private fun resubscribe() {
        gameModel.removeModelChangeListener(this)
        gameModel = ModelGame()
        gameModel.addModelChangeListener(this)
        updateGameUI()

    }

    private fun createBoardPanel(): Component {
        val gamePanel = JPanel(GridLayout(BOARD_SIZE, BOARD_SIZE, GAP, GAP))
//BOARD_SIZE-1 downTo  0
        for (i in BOARD_SIZE-1 downTo  0) {
            val buttonsRow = mutableListOf<JButton>()

            for (j in 0 until BOARD_SIZE) {

                val cellButton =  JButton(" ")

                if (i.mod(2) != 0) {

                        if (j.mod(2) != 0) {
                            cellButton.background=Color.lightGray
                        }
                        else{
                            cellButton.background=Color.WHITE
                        }

                } else {
                        if (j.mod(2) == 0) {
                            cellButton.background=Color.lightGray

                        }
                    else{
                            cellButton.background=Color.WHITE
                    }
                }


                cellButton.addActionListener {
                    gameModel.moveCheckers(i,j,3,4,0)
                }

                buttonsRow.add(cellButton)
                gamePanel.add(cellButton)
                updateFont(cellButton, 30.0f)
            }
            buttons.add(buttonsRow)
        }

        return gamePanel
    }

    private fun updateFont(component: JComponent, newFontSize: Float) {
        val font = component.font
        val derivedFont = font.deriveFont(newFontSize)
        component.font = derivedFont
    }

    override fun onModelChanged() {
        updateGameUI()
    }

    private fun updateGameUI() {
        val state = gameModel.state
        statusLabel.text = state.textValue

        for ((i, buttonRow) in buttons.withIndex()) {
            for ((j, button) in buttonRow.withIndex()) {
               // val cell : CheckerParameters?
                val checker = gameModel.piecesBoard.elementAt(0)
               if (checker==CheckerParameters( j,i, Player.WHITE, CheckersMode.CHECKERS)){
                   button.apply {

                       background=Color.BLUE
                   }
               }
                if (checker==CheckerParameters(j,i, Player.BLACK, CheckersMode.CHECKERS)){
                    button.apply {

                        background=Color.GREEN
                    }
                }

            }

        }
    }


}