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

        val sourceList : List<addressBlocks> = parserAddresses(listOfAddresses)

        val correctListOfItems : List<addressBlocks> = listOf(
            addressBlocks(999999, "Москва", "Ленина", 35),
            addressBlocks(998998, "Киров", "Зеленая", 45),
            addressBlocks(111111, "Санкт-Петергбург", "Конева", 55)
        )

        val notCorrectListOfItems : List<addressBlocks> = listOf(
            addressBlocks(91119, "Москва", "Ленина", 35),
            addressBlocks(995698, "Киров", "Зеленая", 45),
            addressBlocks(115511, "Санкт-Петергбург", "Конева", 389)
        )

        assertNotNull(sourceList)
        assertNotEquals(sourceList, notCorrectListOfItems)
        assertEquals(sourceList, correctListOfItems)



        @Test
        fun maxMinIndex() {

            val listOfAddresses = """
        1. 999999, Москва, ул. Ленина, д. 35
        2. 998998, Киров, ул. Зеленая, д. 45
        3. 111111, Санкт-Петергбург, ул. Конева, д. 55""".trimIndent()

            val sourceList : List<addressBlocks> = parserAddresses(listOfAddresses)

            assertNotEquals(maxInd, 999899)
            assertEquals(maxInd, 999999)
            assertEquals(minInd, 111111)
            assertNotEquals(minInd, 999899)

        }

        fun maxMinStreet() {

            val listOfAddresses = """
        1. 999999, Москва, ул. Ленина, д. 35
        2. 998998, Киров, ул. Зеленая, д. 45
        3. 111111, Санкт-Петергбург, ул. Конева, д. 55""".trimIndent()

            val sourceList : List<addressBlocks> = parserAddresses(listOfAddresses)

            assertNotEquals(minStreet, 999899)
            assertEquals(minStreet, 6)
            assertEquals(maxStreet, 7)
            assertNotEquals(maxStreet, 999899)

        }


    }


    @Test
    fun maxMinIndex() {


        val listOfAddresses = """
        1. 999999, Москва, ул. Ленина, д. 35
        2. 998998, Киров, ул. Зеленая, д. 45
        3. 111111, Санкт-Петергбург, ул. Конева, д. 55""".trimIndent()

        val sourceList : List<addressBlocks> = parserAddresses(listOfAddresses)

        assertNotEquals(maxInd, 999899)
        assertEquals(maxInd, 999999)
        assertEquals(minInd, 111111)
        assertNotEquals(minInd, 999899)

    }


    @Test
    fun minMaxStreet() {

        val listOfAddresses = """
        1. 999999, Москва, ул. Ленина, д. 35
        2. 998998, Киров, ул. Зеленая, д. 45
        3. 111111, Санкт-Петергбург, ул. Конева, д. 55""".trimIndent()

        val sourceList : List<addressBlocks> = parserAddresses(listOfAddresses)

        assertNotEquals(minStreet, 999899)
        assertEquals(minStreet, 6)
        assertEquals(maxStreet, 7)
        assertNotEquals(maxStreet, 999899)
    }


}