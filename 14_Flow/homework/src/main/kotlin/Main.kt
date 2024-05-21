fun main() {
    val card = Card()
    val gameCard: List<String> = card.createCard()

    for (i in 0..gameCard.lastIndex) {
        if (i % 9 == 0) {
            println()
        }
        print("${gameCard[i]} ")
    }

}