package lab1.parserAddresses

import kotlin.String


data class AddressesBlocks(val index : Int, val town : String, val street : String, val house : Int)

fun parserAddresses(listOfAddresses : String) : List<AddressesBlocks> {
    val splittingString = listOfAddresses.split("\n")//list of separated strings
    val newAddressesBlocks = mutableListOf<AddressesBlocks>()
    for (tmpStr in splittingString) {
        val partsOfTheString = tmpStr.split(",")//divide the split string into substrings by the comma character

        val index = partsOfTheString[0].substringAfter(' ').substringBefore(',')

        val town = partsOfTheString[1].substringAfter(' ')

        val street = partsOfTheString[2].substringAfter('.').substringAfter(' ')

        val house = partsOfTheString[3].substringAfter('.').substringAfter(' ')

        val addressBlocks = AddressesBlocks(index.toInt(), town, street, house.toInt())
        newAddressesBlocks.add(addressBlocks)
    }
    return newAddressesBlocks
}

fun maxIndexInAddresses(newAddressesBlocks : List<AddressesBlocks>) : AddressesBlocks? {
    return newAddressesBlocks.maxByOrNull { it.index }
}

fun minIndexInAddresses(newAddressesBlocks : List<AddressesBlocks>) : AddressesBlocks? {
    return newAddressesBlocks.minByOrNull { it.index }
}

fun minStreetInAddresses(newAddressesBlocks : List<AddressesBlocks>) : AddressesBlocks? {
    return newAddressesBlocks.minByOrNull { it.street.length }
}

fun maxStreetInAddresses(newAddressesBlocks : List<AddressesBlocks>) : AddressesBlocks? {
    return newAddressesBlocks.maxByOrNull { it.street.length }
}