import kotlinx.coroutines.runBlocking

class GameCardPrinter {

    fun printGameCard(card: MutableList<Pair<Boolean, String>>) = runBlocking {
        val blueColor = "\u001B[34m"
        val resetColor = "\u001B[0m"

        for ((index, pair) in card.withIndex()) {
            val (booleanValue, stringValue) = pair

            val formattedString = when {
                stringValue.length == 1 && booleanValue -> "| ${blueColor}0$stringValue$resetColor "
                stringValue.length == 1 -> "| 0$stringValue "
                booleanValue -> "| $blueColor$stringValue$resetColor "
                else -> "| $stringValue "
            }
            print(formattedString)

            if ((index + 1) % 9 == 0) println("|")
        }
    }

}