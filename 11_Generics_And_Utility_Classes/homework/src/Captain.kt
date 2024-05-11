import kotlin.random.Random

class Captain(override val team: String) : AbstractWarrior(
    chanceAvoidBeingHit = 40,
    accuracy = Random.nextInt(70, 90)
){
    override val position: String = "Капитан"
}