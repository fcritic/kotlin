import kotlin.random.Random

fun main() {

}

fun Int.isChanceRealized() : Boolean {
    return this >= Random.nextInt(1, 100)
}