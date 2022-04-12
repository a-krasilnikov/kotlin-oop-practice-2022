package lab1

data class Book(val title: String, val authors: List<String>, val year: Int) {
    override fun toString(): String {
        return "\nBook(\n" +
                "\ttitle: '$title'\n" +
                "\tauthors: ${authors}\n" +
                "\tyear: $year)\n"
    }
}