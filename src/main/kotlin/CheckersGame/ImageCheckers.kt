package CheckersGame


import java.awt.Image
import javax.swing.ImageIcon

object ImageCheckers {

    class nameImg(
        val whiteChecker: Image,
        val blackChecker: Image,
        val whiteQueen: Image,
        val blackQueen: Image,
    )

    private fun findImage(): nameImg {
        return nameImg(


            ImageIcon("src/main/resources/checkerWhite.png").image,
            ImageIcon("src/main/resources/checkerBlack.png").image,
            ImageIcon("src/main/resources/whiteQ.png").image,
            ImageIcon("src/main/resources/blackQ.png").image,

        )
    }
    val nameImage = findImage()
}