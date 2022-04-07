package lab3.noteService

import lab3.note.Note
import java.net.URL
import java.sql.Date

interface NoteServiceInterface {
    val noteList: List<Note>

    fun add(note: Note)
    fun add(list: List<Note>)

    fun getAllNotes(): List<Note>
    fun getAllTextNotes(): List<Note.TextNote>
    fun getAllTasks(): List<Note.Task>
    fun getAllLinks(): List<Note.Link>

    fun createTextNote(title: String, content: String): Note.TextNote

    fun createTask(title: String, content: String, task: String, deadline: Date): Note.Task

    fun createLink(title: String, content: String, url: URL): Note.Link

    fun removeNote(note: Note)

    fun findByType(type: Class<Any>): List<Note>
    fun findByTitle(title: String): List<Note>

    fun getSortedByTitle(): List<Note>
    fun getSortedByDate(): List<Note>


}