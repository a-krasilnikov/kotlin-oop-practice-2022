package CheckersGame.View
import CheckersGame.*
import CheckersGame.ImageCheckers.nameImage
import java.awt.*
import javax.swing.*

private const val GAP = 0

class UI : JFrame("Checkers Game"), ModelChangeListener {
    private var gameModel: ModelGame = ModelGame()
    private val statusLabel = JLabel("Status", JLabel.CENTER)
    private val buttons = mutableListOf<MutableList<JButton>>()
    private var BOARD_SIZE=8
    init {
        setSize(1000, 1000)
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

        gameModel.piecesBoard.forEach {
         print(it.row.toString() + " " + it.col.toString() + " | ")
            if(it.Checker == CheckersMode.CHECKERS && it.player == Player.WHITE) {
                buttons[it.row][it.col].apply {
                    background=Color.lightGray
                    icon = ImageIcon(nameImage.whiteChecker.getScaledInstance(60, 60, Image.SCALE_SMOOTH))
                }
            }

            if(it.Checker == CheckersMode.CHECKERS && it.player == Player.BLACK) {
                buttons[it.row][it.col].apply {
                    background=Color.lightGray
                    icon = ImageIcon(nameImage.blackChecker.getScaledInstance(60, 60, Image.SCALE_SMOOTH))

                }
            }

            if(it.Checker == CheckersMode.QUEEN && it.player == Player.WHITE) {
                buttons[it.row][it.col].apply {
                    background=Color.lightGray
                    icon = ImageIcon(nameImage.whiteQueen.getScaledInstance(60, 60, Image.SCALE_SMOOTH))

                }
            }

            if(it.Checker == CheckersMode.QUEEN && it.player == Player.BLACK) {
                buttons[it.row][it.col].apply {
                    background=Color.lightGray
                    icon = ImageIcon(nameImage.blackQueen.getScaledInstance(60, 60, Image.SCALE_SMOOTH))

                }
            }
        }

    }


}