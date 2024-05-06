import kotlin.random.Random

fun main() {
    val warrior1 = Captain()
    val warrior2 = Captain()

    println("-----------------------------------")
    println("Воин №1 атакует ПЕРВЫЙ РАЗ")
    warrior1.attack(warrior2)
    println("-----------------------------------")

    println("Воин №1 атакует ВТОРОЙ РАЗ")
    warrior1.attack(warrior2)
    println("-----------------------------------")

    println("Здоровье война №1 - ${warrior1.currentHealth}")
    println("Здоровье война №2 - ${warrior2.currentHealth}")
}


fun Int.isChanceRealized(): Boolean {
    return this >= Random.nextInt(1, 100)
}