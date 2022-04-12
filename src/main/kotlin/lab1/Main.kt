package lab1

fun main() {
    println(findTheBooksWithTheShortestTitle(emptyList<Book>()))
    val strokeForParsing = "1. Eugene Onegin // Alexander Sergeyevich Pushkin // 1831\n" +
            "2. Snail on the Slope // Arkady Natanovich Strugatsky, Boris Natanovich Strugatsky // 1965\n" +
            "3. The Young Peasant Woman // Alexander Sergeyevich Pushkin // 1831\n"
    val bookList = parseBooks(strokeForParsing)

    println(
        "Stroke for parsing:\n" +
                "$strokeForParsing\n" +
                "Result:\n" +
                "$bookList.toString()\n"
    )

    println(
        "The oldest books:\n" +
                "${findTheOldestBooks(bookList)}\n"
    )

    println(
        "The youngest books:\n" +
                "${findTheYoungestBooks(bookList)}\n"
    )

    println(
        "The books with the longest titles:\n" +
                "${findTheBooksWithTheLongestTitle(bookList)}\n"
    )

    println(
        "The books with the shortest titles:\n" +
                "${findTheBooksWithTheShortestTitle(bookList)}\n"
    )
}