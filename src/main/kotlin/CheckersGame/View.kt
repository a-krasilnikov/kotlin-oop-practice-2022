package CheckersGame

class ConsoleUi(private val model: ModelGame) {
    init {
        val listener = object : ModelChangeListener {
            override fun onModelChanged() {
                repaint()
            }
        }
        model.addModelChangeListener(listener)

        repaint()
    }

    private fun repaint() {
        Runtime.getRuntime().exec("clear")
        println(model)
    }
}