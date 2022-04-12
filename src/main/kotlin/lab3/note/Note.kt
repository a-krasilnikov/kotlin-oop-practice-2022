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


}
