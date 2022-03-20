package lab1

fun parseBooks(books: String): List<Book> {

    val booksList = mutableListOf<Book>()

    val delimiter = "//"

    books.lines().forEach {
        if (it.isNotEmpty()) {//simulate continue for empty list, interline or final enter

            // takes "N. THIS <delimiter> Author_1, Author_2,..., Author_M <delimiter> year" as String
            val title = it.substringAfter('.').substringBefore(delimiter).trim()

            // takes "N. title <delimiter> [THIS_1, AND THIS_2,..., AND THIS_M] <delimiter> year" as MutableList<String>
            val authors: MutableList<String> = mutableListOf()
            it.substringAfter(delimiter).substringBeforeLast(delimiter).replace(',', '\n').lines()
                .forEach { currentAuthor ->
                    authors.add(currentAuthor.trim())
                }

            // takes "N. title <delimiter> Author_1, Author_2,..., Author_M <delimiter> THIS" as Int
            val year = it.substringAfterLast(delimiter).trim().toInt()

            booksList.add(Book(title, authors.toList(), year))
        }
    }
    return booksList
}

fun findTheOldestBooks(bookList: List<Book>): List<Book>? {
    if (bookList.isEmpty()) return null
    val minYear = bookList.minOf { it.year }
    return bookList.filter { it.year == minYear }
}

fun findTheYoungestBooks(bookList: List<Book>): List<Book>? {
    if (bookList.isEmpty()) return null
    val maxYear = bookList.maxOf { it.year }
    return bookList.filter { it.year == maxYear }
}

fun findTheBooksWithTheLongestTitle(bookList: List<Book>): List<Book>? {
    if (bookList.isEmpty()) return null
    val maxTitle = bookList.maxOf { it.title.length }
    return bookList.filter { it.title.length == maxTitle }
}

fun findTheBooksWithTheShortestTitle(bookList: List<Book>): List<Book>? {
    if (bookList.isEmpty()) return null
    val minTitle = bookList.minOf { it.title.length }
    return bookList.filter { it.title.length == minTitle }
}

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
        "The oldest books in the list:\n" +
                "${findTheOldestBooks(bookList)}\n"
    )

    println(
        "The youngest books in the list:\n" +
                "${findTheYoungestBooks(bookList)}\n"
    )

    println(
        "The books with the longest titles in the list:\n" +
                "${findTheBooksWithTheLongestTitle(bookList)}\n"
    )

    println(
        "The books with the shortest titles in the list:\n" +
                "${findTheBooksWithTheShortestTitle(bookList)}\n"
    )
}