package lab3

import lab3.noteService.NoteService
import java.net.URL
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

fun main() {
    val myBirthday = LocalDateTime.of(LocalDate.of(2003, 5, 10), LocalTime.of(11, 30, 0, 0))
    val dogBirthday = LocalDateTime.of(LocalDate.of(2013, 9, 6), LocalTime.of(8, 20, 0, 0))
    val noteService = NoteService()

    val taskNote2 = noteService.createTask("my birthday!", "do nothing", myBirthday)
    val textNote = noteService.createTextNote("pat the dog", "on the belly")
    val linkNote = noteService.createLink(
        "LOOK",
        "so cute",
        URL("https://c.wallhere.com/photos/f1/5d/dog_space_universe_Garlic_Corgi-775156.jpg!d")
    )
    val taskNote1 = noteService.createTask("dog's birthday!", "buy the yummies", dogBirthday)


    noteService.add(textNote)
    noteService.add(linkNote)
    noteService.add(taskNote1)

    println("note list: ${noteService.getAllNotes()}")

    noteService.add(taskNote2)
    println("add new note: ${noteService.getAllNotes()}")

    println("getAllTextNotes(): ${noteService.getAllTextNotes()}\n")
    println("getAllTasks(): ${noteService.getAllTasks()}\n")
    println("getAllLinks(): ${noteService.getAllLinks()}\n")

    noteService.removeNote(taskNote2)
    println("removeNote(): ${noteService.getAllNotes()}\n")
    noteService.add(taskNote2)

    println("findByTitle(LOOK): ${noteService.findByTitle("LOOK")}\n")
    println("findByType(myBirthdayNote.javaClass): ${noteService.findByType(taskNote2.javaClass)}\n")

    println("getSortedByTitle(): ${noteService.getSortedByTitle()}\n")
    println("getSortedByDate(): ${noteService.getSortedByDate()}\n")
}