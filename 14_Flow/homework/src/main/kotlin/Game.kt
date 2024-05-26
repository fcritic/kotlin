import kotlinx.coroutines.*
import kotlinx.coroutines.flow.takeWhile

class Game(
    private val players: List<Player>,
    private val presenter: Presenter
) {
    val scope = CoroutineScope(Job() + Dispatchers.Default)
    private suspend fun markNumberOnGameCard(
        card: MutableList<Pair<Boolean, String>>,
        numberBarrels: Int
    ): MutableList<Pair<Boolean, String>> {
        for ((index, pair) in card.withIndex()) {
            val (_, stringValue) = pair

            delay(1_00)
            if (stringValue == numberBarrels.toString()) {
                card[index] = true to stringValue
            }
        }
        return card
    }

    suspend fun playGame() = runBlocking {
        val numberFlow = presenter.generateNumbersBarrels()

        players.forEach { player ->
            player.gameCards.forEach { gameCard ->
                launch {
                    val name = player.name
                    var card = gameCard
                    var isGameOver = false

                    numberFlow.takeWhile { !isGameOver }.collect { numberBarrel ->

                        println("Бочонок с номером: $numberBarrel")
                        card = markNumberOnGameCard(card, numberBarrel)
                        println("\nКарта игрока: $name")
                        GameCardPrinter().printGameCard(card)

                        if (gameCard.all { it.first }) {
                            println("Игрок $name выйграл!")
                            isGameOver = true
                            cancel()
                        }
                    }
                }
            }
        }
    }

}