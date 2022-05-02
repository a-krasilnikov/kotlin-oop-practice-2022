package lab1.parserAddresses

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ParsingAddressesKtTest {

    @Test
    fun parserAddresses() {


        val listOfAddresses = """
        1. 999999, Москва, ул. Ленина, д. 35
        2. 998998, Киров, ул. Зеленая, д. 45
        3. 111111, Санкт-Петергбург, ул. Конева, д. 55""".trimIndent()

        val sourceList : List<AddressesBlocks> = parserAddresses(listOfAddresses)

        val correctListOfItems : List<AddressesBlocks> = listOf(
            AddressesBlocks(999999, "Москва", "Ленина", 35),
            AddressesBlocks(998998, "Киров", "Зеленая", 45),
            AddressesBlocks(111111, "Санкт-Петергбург", "Конева", 55)
        )

        val notCorrectListOfItems : List<AddressesBlocks> = listOf(
            AddressesBlocks(91119, "Москва", "Ленина", 35),
            AddressesBlocks(995698, "Киров", "Зеленая", 45),
            AddressesBlocks(115511, "Санкт-Петергбург", "Конева", 389)
        )

        assertNotNull(sourceList)
        assertNotEquals(sourceList, notCorrectListOfItems)
        assertEquals(sourceList, correctListOfItems)






    }

    @Test
    fun maxIndexInAddresses(){
        val listOfAddresses = """
        1. 999999, Москва, ул. Ленина, д. 35
        2. 998998, Киров, ул. Зеленая, д. 45
        3. 111111, Санкт-Петергбург, ул. Конева, д. 55""".trimIndent()


        val addressesWithMaxIndex=AddressesBlocks(999999, "Москва", "Ленина", 35)
        assertEquals(addressesWithMaxIndex, maxIndexInAddresses(parserAddresses(listOfAddresses)))

    }
    @Test
    fun minIndexInAddresses(){
        val listOfAddresses = """
        1. 999999, Москва, ул. Ленина, д. 35
        2. 998998, Киров, ул. Зеленая, д. 45
        3. 111111, Санкт-Петергбург, ул. Конева, д. 55""".trimIndent()


        val addressesWithMinIndex=AddressesBlocks(111111, "Санкт-Петергбург", "Конева", 55)
        assertEquals(addressesWithMinIndex, minIndexInAddresses(parserAddresses(listOfAddresses)))

    }

    @Test
    fun maxStreetInAddresses(){
        val listOfAddresses = """
        1. 999999, Москва, ул. Рима, д. 35
        2. 998998, Киров, ул. Зеленая, д. 45
        3. 111111, Санкт-Петергбург, ул. Конева, д. 55""".trimIndent()


        val addressesWithMaxStreet=AddressesBlocks(998998, "Киров", "Зеленая", 45)
        assertEquals(addressesWithMaxStreet, maxStreetInAddresses(parserAddresses(listOfAddresses)))

    }

    @Test
    fun minStreetInAddresses(){
        val listOfAddresses = """
        1. 999999, Москва, ул. Ленина, д. 35
        2. 998998, Киров, ул. Зеленая, д. 45
        3. 111111, Санкт-Петергбург, ул. Кот, д. 55""".trimIndent()


        val addressesWithMinStreet=AddressesBlocks(111111, "Санкт-Петергбург", "Кот", 55)
        assertEquals(addressesWithMinStreet, minStreetInAddresses(parserAddresses(listOfAddresses)))

    }



}