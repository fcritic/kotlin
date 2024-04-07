fun main(args: Array<String>)
{
    val text = "F2p)v\"y233{0->c}ttelciFc"

    val firstHalf = text.substring(0, text.length / 2)
    val secondHalf = text.substring(text.length / 2)

    val decryptedString1 = decodeFirstHalf(firstHalf)
    val decryptedString2 = decodeSecondHalf(secondHalf)

    val info: String = """
        
        Входные данные: $text
        Входные данные 1 ч.: $firstHalf
        Входные данные 2 ч.: $secondHalf
        
        Исходные данные: ${decryptedString1 + decryptedString2}
        Исходные данные 1 ч.: $decryptedString1
        Исходные данные 2 ч.: $decryptedString2
        """.trimIndent()

    println(info)
}

fun decodeFirstHalf(text: String): String
{
    var result: String = text
    result = moveRight(result, 1)
    result = result.replace('5', 's')
    result = result.replace('4', 'u')
    result = moveLeft(result, 3)
    result = result.replace('0', 'o')
    return result
}

fun decodeSecondHalf(text: String): String
{
    var result = text
    result = result.reversed()
    result = moveLeft(result, 4)
    result = result.replace("_", " ")
    return result
}

fun moveRight(text: String, amount: Int): String
{
    return text.map { c -> (c + amount).toChar() }.joinToString("")
}

fun moveLeft(text: String, amount: Int): String
{
    return text.map { c -> (c - amount).toChar() }.joinToString("")
}
