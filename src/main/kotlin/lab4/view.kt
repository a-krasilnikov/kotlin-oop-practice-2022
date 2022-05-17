package lab4

class View(private val model : ModelMaze) {
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
        Runtime.getRuntime().exec("cmd")
        println(model)
    }
}