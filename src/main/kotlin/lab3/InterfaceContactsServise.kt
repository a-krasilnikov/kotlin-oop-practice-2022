package lab3

interface ContactsServiceView {
    fun addContact(Person : Person, newContact : Contacts)
    fun removeContact(person : Person, contact : Contacts)
    fun removePerson(person : Person)
    fun addPhone(person : Person, phone : String, phoneType : PhoneType)
    fun addEmail(person : Person, email : String)
    fun addLink(person : Person, nameNetwork : NameNetwork, link : String)
    fun addAddress(person : Person, city : String, street : String, houseNumber : Int, apartment : Int)
    fun removePhone(person : Person, phone : String, phoneType : PhoneType)
    fun removeEmail(person : Person, email : String)
    fun removeLink(person : Person, link : String, nameNetwork : NameNetwork)
    fun removeAddress(person : Person, city : String, street : String, houseNumber : Int, apartment : Int)
    fun getPersonPhones(person : Person) : List<Phone>
    fun getPersonEmails(person : Person) : List<Email>
    fun getPersonLink(person : Person) : List<LinksToASocialNetworkProfile>
    fun getPersonAddress(person : Person) : List<Address>
    fun getAllPersons() : List<Person>
    fun findPerson(firstName : String, lastName : String) : Boolean
    fun getPersonContacts(person : Person) : MutableList<Contacts>?
    fun getAllContacts() : Map<Person, List<Contacts>>
}