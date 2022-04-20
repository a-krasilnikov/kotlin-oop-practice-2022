package lab3


sealed class Contacts {}
data class Phone(val phoneType : PhoneType, val phone : String) : Contacts()
data class Email(val email : String) : Contacts()
data class Address(val city : String, val street : String, val houseNumber : Int, val apartment : Int) : Contacts()

data class LinksToASocialNetworkProfile(val nameNetwork : NameNetwork, val networkProfileURL : String) : Contacts()

enum class PhoneType {
    HOME, MOBILE, WORK
}

enum class NameNetwork {
    VK, TG, INST
}

data class Person(val firstName : String, val lastName : String)
