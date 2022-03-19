package lab1.parserAddresses

import kotlin.String


data class addressBlocks(val index : Int, val town : String, val street : String, val house : Int)

fun parserAddresses(listOfAddresses : String) : List<addressBlocks> {


    val SplittingString = listOfAddresses.split("\n")//list of separated strings
    val newAddressesBlocks = mutableListOf<addressBlocks>()
    for (tmpStr in SplittingString) {
        val partsOfTheString = tmpStr.split(",")//divide the split string into substrings by the comma character
        println(partsOfTheString)
        val index = partsOfTheString[0].substringAfter(' ').substringBefore(',')
        println(index)
        val town = partsOfTheString[1].substringAfter(' ')
        println(town)
        val street = partsOfTheString[2].substringAfter('.').substringAfter(' ')
        println(street)
        val house = partsOfTheString[3].substringAfter('.').substringAfter(' ')
        println(house)
        minStreet(street)
        maxStreet(street)
        minIndex(index)
        maxIndex(index)

        val addressBlocks = addressBlocks(index.toInt(), town, street, house.toInt())
        newAddressesBlocks.add(addressBlocks)

    }


    return newAddressesBlocks

}


var maxInd = 0
var minInd = Int.MAX_VALUE
var minStreet = 20
var maxStreet = 0

fun maxIndex(index : String) : Int {


    if (index.toInt() > maxInd) {
        maxInd = index.toInt()

    }
    println("maxInd-$maxInd")
    return maxInd
}

fun minIndex(index : String) : Int {

    if (index.toInt() < minInd) {
        minInd = index.toInt()

    }
    println(" minInd-$minInd")
    return minInd
}

fun minStreet(street : String) : Int {


    if (street.length < minStreet) {
        minStreet = street.length

    }
    println("minStreet-$minStreet")
    return minStreet
}

fun maxStreet(street : String) : Int {

    if (street.length > maxStreet) {
        maxStreet = street.length
    }
    println("maxStreet-$maxStreet")
    return maxStreet
}



