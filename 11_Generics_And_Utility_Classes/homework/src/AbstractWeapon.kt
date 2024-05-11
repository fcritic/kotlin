import kotlin.random.Random

abstract class AbstractWeapon(
    private val maxAmmo: Int,                                 // макс. кол-во патронов в магазине.
    private val fireType: FireType,                           // вид стрельбы
    val name: String
) {
    private val magazine = Stack<Ammo>()                      // магазин
    private var hasAmmo: Boolean = magazine.isEmpty()         // проверка магазина на наличие патрон

    // создание патронов
    private fun createAmmo(): Ammo {
        val ammoTypes = Ammo.entries
        val index = Random.nextInt(0, ammoTypes.size)

        return ammoTypes[index]
    }

    // перезарядка
    private fun recharge() {
        val ammo = createAmmo()
        repeat(maxAmmo) {
            magazine.push(ammo)
        }
        hasAmmo = magazine.isEmpty()
        println("Перезарядка")
    }

    // выстрел
    fun shot(): MutableList<Int> {
        val listDamage: MutableList<Int> = mutableListOf()
        hasAmmo = magazine.isEmpty()

        if (hasAmmo) {
            println("Патроны закончились, требуется перезарядка")
            recharge()
            return listDamage
        }

        when (fireType) {
            is FireType.Single -> {
                val ammo = magazine.pop()
                listDamage.add(ammo?.getCurrentDamage() ?: 0)
            }
            is FireType.Queue -> {
                val queueSize = fireType.sizeQueue
                repeat(queueSize) {
                    val ammo = magazine.pop()
                    listDamage.add(ammo?.getCurrentDamage() ?: 0)
                }
            }
        }
        val totalDamage = listDamage.sumOf { it }
        println("Патрон ${createAmmo()}")
        println("Общий урон составил: $totalDamage")
        return listDamage
    }

}