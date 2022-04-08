package lab3.noteService

import lab3.note.Note
import lab3.note.Note.*
import java.net.URL
import java.time.LocalDateTime
import java.util.logging.Logger

val LOG: Logger = Logger.getLogger(NoteService()::class.java.name)

class NoteService() : NoteServiceInterface {
    override val noteList
        get() = _noteMutableList.toList()

    private val _noteMutableList: MutableList<Note> = mutableListOf<Note>()


    override fun add(note: Note) {
        _noteMutableList.add(note)
        LOG.info("new note has been added")
    }

    fun add(list: List<Note>) {
        _noteMutableList.addAll(list)
        LOG.info("new note has been added")
    }

    fun add(title: String, content: String) {
        add(createTextNote(title, content))
        LOG.info("new note has been added")
    }

    fun add(title: String, task: String, deadline: LocalDateTime) {
        add(createTask(title, task, deadline))
        LOG.info("new note has been added")
    }

    fun add(title: String, content: String, url: URL) {
        add(createLink(title, content, url))
        LOG.info("new note has been added")
    }

    fun addTextNotes(title: String, content: String) {
        add(createTextNote(title, content))
        LOG.info("new note has been added")
    }

    fun addTask(title: String, task: String, deadline: LocalDateTime) {
        add(createTask(title, task, deadline))
        LOG.info("new note has been added")
    }

    fun addLink(title: String, content: String, url: URL) {
        add(createLink(title, content, url))
        LOG.info("new note has been added")
    }

    override fun getAllNotes(): List<Note> = noteList


    override fun getAllTextNotes(): List<TextNote> = _noteMutableList.filterIsInstance<TextNote>()
    override fun getAllTasks(): List<Task> = _noteMutableList.filterIsInstance<Task>()
    override fun getAllLinks(): List<Link> = _noteMutableList.filterIsInstance<Link>()


    override fun createTextNote(title: String, content: String): TextNote =
        TextNote(title, content, LocalDateTime.now())

    override fun createTask(title: String, task: String, deadline: LocalDateTime): Task =
        Task(title, task, deadline, LocalDateTime.now())

    override fun createLink(title: String, content: String, url: URL): Link =
        Link(title, content, LocalDateTime.now(), url)


    override fun removeNote(note: Note) {
        _noteMutableList.remove(note)
        LOG.info("note has been removed")
    }

    override fun findByTitle(title: String): List<Note> = _noteMutableList.filter { it.title == title }
    override fun findByType(type: Class<Any>): List<Note> = _noteMutableList.filter { it.javaClass == type }

    override fun getSortedByTitle(): List<Note> = _noteMutableList.toMutableList().sortedBy { it.title }
    override fun getSortedByDate(): List<Note> = _noteMutableList.toMutableList().sortedBy { it.date }
}