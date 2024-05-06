import kotlin.random.Random

class Soldier : AbstractWarrior(
    chanceAvoidBeingHit = 50,
    accuracy = Random.nextInt(50, 80)
){
    override val position: String = "Солдат"
}