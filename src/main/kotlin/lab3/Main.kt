package lab3

import lab3.note.Note
import lab3.noteService.NoteService
import java.net.URL
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

fun main() {
    val myBirthday = LocalDateTime.of(LocalDate.of(2003, 5, 10), LocalTime.of(11, 30, 0, 0))
    val dogBirthday = LocalDateTime.of(LocalDate.of(2013, 9, 6), LocalTime.of(8, 20, 0, 0))

    val myBirthdayNote = Note.Task("my birthday!", "do nothing", myBirthday, LocalDateTime.now())

    val noteService = NoteService()
    noteService.add("pat the dog", "on the belly")
    noteService.add(
        "LOOK",
        "so cute",
        URL("https://c.wallhere.com/photos/f1/5d/dog_space_universe_Garlic_Corgi-775156.jpg!d")
    )
    noteService.add("dog's birthday!", "buy the yummies", dogBirthday)

    println("note list: ${noteService.getAllNotes()}")

    noteService.add(myBirthdayNote)
    println("add new note: ${noteService.getAllNotes()}")

    println("getAllTextNotes(): ${noteService.getAllTextNotes()}\n")
    println("getAllTasks(): ${noteService.getAllTasks()}\n")
    println("getAllLinks(): ${noteService.getAllLinks()}\n")

    noteService.removeNote(myBirthdayNote)
    println("removeNote(): ${noteService.getAllNotes()}\n")
    noteService.add(myBirthdayNote)

    println("findByTitle(LOOK): ${noteService.findByTitle("LOOK")}\n")
    println("findByType(myBirthdayNote.javaClass): ${noteService.findByType(myBirthdayNote.javaClass)}\n")

    println("getSortedByTitle(): ${noteService.getSortedByTitle()}\n")
    println("getSortedByDate(): ${noteService.getSortedByDate()}\n")
}