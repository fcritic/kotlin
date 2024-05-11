import kotlin.random.Random

class General(override val team: String) : AbstractWarrior(
    chanceAvoidBeingHit = 50,
    accuracy = Random.nextInt(80, 100)
) {
    override val position: String = "Генерал"
}