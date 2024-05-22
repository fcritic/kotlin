class Card {

    fun createCard(): MutableList<Pair<Boolean, String>> {
        val card = mutableListOf<Pair<Boolean, String>>()
        val numberDigitsInRow = 5
        val numberDigitsInTicket = 15
        val rowLength = 9
        val numberOfBarrels = 90
        val numbers = (1..numberOfBarrels).shuffled().take(numberDigitsInTicket)
        var index = 0

        for (i in 1..27 step rowLength) {
            val indexes = (i - rowLength..<i).shuffled().take(numberDigitsInRow)
            for (j in i - rowLength..<i) {
                if (indexes.contains(j)) {
                    card.add(false to numbers[index].toString())
                    index++
                } else {
                    card.add(false to "  ")
                }
            }
        }
        return card
    }

    fun printCard(gameCard: MutableList<Pair<Boolean, String>>, numberBarrels: Int) {
        val blueColor = "\u001B[34m"
        val resetColor = "\u001B[0m"

        for ((index, pair) in gameCard.withIndex()) {
            val numberString = numberBarrels.toString()
            var (booleanValue, stringValue) = pair
            if (stringValue == numberString) booleanValue = true

            val formattedString = when {
                stringValue.length == 1 && stringValue == numberString -> "| ${blueColor}0$stringValue$resetColor "
                stringValue.length == 1 -> "| 0$stringValue "
                stringValue == numberString -> "| ${blueColor}$stringValue$resetColor "
                else -> "| $stringValue "
            }
            print(formattedString)

            if ((index + 1) % 9 == 0) println("|")
        }
    }


}