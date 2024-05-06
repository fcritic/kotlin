import kotlin.random.Random

class General : AbstractWarrior(
    chanceAvoidBeingHit = 90,
    accuracy = Random.nextInt(80, 100)
) {
    override val position: String = "Генерал"
}