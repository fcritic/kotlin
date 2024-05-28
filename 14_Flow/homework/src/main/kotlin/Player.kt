class Player(
    val name: String,
    private val card: GameCard,
    private val numberPlayingCards: Int = 1
) {
    val gameCards: List<MutableList<Pair<Boolean, String>>> = takeGameCard()

    private fun takeGameCard(): List<MutableList<Pair<Boolean, String>>> {
        val gameCards = mutableListOf<MutableList<Pair<Boolean, String>>>()
        repeat(numberPlayingCards) {
            gameCards += card.createCard()
        }
        return gameCards
    }

    fun markNumberOnGameCard(
        card: MutableList<Pair<Boolean, String>>,
        numberBarrels: Int
    ): MutableList<Pair<Boolean, String>> {
        for ((index, pair) in card.withIndex()) {
            val (_, stringValue) = pair

            if (stringValue == numberBarrels.toString()) {
                card[index] = true to stringValue
            }
        }
        return card
    }
}