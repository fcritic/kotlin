import kotlinx.coroutines.*

class Game(
    private val players: List<Player>,
    private val presenter: Presenter
) {
    suspend fun playGame() = runBlocking {
        val numberFlow = presenter.generateNumbersBarrels()

        players.forEachIndexed { index, player ->
            player.gameCards.forEach { gameCard ->
                val name = player.name
                var card = gameCard

                launch {
                    while (currentCoroutineContext().isActive) {
                        numberFlow.collect { numberBarrel ->
                            handleNumberBarrel(numberBarrel, index)
                            card = player.markNumberOnGameCard(card, numberBarrel)
                            printGameCard(card, name)

                            if (checkGameEnd()) cancel()
                            if (checkPlayerWin(card)) announcePlayerWin(name)
                        }
                    }
                }
            }
        }
    }

    private fun handleNumberBarrel(numberBarrel: Int, playerIndex: Int) {
        if (playerIndex == players.lastIndex) {
            println("\n-----------------------------------------")
            println("Бочонок с номером: $numberBarrel")
            println("-----------------------------------------")
        }
    }

    private suspend fun printGameCard(card: MutableList<Pair<Boolean, String>>, playerName: String) {
        GameCardPrinter().printGameCard(card, playerName)
    }

    private fun checkGameEnd(): Boolean {
        return players.any { player ->
            player.gameCards.any { card ->
                card.all { number -> number.first }
            }
        }
    }

    private fun checkPlayerWin(card: MutableList<Pair<Boolean, String>>): Boolean {
        return card.all { it.first }
    }

    private fun announcePlayerWin(name: String) {
        println("\n-----------------------------------------")
        println("Победил игрок: $name")
        println("-----------------------------------------")
    }

}