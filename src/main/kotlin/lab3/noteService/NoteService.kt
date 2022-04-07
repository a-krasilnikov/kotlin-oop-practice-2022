package lab3.noteService

import lab3.note.Note
import lab3.note.Note.*
import java.net.URL
import java.sql.Date
import java.time.LocalDateTime

class NoteService() : NoteServiceInterface {
    override val noteList
        get() = _noteMutableList.toList()

    private val _noteMutableList: MutableList<Note> = mutableListOf<Note>()


    override fun add(note: Note) {
        _noteMutableList.add(note)
    }

    override fun add(list: List<Note>) {
        _noteMutableList.addAll(list)
    }

    override fun getAllNotes(): List<Note> = noteList


    override fun getAllTextNotes(): List<TextNote> = _noteMutableList.filterIsInstance<TextNote>()
    override fun getAllTasks(): List<Task> = _noteMutableList.filterIsInstance<Task>()
    override fun getAllLinks(): List<Link> = _noteMutableList.filterIsInstance<Link>()


    override fun createTextNote(title: String, content: String): TextNote =
        TextNote(title, content, LocalDateTime.now())

    override fun createTask(title: String, content: String, task: String, deadline: Date): Task =
        Task(title, content, LocalDateTime.now(), task, deadline)

    override fun createLink(title: String, content: String, url: URL): Link =
        Link(title, content, LocalDateTime.now(), url)


    override fun removeNote(note: Note) {
        _noteMutableList.remove(note)
    }

    override fun findByTitle(title: String): List<Note> = _noteMutableList.filter { it.title == title }
    override fun findByType(type: Class<Any>): List<Note> = _noteMutableList.filter { it.javaClass == type }

    override fun getSortedByTitle(): List<Note> = _noteMutableList.toMutableList().sortedBy { it.title }
    override fun getSortedByDate(): List<Note> = _noteMutableList.toMutableList().sortedBy { it.date }
}