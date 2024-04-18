class Fish(
    name: String, energy: Int, weight: Int, maxAge: Int
) : Animal(name, energy, weight, maxAge) {
    override val typeCreature = "рыба"

    override fun move() {
        checkPossibilityAction(
            "плывет", // действие
            5, // необходимая энергия
            -5, // изменение энергии
            -1 // изменение веса
        )
    }

    override fun createOffspring(): Animal {
        return Fish(name, energy, weight, maxAge)
    }
}