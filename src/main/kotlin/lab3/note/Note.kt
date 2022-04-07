package lab3.note

import java.net.URL
import java.sql.Date
import java.time.LocalDateTime

sealed class Note(var title: String, var content: String, val date: LocalDateTime) {

    class TextNote(_title: String, _content: String, _date: LocalDateTime) : Note(_title, _content, _date)

    class Task(_title: String, _content: String, _date: LocalDateTime, var task: String, var deadline: Date) :
        Note(_title, _content, _date)

    class Link(_title: String, _content: String, _date: LocalDateTime, var url: URL) : Note(_title, _content, _date)

}
