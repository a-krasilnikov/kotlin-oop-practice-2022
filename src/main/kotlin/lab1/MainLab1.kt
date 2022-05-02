package lab1

import lab1.parserAddresses.*


fun main() {

    val listOfAddresses = """
        1. 999999, Москва, ул. Ленина, д. 35
        2. 998998, Киров, ул. Зеленнннная, д. 45
        3. 111111,  Санкт-Петергбург, ул. Конева, д. 55""".trimIndent()

    println(parserAddresses(listOfAddresses))
    println(maxIndexInAddresses(parserAddresses(listOfAddresses)))
    println(minIndexInAddresses(parserAddresses(listOfAddresses)))
    println(maxStreetInAddresses(parserAddresses(listOfAddresses)))
    println(minStreetInAddresses(parserAddresses(listOfAddresses)))

}





