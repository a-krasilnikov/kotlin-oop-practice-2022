package lab3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ContactsServiceTest {

    @Test
    fun addContact() {
        val testingData = ContactsService()
        testingData.addContact(Person("Masha", "Sergeeva"), Phone(PhoneType.HOME, "602-63-55"))
        testingData.addContact(Person("Petr", "Sablin"), Phone(PhoneType.WORK, "89513562154"))
        testingData.addContact(Person("Sergey", "Novikov"), Phone(PhoneType.HOME, "327-58-94"))

        assertEquals(testingData.findPerson("Masha", "Sergeeva"), true)
        assertEquals(testingData.findPerson("Petr", "Sablin"), true)
        assertEquals(testingData.findPerson("Sergey", "Novikov"), true)

    }

    @Test
    fun removeContact() {
        val testingData = ContactsService()

        testingData.addContact(Person("Sergey", "Novikov"), Phone(PhoneType.HOME, "327-58-94"))
        testingData.addContact(Person("Sergey", "Novikov"), Phone(PhoneType.HOME, "327-58-89"))


        testingData.removeContact(Person("Sergey", "Novikov"), Phone(PhoneType.HOME, "327-58-94"))

        assertEquals(testingData.getPersonPhones(Person("Sergey", "Novikov")),
            listOf(Phone(PhoneType.HOME, "327-58-89")))
    }

    @Test
    fun removePerson() {
        val testingData = ContactsService()
        testingData.addContact(Person("Masha", "Sergeeva"), Phone(PhoneType.HOME, "602-63-55"))
        testingData.addContact(Person("Petr", "Sablin"), Phone(PhoneType.WORK, "89513562154"))
        testingData.addContact(Person("Sergey", "Novikov"), Phone(PhoneType.HOME, "327-58-94"))

        testingData.removePerson(Person("Masha", "Sergeeva"))

        assertEquals(testingData.findPerson("Masha", "Sergeeva"), false)

    }

    @Test
    fun addPhone() {
        val testingData = ContactsService()
        testingData.addContact(Person("Masha", "Sergeeva"), Phone(PhoneType.HOME, "602-63-55"))

        testingData.addPhone(Person("Masha", "Sergeeva"), "89565754123", PhoneType.MOBILE)

        assertEquals(testingData.getPersonPhones(Person("Masha", "Sergeeva")),
            listOf(Phone(PhoneType.HOME, "602-63-55"),
                Phone(PhoneType.MOBILE, "89565754123")))


    }

    @Test
    fun addEmail() {
        val testingData = ContactsService()
        testingData.addContact(Person("Masha", "Sergeeva"), Phone(PhoneType.HOME, "602-63-55"))

        testingData.addEmail(Person("Masha", "Sergeeva"), "MashkaMashka@mail.ru")

        assertEquals(testingData.getPersonEmails(Person("Masha", "Sergeeva")), listOf(Email("MashkaMashka@mail.ru")))

    }

    @Test
    fun addLink() {
        val testingData = ContactsService()
        testingData.addContact(Person("Masha", "Sergeeva"), Phone(PhoneType.HOME, "602-63-55"))

        testingData.addLink(Person("Masha", "Sergeeva"), NameNetwork.TG, "MAsha4546.ru")

        assertEquals(testingData.getPersonLink(Person("Masha", "Sergeeva")),
            listOf(LinksToASocialNetworkProfile(NameNetwork.TG, "MAsha4546.ru")))
    }

    @Test
    fun addAddress() {
        val testingData = ContactsService()
        testingData.addContact(Person("Masha", "Sergeeva"), Phone(PhoneType.HOME, "602-63-55"))

        testingData.addAddress(Person("Masha", "Sergeeva"), "Kirov", "Shorsa", 1, 1)

        assertEquals(testingData.getPersonAddress(Person("Masha", "Sergeeva")),
            listOf(Address("Kirov", "Shorsa", 1, 1)))
    }

    @Test
    fun removePhone() {
        val testingData = ContactsService()
        testingData.addContact(Person("Masha", "Sergeeva"), Phone(PhoneType.HOME, "602-63-55"))
        testingData.addPhone(Person("Masha", "Sergeeva"), "89565754123", PhoneType.MOBILE)

        testingData.removePhone(Person("Masha", "Sergeeva"), "89565754123", PhoneType.MOBILE)

        assertEquals(testingData.getPersonPhones(Person("Masha", "Sergeeva")),
            listOf(Phone(PhoneType.HOME, "602-63-55")))


    }

    @Test
    fun removeEmail() {
        val testingData = ContactsService()
        testingData.addContact(Person("Masha", "Sergeeva"), Email("MashkaMashka@mail.ru"))

        testingData.addEmail(Person("Masha", "Sergeeva"), "MashkaMashka@Yandex.ru")
        testingData.removeEmail(Person("Masha", "Sergeeva"), "MashkaMashka@Yandex.ru")

        assertEquals(testingData.getPersonEmails(Person("Masha", "Sergeeva")), listOf(Email("MashkaMashka@mail.ru")))
    }

    @Test
    fun removeLink() {
        val testingData = ContactsService()
        testingData.addContact(Person("Masha", "Sergeeva"),
            LinksToASocialNetworkProfile(NameNetwork.INST, "MAsha4546INST.ru"))

        testingData.addLink(Person("Masha", "Sergeeva"), NameNetwork.TG, "MAsha4546.ru")
        testingData.removeLink(Person("Masha", "Sergeeva"), "MAsha4546.ru", NameNetwork.TG)

        assertEquals(testingData.getPersonLink(Person("Masha", "Sergeeva")),
            listOf(LinksToASocialNetworkProfile(NameNetwork.INST, "MAsha4546INST.ru")))
    }

    @Test
    fun removeAddress() {
        val testingData = ContactsService()
        testingData.addContact(Person("Masha", "Sergeeva"), Address("SPB", "pr.Novoismailovski", 16, 1))

        testingData.addAddress(Person("Masha", "Sergeeva"), "Kirov", "Shorsa", 1, 1)
        testingData.removeAddress(Person("Masha", "Sergeeva"), "SPB", "pr.Novoismailovski", 16, 1)

        assertEquals(testingData.getPersonAddress(Person("Masha", "Sergeeva")),
            listOf(Address("Kirov", "Shorsa", 1, 1)))
    }

    @Test
    fun getPersonContacts() {
        val testingData = ContactsService()

        testingData.addContact(Person("Dasha", "Zonova"), Phone(PhoneType.MOBILE, "89819026277"))
        testingData.addLink(Person("Dasha", "Zonova"), NameNetwork.INST, "URL_ppipfodps_54565465")
        testingData.addEmail(Person("Dasha", "Zonova"), "DAshaMasha.@mail.ru")
        testingData.addAddress(Person("Dasha", "Zonova"), "SPB", "pr.Novoismailovski", 16, 1)


        val testingData1 = ContactsService()
        testingData1.addContact(Person("Dasha", "Zonova"), Phone(PhoneType.MOBILE, "89819026277"))
        testingData1.addLink(Person("Dasha", "Zonova"), NameNetwork.INST, "URL_ppipfodps_54565465")
        testingData1.addEmail(Person("Dasha", "Zonova"), "DAshaMasha.@mail.ru")
        testingData1.addAddress(Person("Dasha", "Zonova"), "SPB", "pr.Novoismailovski", 16, 1)

        assertEquals(testingData.getPersonContacts(Person("Dasha", "Zonova")),
            testingData1.getPersonContacts(Person("Dasha", "Zonova")))


    }

    @Test
    fun getPersonPhones() {
        val testingData = ContactsService()
        testingData.addContact(Person("Masha", "Sergeeva"), Phone(PhoneType.HOME, "602-63-55"))
        testingData.addPhone(Person("Masha", "Sergeeva"), "89565754123", PhoneType.MOBILE)

        assertEquals(testingData.getPersonPhones(Person("Masha", "Sergeeva")),
            listOf(Phone(PhoneType.HOME, "602-63-55"),
                Phone(PhoneType.MOBILE, "89565754123")))


    }

    @Test
    fun getPersonEmails() {
        val testingData = ContactsService()
        testingData.addContact(Person("Masha", "Sergeeva"), Email("MashkaMashka@mail.ru"))

        testingData.addEmail(Person("Masha", "Sergeeva"), "MashkaMashka@Yandex.ru")
        testingData.removeEmail(Person("Masha", "Sergeeva"), "MashkaMashka@Yandex.ru")

        assertEquals(testingData.getPersonEmails(Person("Masha", "Sergeeva")), listOf(Email("MashkaMashka@mail.ru")))


    }

    @Test
    fun getPersonLink() {
        val testingData = ContactsService()
        testingData.addContact(Person("Masha", "Sergeeva"),
            LinksToASocialNetworkProfile(NameNetwork.INST, "MAsha4546INST.ru"))

        testingData.addLink(Person("Masha", "Sergeeva"), NameNetwork.TG, "MAsha4546.ru")
        testingData.removeLink(Person("Masha", "Sergeeva"), "MAsha4546.ru", NameNetwork.TG)

        assertEquals(testingData.getPersonLink(Person("Masha", "Sergeeva")),
            listOf(LinksToASocialNetworkProfile(NameNetwork.INST, "MAsha4546INST.ru")))

    }

    @Test
    fun getPersonAddress() {
        val testingData = ContactsService()
        testingData.addContact(Person("Masha", "Sergeeva"), Address("SPB", "pr.Novoismailovski", 16, 1))

        testingData.addAddress(Person("Masha", "Sergeeva"), "Kirov", "Shorsa", 1, 1)
        testingData.removeAddress(Person("Masha", "Sergeeva"), "SPB", "pr.Novoismailovski", 16, 1)

        assertEquals(testingData.getPersonAddress(Person("Masha", "Sergeeva")),
            listOf(Address("Kirov", "Shorsa", 1, 1)))
    }

    @Test
    fun getAllPersons() {
        val testingData = ContactsService()
        testingData.addContact(Person("Masha", "Sergeeva"), Phone(PhoneType.HOME, "602-63-55"))
        testingData.addContact(Person("Petr", "Sablin"), Phone(PhoneType.WORK, "89513562154"))
        testingData.addContact(Person("Sergey", "Novikov"), Phone(PhoneType.HOME, "327-58-94"))

        val testingData1 = ContactsService()
        testingData1.addContact(Person("Masha", "Sergeeva"), Phone(PhoneType.HOME, "602-63-55"))
        testingData1.addContact(Person("Petr", "Sablin"), Phone(PhoneType.WORK, "89513562154"))
        testingData1.addContact(Person("Sergey", "Novikov"), Phone(PhoneType.HOME, "327-58-94"))

        assertEquals(testingData.getAllPersons(), testingData1.getAllPersons())


    }

    @Test
    fun getAllContacts() {

        val testingData = ContactsService()
        testingData.addContact(Person("Masha", "Sergeeva"), Phone(PhoneType.HOME, "602-63-55"))
        testingData.addContact(Person("Petr", "Sablin"), Phone(PhoneType.WORK, "89513562154"))
        testingData.addContact(Person("Sergey", "Novikov"), Phone(PhoneType.HOME, "327-58-94"))

        val testingData1 = ContactsService()
        testingData1.addContact(Person("Masha", "Sergeeva"), Phone(PhoneType.HOME, "602-63-55"))
        testingData1.addContact(Person("Petr", "Sablin"), Phone(PhoneType.WORK, "89513562154"))
        testingData1.addContact(Person("Sergey", "Novikov"), Phone(PhoneType.HOME, "327-58-94"))

        assertEquals(testingData.getAllContacts(), testingData1.getAllContacts())

    }

    @Test
    fun findPerson() {
        val testingData = ContactsService()
        testingData.addContact(Person("Masha", "Sergeeva"), Phone(PhoneType.HOME, "602-63-55"))
        testingData.addContact(Person("Petr", "Sablin"), Phone(PhoneType.WORK, "89513562154"))
        testingData.addContact(Person("Sergey", "Novikov"), Phone(PhoneType.HOME, "327-58-94"))

        assertEquals(testingData.findPerson("Masha", "Sergeeva"), true)
        assertEquals(testingData.findPerson("Petr", "Sablin"), true)
        assertEquals(testingData.findPerson("Sergey", "Novikov"), true)

    }
}