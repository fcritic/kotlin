import kotlin.random.Random

abstract class AbstractWeapon(
    val maxAmmo: Int,            // макс. кол-во патронов в магазине.
    val fireType: FireType,      // вид стрельбы
) {
    private val magazine = Stack<Ammo>()                      // магазин
    private var hasAmmo: Boolean = magazine.isEmpty()         // проверка магазина на наличие патрон

    // т.к. по дефолту оружие разряжено, то мы перезаряжаем его
    init {
        recharge()
    }

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
//        hasAmmo = true
    }

    // выстрел
    fun shot() {
        if (hasAmmo) {
            when (fireType) {
                FireType.Single -> {
                    magazine.pop()
                }
                is FireType.Queue -> {
                    val queueSize = fireType.sizeQueue
                    repeat(queueSize) {
                        magazine.pop()
                    }
                }
            }
        } else {
            recharge()
        }
    }

}