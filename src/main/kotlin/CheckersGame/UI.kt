package CheckersGame.View

import CheckersGame.*
import CheckersGame.ImageCheckers.nameImage
import java.awt.*
import javax.swing.*

private const val GAP = 0

class UI : JFrame("Checkers Game"), ModelChangeListener {
    var ROW = 0
    var COL = 0
    var ROWto = 0
    var COLto = 0
    var COUNT = 0
    var inTo = 1
    private var gameModel : ModelGame = ModelGame()
    var statusLabel = JLabel("Move", JLabel.CENTER)
    private val buttons = mutableListOf<MutableList<JButton>>()
    private var BOARD_SIZE = 8

    init {
        setSize(900, 830)
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

    private fun createRestartButton() : Component {
        val restartButton = JButton("Restart")
        updateFont(restartButton, 20.0f)
        restartButton.addActionListener {
            if (gameModel.state in GAME_NOT_FINISHED) {
                val dialogOption = JOptionPane.showConfirmDialog(this,
                    "are you sure to restart this game?",
                    "Restart",
                    JOptionPane.OK_CANCEL_OPTION)

                if (dialogOption == JOptionPane.OK_OPTION) {
                    gameModel.removeModelChangeListener(this)
                    gameModel = ModelGame()
                    gameModel.addModelChangeListener(this)
                    updateGameUI()
                }
            } else {
                gameModel.removeModelChangeListener(this)
                gameModel = ModelGame()
                gameModel.addModelChangeListener(this)
                updateGameUI()
            }
        }

        return restartButton
    }

    private fun resubscribe() {
        gameModel.removeModelChangeListener(this)
        gameModel.addModelChangeListener(this)
        updateGameUI()
    }

    private fun createBoardPanel() : Component {
        val gamePanel = JPanel(GridLayout(BOARD_SIZE, BOARD_SIZE, GAP, GAP))
        //gameModel.resetGame()
        for (i in 0 until BOARD_SIZE) {
            val buttonsRow = mutableListOf<JButton>()

            for (j in 0 until BOARD_SIZE) {

                val cellButton = JButton(" ")

                if (i.mod(2) != 0) {

                    if (j.mod(2) == 0) {
                        cellButton.background = Color.lightGray
                    } else {
                        cellButton.background = Color.WHITE
                    }

                } else {
                    if (j.mod(2) != 0) {
                        cellButton.background = Color.lightGray

                    } else {
                        cellButton.background = Color.WHITE
                    }
                }


                cellButton.addActionListener {
                    if (COUNT == 0) {
                        ROW = i
                        COL = j
                        COUNT++
                    } else {
                        ROWto = i
                        COLto = j
                        gameLogic()
                        COUNT = 0
                    }


                }

                buttonsRow.add(cellButton)
                gamePanel.add(cellButton)
                updateFont(cellButton, 30.0f)
            }
            buttons.add(buttonsRow)
        }

        return gamePanel
    }

    private fun updateFont(component : JComponent, newFontSize : Float) {
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
            if (it.Checker == CheckersMode.EMPTY && it.player == Player.EMPTY) {
                buttons[it.row][it.col].icon = null
            }

            if (it.Checker == CheckersMode.CHECKERS && it.player == Player.WHITE) {
                buttons[it.row][it.col].apply {
                    print(it.col.toString() + " " + it.row.toString() + " |-WC ")
                    background = Color.lightGray
                    icon = ImageIcon(nameImage.whiteChecker.getScaledInstance(60, 60, Image.SCALE_SMOOTH))
                }
            }

            if (it.Checker == CheckersMode.CHECKERS && it.player == Player.BLACK) {
                buttons[it.row][it.col].apply {
                    print(it.col.toString() + " " + it.row.toString() + " |BC ")
                    background = Color.lightGray
                    icon = ImageIcon(nameImage.blackChecker.getScaledInstance(60, 60, Image.SCALE_SMOOTH))

                }
            }

            if (it.Checker == CheckersMode.QUEEN && it.player == Player.WHITE) {
                buttons[it.row][it.col].apply {
                    background = Color.lightGray
                    icon = ImageIcon(nameImage.whiteQueen.getScaledInstance(60, 60, Image.SCALE_SMOOTH))

                }
            }

            if (it.Checker == CheckersMode.QUEEN && it.player == Player.BLACK) {
                buttons[it.row][it.col].apply {
                    background = Color.lightGray
                    icon = ImageIcon(nameImage.blackQueen.getScaledInstance(60, 60, Image.SCALE_SMOOTH))

                }
            }


        }
        println()
    }

    private fun checkWinWhite() : Int {
        var counter = 0
        gameModel.piecesBoard.forEach {

            if (it.player == Player.WHITE) {
                counter++
            }

        }
        return counter
    }

    private fun checkWinBlack() : Int {
        var counter = 0
        gameModel.piecesBoard.forEach {
            if (it.player == Player.BLACK) {
                counter++
            }
        }
        return counter
    }

    fun gameLogic() {

        if ((checkWinWhite() != 0) && (checkWinBlack() != 0)) {

            if (inTo.mod(2) != 0) {
                if (gameModel.whiteMove(COL, ROW, COLto, ROWto) == true) {
                    gameModel.whiteMove(COL, ROW, COLto, ROWto)
                    inTo++
                    println()
                    println(inTo)
                    println()
                    gameModel.state = State.BLACK_MOVE
                    if (checkWinWhite() == 0) gameModel.state = State.BLACK_WIN
                    if (checkWinBlack() == 0) gameModel.state = State.WHITE_WIN
                }
                updateGameUI()
            } else {
                if (gameModel.blackMove(COL, ROW, COLto, ROWto) == true) {
                    gameModel.blackMove(COL, ROW, COLto, ROWto)
                    inTo++
                    println()
                    println(inTo)
                    println()
                    gameModel.state = State.WHITE_MOVE
                    if (checkWinWhite() == 0) gameModel.state = State.BLACK_WIN
                    if (checkWinBlack() == 0) gameModel.state = State.WHITE_WIN
                }
                updateGameUI()
            }
        } else {
            if (checkWinWhite() == 0) gameModel.state = State.BLACK_WIN
            if (checkWinBlack() == 0) gameModel.state = State.WHITE_WIN
        }
        ROW = 0
        COL = 0
        ROWto = 0
        COLto = 0
    }


}

