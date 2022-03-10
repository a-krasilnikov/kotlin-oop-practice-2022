import address_parser.parseAddresses
import java.io.File

fun main(args: Array<String>) {
    val example: String
    if (args.isNotEmpty()) {
        try {
            example = File(args[0]).readText()
        } catch (e: Exception) {
            println("Cannot read from file ${args[0]}!")
            return
        }
    } else {
        example = """
            1. 123456, СПб, ул. Невский проспект, д. 45
            2. 743233, Москва, ул. Самая московская, д. 1
            3. 228228, Екатеринбург, ул. Акашная, д. 47
            4. 346723, New York, ул. Какие там улицы есть?, д. 32
            5. 983200, Асмщиков, ул. Микрооптимизаций, д. 2
        """.trimIndent()
    }
    val addresses = parseAddresses(example)
    for (a in addresses) println(a)
    var minInd = addresses[0]
    var maxInd = addresses[0]
    var shortestStreet = addresses[0]
    var longestStreet = addresses[0]
    for (i in 1..addresses.lastIndex) {
        val tmp = addresses[i]
        if (tmp.index < minInd.index) {
            minInd = tmp
        } else if (tmp.index > maxInd.index) {
            maxInd = tmp
        }
        if (tmp.street.length < shortestStreet.street.length) {
            shortestStreet = tmp
        } else if (tmp.street.length > longestStreet.street.length) {
            longestStreet = tmp
        }
    }
    println("Address with minimal index: $minInd")
    println("Address with maximal index: $maxInd")
    println("Address with shortest street name: $shortestStreet")
    println("Address with longest street name: $longestStreet")
}