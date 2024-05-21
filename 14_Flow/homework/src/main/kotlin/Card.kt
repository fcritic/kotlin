class Card {

    fun createCard(): List<String> {
        val card = mutableListOf<String>()
        val numbers = (1..90).shuffled().take(15)
        var index = 0

        for (i in 1..27) {
            if (i % 9 == 0) {
                val indexes = (i - 9..<i).shuffled().take(5)
                for (j in i - 9..<i) {
                    if (indexes.contains(j)) {
                        card.add(numbers[index].toString())
                        index++
                    } else {
                        card.add("_")
                    }
                }
            }
        }
        return card
    }


}