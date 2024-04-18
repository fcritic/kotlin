open class Bird(
    name: String, energy: Int, weight: Int, maxAge: Int
) : Animal(name, energy, weight, maxAge) {
    override val typeCreature = "птица"

    override fun move() {
        checkPossibilityAction(
            "летит", // действие
            5, // необходимая энергия
            -5, // изменение энергии
            -1 // изменение веса
        )
    }

    override fun createOffspring(): Animal {
        return Bird(name, energy, weight, maxAge)
    }
}