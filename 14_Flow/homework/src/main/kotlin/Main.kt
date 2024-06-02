import kotlin.random.Random

suspend fun main() {
    val player1 = Player("Alex", GameCard())
    val player2 = Player("Petr", GameCard())
    val player3 = Player("Ana", GameCard())

    val players: List<Player> = listOf(player1, player2, player3)
    val presenter = Presenter()

    Game(players, presenter).playGame()
}