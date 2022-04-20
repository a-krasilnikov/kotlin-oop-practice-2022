package lab3

val contactDetails : MutableMap<Person, MutableList<Contacts>> = mutableMapOf()

class ContactsService : ContactsServiceView {
    override fun addContact(person : Person, newContact : Contacts) {
        contactDetails.getOrPut(person) { mutableListOf() } += (newContact)
        //  https://translated.turbopages.org/proxy_u/en-ru.ru.fc461c15-625e9f3f-3b0a68c8-74722d776562/https/stackoverflow.com/questions/64562514/kotlin-idiomatic-way-to-add-an-item-to-a-list-in-a-map
    }

    override fun removeContact(person : Person, contact : Contacts) {
        contactDetails.getOrPut(person) { mutableListOf() } -= (contact)
    }

    override fun removePerson(person : Person) {
        contactDetails.remove(person)
    }

    override fun addPhone(person : Person, phone : String, phoneType : PhoneType) {
        addContact(person, Phone(phoneType, phone))
    }

    override fun addEmail(person : Person, email : String) {
        addContact(person, Email(email))
    }

    override fun addLink(person : Person, nameNetwork : NameNetwork, link : String) {
        addContact(person, LinksToASocialNetworkProfile(nameNetwork, link))
    }

    override fun addAddress(
        person : Person,
        city : String,
        street : String,
        houseNumber : Int,
        apartment : Int,
    ) {

        addContact(person, Address(city, street, houseNumber, apartment))

    }

    override fun removePhone(person : Person, phone : String, phoneType : PhoneType) {
        removeContact(person, Phone(phoneType, phone))
    }

    override fun removeEmail(person : Person, email : String) {
        removeContact(person, Email(email))
    }

    override fun removeLink(person : Person, link : String, nameNetwork : NameNetwork) {
        removeContact(person, LinksToASocialNetworkProfile(nameNetwork, link))
    }


    override fun removeAddress(
        person : Person,
        city : String,
        street : String,
        houseNumber : Int,
        apartment : Int,
    ) {

        removeContact(person, Address(city, street, houseNumber, apartment))

    }

    override fun getPersonContacts(person : Person) : MutableList<Contacts>? {
        return contactDetails[person]
    }

    // https://kotlinlang.org/docs/collection-filtering.html#filter-by-predicate
    override fun getPersonPhones(person : Person) : List<Phone> {
        var personPhones : List<Phone> = mutableListOf()
        contactDetails[person]?.filterIsInstance<Phone>()?.forEach {
            personPhones += (it)

        }

        return personPhones

    }

    override fun getPersonEmails(person : Person) : List<Email> {
        var personEmail : List<Email> = mutableListOf()
        contactDetails[person]?.filterIsInstance<Email>()?.forEach {
            personEmail += (it)

        }

        return personEmail
    }

    override fun getPersonLink(person : Person) : List<LinksToASocialNetworkProfile> {
        var personLink : List<LinksToASocialNetworkProfile> = mutableListOf()
        contactDetails[person]?.filterIsInstance<LinksToASocialNetworkProfile>()?.forEach {
            personLink += (it)

        }

        return personLink

    }

    override fun getPersonAddress(person : Person) : List<Address> {
        var personAddress : List<Address> = mutableListOf()
        contactDetails[person]?.filterIsInstance<Address>()?.forEach {
            personAddress += (it)

        }

        return personAddress
    }

    override fun getAllPersons() : List<Person> {
        return buildList {
            this.addAll(contactDetails.keys)
        }
    }

    override fun getAllContacts() : Map<Person, List<Contacts>> {
        return contactDetails
    }

    override fun findPerson(firstName : String, lastName : String) : Boolean {
        contactDetails.keys.forEach {
            if ((firstName == it.firstName) && (lastName == it.lastName)) {
                return true
            }

        }
        return false
    }
}

