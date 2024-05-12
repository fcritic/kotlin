import kotlin.random.Random

abstract class AbstractWeapon(
    private val maxAmmo: Int,                                 // макс. кол-во патронов в магазине.
    private val fireType: FireType,                           // вид стрельбы
    val name: String
) {
    private val magazine = Stack<Ammo>()                      // магазин

    // создание патронов
    private fun createAmmo(): Ammo {
        val ammoTypes = Ammo.entries
        val index = Random.nextInt(0, ammoTypes.size)

        return ammoTypes[index]
    }

    // перезарядка
    fun recharge() {
        val ammo = createAmmo()
        repeat(maxAmmo) {
            magazine.push(ammo)
        }
        println("Перезарядка")
    }

    // выстрел
    fun shot(): List<Int> {
        val listAmmo: MutableList<Int> = mutableListOf()

        if (magazine.isEmpty()) {
            throw NoAmmoException()
//            println("Патроны закончились, требуется перезарядка")
//            recharge()
//            return listAmmo
        }

        when (fireType) {
            is FireType.Single -> {
                val ammo = magazine.pop()
                listAmmo.add(ammo?.getCurrentDamage() ?: 0)
            }
            is FireType.Queue -> {
                val queueSize = fireType.sizeQueue
                if (magazine.size() >= queueSize) {
                    repeat(queueSize) {
                        val ammo = magazine.pop()
                        listAmmo.add(ammo?.getCurrentDamage() ?: 0)
                    }
                } else recharge()
            }
        }
        val totalDamage = listAmmo.sumOf { it }
        println("Патрон ${createAmmo()}")
        println("Общий урон составил: $totalDamage")
        return listAmmo
    }

}