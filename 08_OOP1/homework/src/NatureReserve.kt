import kotlin.random.Random

class NatureReserve {
    private var territory: MutableList<Any> = mutableListOf()

    fun addNatureReserve(objects: Any) {
        territory.add(objects)
    }

    fun getNatureReserve() {
        println("-------------------------------------------")

        if (territory.isEmpty()) {
            println("Заповедник пуст")
        } else {
            println("Список животных заповедника:")
        }

        territory.forEachIndexed { index, item ->
            when (item) {
                is Animal -> println(
                    "${index + 1}. ${item.name} | Энергия: ${item.energy} | Возраст: ${item.currentAge} | Вес: ${item.weight}"
                )

                else -> println("Ошибка! Объект не найден")
            }
        }
        println("-------------------------------------------")
    }

    fun lifeNatureReserve(iterations: Int) {
        val functionsList = listOf("sleep", "eat", "move", "productionOffspring")
        val newTerritory = territory.toMutableList()

        var currentIndex = 0
        while (currentIndex < newTerritory.size) {
            val item = newTerritory[currentIndex]

            if (item is Animal) {
                var animalDied = false
                for (i in 1..iterations) {
                    if (item.isTooOld()) {
                        newTerritory.remove(item)
                        println("Наступила смерть животного: ${item.name} (${item.typeCreature})")
                        animalDied = true
                        break
                    }

                    val randomIndex = Random.nextInt(0, functionsList.size)
                    val selectedFunction = functionsList[randomIndex]

                    when (selectedFunction) {
                        "sleep" -> item.sleep()
                        "eat" -> item.eat()
                        "move" -> item.move()
                        "productionOffspring" -> {
                            val newAnimal = item.productionOffspring()
                            newTerritory.add(newAnimal)
                        }
                    }
                }
                if (animalDied) {
                    continue
                }
            } else {
                println("Объект не найден")
            }
            currentIndex++
        }
        territory = newTerritory
    }


}