import kotlin.random.Random

class Captain : AbstractWarrior(
    chanceAvoidBeingHit = 70,
    accuracy = Random.nextInt(70, 90)
){
    override val position: String = "Капитан"
}