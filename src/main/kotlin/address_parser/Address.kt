package address_parser

data class Address(val index: Int, val city: String, val street: String, val building: Int) {
    override fun toString() = "$index, $city, $street, $building"
}

fun parseAddresses(input: String): List<Address> {
    val scan = "\\d+\\. (?<index>\\d{6}), (?<city>[^,\\n]+), ул\\. (?<street>[^,\\n]+), д\\. (?<building>\\d+)".toRegex()
    val list = mutableListOf<Address>()
    for (i in scan.findAll(input)) {
        list.add(
            Address(
                i.groups["index"]!!.value.toInt(),
                i.groups["city"]!!.value,
                i.groups["street"]!!.value,
                i.groups["building"]!!.value.toInt(),
            )
        )
    }
    return list
}