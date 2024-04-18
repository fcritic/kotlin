import kotlin.random.Random

open class Animal(
    var name: String,
    var energy: Int,
    var weight: Int,
    val maxAge: Int,
) {

    var currentAge: Int = Random.nextInt(0, maxAge)
    open val typeCreature: String = "животное"

    fun isTooOld(): Boolean {
        return currentAge >= maxAge
    }

    protected fun checkPossibilityAction(
        action: String,
        energyNeeded: Int,
        energyChange: Int,
        weightChange: Int,
        weightNeeded: Int = 1,
    ) {
        if (energy >= energyNeeded && weight > weightNeeded && !isTooOld()) {
            energy += energyChange
            weight += weightChange
            if (action == "спит") currentAge += 1

            tryIncrementAge()
            println("$name $action.")
        } else {
            if (energy < energyNeeded) {
                println("Недостаточно энергии для совершения действия")

            } else {
                if (weight < weightNeeded) {
                    println("Недостаточно веса для совершения действия")
                }
            }
        }
    }

    open fun sleep() {
        checkPossibilityAction(
            "спит", // действие
            0, // необходимая энергия
            5, // изменение энергии
            0 // изменение веса
        )
    }

    open fun eat() {
        checkPossibilityAction(
            "ест", // действие
            0, // необходимая энергия
            3, // изменение энергии
            1 // изменение веса
        )
    }

    open fun move() {
        checkPossibilityAction(
            "передвигается", // действие
            5, // необходимая энергия
            -5, // изменение энергии
            -1 // изменение веса
        )
    }

    open fun productionOffspring(): Animal {
        energy = Random.nextInt(1, 10)
        weight = Random.nextInt(1, 5)
        currentAge = 0

        println("--------------")
        println("Рожден(а)(о) $typeCreature $name")
        println("Характеристики:")
        println("Энергия: $energy")
        println("Возраст: $currentAge")
        println("Вес: $weight")
        println("--------------")

        return createOffspring()
    }

    protected open fun createOffspring(): Animal {
        return Animal(name, energy, weight, maxAge)
    }

    private fun tryIncrementAge() {
        if (Random.nextBoolean()) {
            currentAge += 1
            println("$name постарел(а) на 1 ед.")
        }
    }

}