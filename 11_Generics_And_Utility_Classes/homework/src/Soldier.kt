import kotlin.random.Random

class Soldier(override val team: String) : AbstractWarrior(
    chanceAvoidBeingHit = 30,
    accuracy = Random.nextInt(50, 80),
){
    override val position: String = "Солдат"
}