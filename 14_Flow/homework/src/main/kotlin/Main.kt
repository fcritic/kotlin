import kotlin.random.Random

fun main() {
    val card = Card()
    val gameCard = card.createCard()
    val blueColor = "\u001B[34m"
    val resetColor = "\u001B[0m"

//    val elementToRemove = "  "
//    gameCard.removeAll { it == elementToRemove }

    for (pair in gameCard) {
        var (booleanValue, stringValue) = pair
        print("${stringValue}_")
    }

    println()
    println()
    card.printCard(gameCard, 10)

}