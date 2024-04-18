import kotlin.random.Random

fun main() {
    val natureReserve = NatureReserve()

    startFillingNatureReserve(natureReserve)
    natureReserve.getNatureReserve()
    natureReserve.lifeNatureReserve(1)
    natureReserve.getNatureReserve()
}

fun startFillingNatureReserve(natureReserve: NatureReserve) {

    for (i in 1..5) {
        val energy = Random.nextInt(5, 10)
        val weight = Random.nextInt(5, 10)
        val maxAge = Random.nextInt(5, 7)
        val bird = Bird("Хедвиг", energy, weight, maxAge)
        natureReserve.addNatureReserve(bird)
    }

    for (i in 1..3) {
        val energy = Random.nextInt(5, 10)
        val weight = Random.nextInt(1, 3)
        val maxAge = Random.nextInt(1, 3)

        val fish = Fish("Немо", energy, weight, maxAge)
        natureReserve.addNatureReserve(fish)
    }

    for (i in 1..2) {
        val energy = Random.nextInt(5, 10)
        val weight = Random.nextInt(5, 10)
        val maxAge = Random.nextInt(3, 4)

        val dog = Dog("Рекс", energy, weight, maxAge)
        natureReserve.addNatureReserve(dog)
    }


    for (i in 1..3) {
        val energy = Random.nextInt(1, 10)
        val weight = Random.nextInt(1, 5)
        val maxAge = Random.nextInt(1, 7)

        val animal = Animal("без имени", energy, weight, maxAge)
        natureReserve.addNatureReserve(animal)
    }

}
