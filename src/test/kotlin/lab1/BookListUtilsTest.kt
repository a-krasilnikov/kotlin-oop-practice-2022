package lab1

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class BookListUtilsTest {
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
        assertEquals(null, findTheOldestBooks(emptyList<Book>()))

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

        assertTrue(
            listOf(theYoungPeasantWoman, eugeneOnegin) == findTheOldestBooks(bookListWithThreeStroke) ||
                    listOf(eugeneOnegin, theYoungPeasantWoman) == findTheOldestBooks(bookListWithThreeStroke)
        )
    }

    @Test
    fun findTheYoungestBooks() {
        assertEquals(null, findTheYoungestBooks(emptyList<Book>()))

        val bookListWithOneStroke = listOf(
            Book(
                "Snail on the Slope",
                listOf("Arkady Natanovich Strugatsky", "Boris Natanovich Strugatsky"), 1965
            )
        )
        assertEquals(listOf(snailOnTheSlope), findTheYoungestBooks(bookListWithOneStroke))


        val bookListWithTwoStroke = listOf(
            Book("Eugene Onegin", listOf("Alexander Sergeyevich Pushkin"), 1831),
            Book("The Young Peasant Woman", listOf("Alexander Sergeyevich Pushkin"), 1831)
        )

        assertTrue(
            listOf(theYoungPeasantWoman, eugeneOnegin) == findTheOldestBooks(bookListWithTwoStroke) ||
                    listOf(eugeneOnegin, theYoungPeasantWoman) == findTheOldestBooks(bookListWithTwoStroke)
        )
        val bookListWithThreeStroke = listOf(
            Book("Eugene Onegin", listOf("Alexander Sergeyevich Pushkin"), 1831),
            Book("Snail on the Slope", listOf("Arkady Natanovich Strugatsky", "Boris Natanovich Strugatsky"), 1965),
            Book("The Young Peasant Woman", listOf("Alexander Sergeyevich Pushkin"), 1831)
        )
        assertEquals(listOf(snailOnTheSlope), findTheYoungestBooks(bookListWithThreeStroke))
    }

    @Test
    fun findTheBooksWithTheLongestTitle() {
        assertEquals(null, findTheBooksWithTheLongestTitle(emptyList<Book>()))

        val bookListWithOneStroke = listOf(
            Book(
                "Snail on the Slope",
                listOf("Arkady Natanovich Strugatsky", "Boris Natanovich Strugatsky"), 1965
            )
        )
        assertEquals(listOf(snailOnTheSlope), findTheBooksWithTheLongestTitle(bookListWithOneStroke))

        val bookListWithTwoStroke = listOf(
            Book("Snail on the Slope", listOf("Arkady Natanovich Strugatsky", "Boris Natanovich Strugatsky"), 1965),
            Book("The Young Peasant Woman", listOf("Alexander Sergeyevich Pushkin"), 1831)
        )
        assertEquals(listOf(theYoungPeasantWoman), findTheBooksWithTheLongestTitle(bookListWithTwoStroke))

        val bookListWithThreeStroke = listOf(
            Book("Eugene Onegin", listOf("Alexander Sergeyevich Pushkin"), 1831),
            Book("Snail on the Slope", listOf("Arkady Natanovich Strugatsky", "Boris Natanovich Strugatsky"), 1965),
            Book("The Young Peasant Woman", listOf("Alexander Sergeyevich Pushkin"), 1831)
        )
        println(findTheOldestBooks(bookListWithThreeStroke))
        assertEquals(
            listOf(theYoungPeasantWoman), findTheBooksWithTheLongestTitle(bookListWithThreeStroke)
        )
    }

    @Test
    fun findTheBooksWithTheShortestTitle() {
        assertEquals(null, findTheBooksWithTheShortestTitle(emptyList<Book>()))

        val bookListWithOneStroke = listOf(
            Book(
                "Snail on the Slope",
                listOf("Arkady Natanovich Strugatsky", "Boris Natanovich Strugatsky"), 1965
            )
        )
        assertEquals(listOf(snailOnTheSlope), findTheBooksWithTheShortestTitle(bookListWithOneStroke))

        val bookListWithTwoStroke = listOf(
            Book("Snail on the Slope", listOf("Arkady Natanovich Strugatsky", "Boris Natanovich Strugatsky"), 1965),
            Book("The Young Peasant Woman", listOf("Alexander Sergeyevich Pushkin"), 1831)
        )
        assertEquals(listOf(snailOnTheSlope), findTheBooksWithTheShortestTitle(bookListWithTwoStroke))

        val bookListWithThreeStroke = listOf(
            Book("Eugene Onegin", listOf("Alexander Sergeyevich Pushkin"), 1831),
            Book("Snail on the Slope", listOf("Arkady Natanovich Strugatsky", "Boris Natanovich Strugatsky"), 1965),
            Book("The Young Peasant Woman", listOf("Alexander Sergeyevich Pushkin"), 1831)
        )
        println(findTheOldestBooks(bookListWithThreeStroke))
        assertEquals(
            listOf(eugeneOnegin), findTheBooksWithTheShortestTitle(bookListWithThreeStroke)
        )
    }
}