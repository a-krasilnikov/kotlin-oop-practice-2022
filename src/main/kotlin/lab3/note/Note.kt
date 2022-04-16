package lab3.note

import java.net.URL
import java.time.LocalDateTime

sealed class Note(var title: String?, var content: String?, val date: LocalDateTime) {

    class TextNote(_title: String, _content: String, _date: LocalDateTime) : Note(_title, _content, _date) {
        override fun toString(): String {
            return "\nNote(\n" +
                    "\ttitle: '$title'\n" +
                    "\tcontent: '$content'\n" +
                    "\tdate: $date)"
        }

    }

    class Task(_title: String, val task: String, var deadline: LocalDateTime, _date: LocalDateTime) :
        Note(_title, null, _date) {
        override fun toString(): String {
            return "\nNote(\n" +
                    "\ttitle: '$title'\n" +
                    "\ttask: $task\n" +
                    "\tdeadline: $deadline\n" +
                    "\tdate: $date)"
        }

    }

    class Link(_title: String, _content: String, _date: LocalDateTime, var url: URL) : Note(_title, _content, _date) {
        override fun toString(): String {
            return "\nNote(\n" +
                    "\ttitle: '$title'\n" +
                    "\tcontent: '$content'\n" +
                    "\turl: $url\n" +
                    "\tdate: $date)"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Note

        if (title != other.title) return false
        if (content != other.content) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title?.hashCode() ?: 0
        result = 31 * result + (content?.hashCode() ?: 0)
        result = 31 * result + date.hashCode()
        return result
    }


}
