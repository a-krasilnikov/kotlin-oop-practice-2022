package lab1

data class Book(val title: String, val authors: List<String>, val year: Int) {

    override fun toString(): String {
        return "\n" +
                "Book(\n" +
                "title='$title'\n" +
                "authors=${authors}\n" +
                "year=$year)\n"
    }
}