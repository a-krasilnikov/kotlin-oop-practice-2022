package lab4

class view(private val model : ModelMaze) {
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
        Runtime.getRuntime().exec("clearing")
        println(model)
    }
}