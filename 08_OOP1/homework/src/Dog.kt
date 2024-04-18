class Dog(
    name: String, energy: Int, weight: Int, maxAge: Int
) : Animal(name, energy, weight, maxAge) {
    override val typeCreature = "собака"

    override fun move() {
        checkPossibilityAction(
            "бежит", // действие
            5, // необходимая энергия
            -5, // изменение энергии
            -1 // изменение веса
        )
    }

    override fun createOffspring(): Animal {
        return Dog(name, energy, weight, maxAge)
    }
}