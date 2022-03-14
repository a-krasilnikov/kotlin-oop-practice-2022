package lab1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun parseBooks() {

        val emptyBookList = parseBooks("")
        val emptyBookListCopy: List<Book> = emptyList()
        assertEquals(0, emptyBookList.size)
        assertEquals(emptyBookListCopy.hashCode(), emptyBookList.hashCode())


        val bookListWithOneStroke = parseBooks("1. Eugene Onegin // Alexander Sergeyevich Pushkin // 1831\n")
        val bookListWithOneStrokeCopy = listOf(Book("Eugene Onegin", listOf("Alexander Sergeyevich Pushkin"), 1831))
        assertEquals(1, bookListWithOneStroke.size)
        assertEquals(bookListWithOneStrokeCopy.hashCode(), bookListWithOneStroke.hashCode())


        val bookListWithThreeStroke = parseBooks(
            "1. Eugene Onegin // Alexander Sergeyevich Pushkin // 1831\n" +
                    "2. Snail on the Slope // Arkady Natanovich Strugatsky, Boris Natanovich Strugatsky // 1965\n" +
                    "3. The Master and Margarita // Mikhail Afanasyevich Bulgakov // 1940\n"
        )
        val bookListWithThreeStrokeCopy = listOf(
            Book("Eugene Onegin", listOf("Alexander Sergeyevich Pushkin"), 1831),
            Book("Snail on the Slope", listOf("Arkady Natanovich Strugatsky", "Boris Natanovich Strugatsky"), 1965),
            Book("The Master and Margarita", listOf("Mikhail Afanasyevich Bulgakov"), 1940)
        )
        assertEquals(3, bookListWithThreeStroke.size)
        assertEquals(bookListWithThreeStrokeCopy.hashCode(), bookListWithThreeStroke.hashCode())


        val alsoBookListWithThreeStroke = parseBooks(
            "1. Eugene Onegin // Alexander Sergeyevich Pushkin // 1831\n" +
                    "\n" +
                    "2. Snail on the Slope // Arkady Natanovich Strugatsky, Boris Natanovich Strugatsky // 1965\n" +
                    "\n" +
                    "3. The Master and Margarita // Mikhail Afanasyevich Bulgakov // 1940\n"
        )
        assertEquals(3, alsoBookListWithThreeStroke.size)
        assertEquals(bookListWithThreeStrokeCopy.hashCode(), alsoBookListWithThreeStroke.hashCode())
    }
}