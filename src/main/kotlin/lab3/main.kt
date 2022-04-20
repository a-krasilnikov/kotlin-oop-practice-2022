package lab3

fun main() {
    val testingData = ContactsService()

    testingData.addContact(Person("Masha", "Sergeeva"), Phone(PhoneType.HOME, "602-63-55"))
    testingData.addContact(Person("Petr", "Sablin"), Phone(PhoneType.WORK, "89513562154"))
    testingData.addContact(Person("Sergey", "Novikov"), Phone(PhoneType.HOME, "327-58-94"))


    testingData.addContact(Person("Dasha", "Zonova"), Phone(PhoneType.MOBILE, "89819026277"))
    testingData.addLink(Person("Dasha", "Zonova"), NameNetwork.INST, "URL_ppipfodps_54565465")
    testingData.addEmail(Person("Dasha", "Zonova"), "DAshaMasha.@mail.ru")
    testingData.addAddress(Person("Dasha", "Zonova"), "SPB", "pr.Novoismailovski", 16, 1)



    println(testingData.findPerson("Dasha", "Zonova"))
    println(testingData.getPersonPhones(Person("Dasha", "Zonova")))
    println(testingData.getPersonEmails(Person("Dasha", "Zonova")))
    println(testingData.getPersonLink(Person("Dasha", "Zonova")))
    println(testingData.getPersonAddress(Person("Dasha", "Zonova")))
    println(testingData.getAllPersons())
    println(testingData.getAllContacts())
}