package lab1

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {
    private val eugeneOnegin = Book("Eugene Onegin", listOf("Alexander Sergeyevich Pushkin"), 1831)
    private val snailOnTheSlope = Book(
        "Snail on the Slope",
        listOf("Arkady Natanovich Strugatsky", "Boris Natanovich Strugatsky"), 1965
    )
    private val theYoungPeasantWoman = Book(
        "The Young Peasant Woman",
        listOf("Alexander Sergeyevich Pushkin"), 1831
    )

    @Test
    fun parseBooks() {
        val emptyBookList = parseBooks("")
        val emptyBookListCopy: List<Book> = emptyList()
        assertEquals(0, emptyBookList.size)
        assertEquals(emptyBookListCopy, emptyBookList)


        val bookListWithOneStroke = parseBooks("1. Eugene Onegin // Alexander Sergeyevich Pushkin // 1831\n")
        val bookListWithOneStrokeCopy = listOf(eugeneOnegin)
        assertEquals(1, bookListWithOneStroke.size)
        assertEquals(bookListWithOneStrokeCopy, bookListWithOneStroke)


        val bookListWithThreeStroke = parseBooks(
            "1. Eugene Onegin // Alexander Sergeyevich Pushkin // 1831\n" +
                    "2. Snail on the Slope // Arkady Natanovich Strugatsky, Boris Natanovich Strugatsky // 1965\n" +
                    "3. The Young Peasant Woman // Alexander Sergeyevich Pushkin // 1831\n"
        )
        val bookListWithThreeStrokeCopy = listOf(eugeneOnegin, snailOnTheSlope, theYoungPeasantWoman)
        assertEquals(3, bookListWithThreeStroke.size)
        assertEquals(bookListWithThreeStrokeCopy, bookListWithThreeStroke)


        val alsoBookListWithThreeStroke = parseBooks(
            "1. Eugene Onegin // Alexander Sergeyevich Pushkin // 1831\n" +
                    "\n" +
                    "2. Snail on the Slope // Arkady Natanovich Strugatsky, Boris Natanovich Strugatsky // 1965\n" +
                    "\n" +
                    "3. The Young Peasant Woman // Alexander Sergeyevich Pushkin // 1831\n"
        )
        assertEquals(3, alsoBookListWithThreeStroke.size)
        assertEquals(bookListWithThreeStrokeCopy, alsoBookListWithThreeStroke)
    }

    @Test
    fun findTheOldestBooks() {
        val bookListWithOneStroke = listOf(
            Book(
                "Snail on the Slope",
                listOf("Arkady Natanovich Strugatsky", "Boris Natanovich Strugatsky"), 1965
            )
        )
        assertEquals(listOf(snailOnTheSlope), findTheOldestBooks(bookListWithOneStroke))

        val bookListWithTwoStroke = listOf(
            Book("Snail on the Slope", listOf("Arkady Natanovich Strugatsky", "Boris Natanovich Strugatsky"), 1965),
            Book("The Young Peasant Woman", listOf("Alexander Sergeyevich Pushkin"), 1831)
        )
        assertEquals(listOf(theYoungPeasantWoman), findTheOldestBooks(bookListWithTwoStroke))

        val bookListWithThreeStroke = listOf(
            Book("Eugene Onegin", listOf("Alexander Sergeyevich Pushkin"), 1831),
            Book("Snail on the Slope", listOf("Arkady Natanovich Strugatsky", "Boris Natanovich Strugatsky"), 1965),
            Book("The Young Peasant Woman", listOf("Alexander Sergeyevich Pushkin"), 1831)
        )
        println(findTheOldestBooks(bookListWithThreeStroke))
        assertTrue(
            findTheOldestBooks(bookListWithThreeStroke) == listOf(theYoungPeasantWoman, eugeneOnegin) ||
                    findTheOldestBooks(bookListWithThreeStroke) == listOf(eugeneOnegin, theYoungPeasantWoman)
        )
    }

}