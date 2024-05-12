import kotlin.random.Random

abstract class AbstractWarrior(
    override var isKilled: Boolean = false,                 // убит? false = нет / true = да
    override val chanceAvoidBeingHit: Int,                  // шанс избежать попадания
    val accuracy: Int                                       // точность
) : Warrior {
    private var maxHealth: Int = 100                        // макс.здоровье
    var currentHealth: Int = maxHealth                      // текущие здоровье
    private var takeTotalDamage: Int = 0                    // общий полеченный урон
    private val randomWeapon: AbstractWeapon = Weapons.randomWeapon()      // возвращает вид оружия

    // атака
    override fun attack(enemy: Warrior) {
        if (isKilled) return

        val info: String = """
             -----------------------------
             Воин имея звание: $position ($team)
             Здоровье: $currentHealth
             Использует оружие: ${randomWeapon.name}
             """.trimIndent()
        println(info)

//        val exception = runCatching {
        val listAmmo = randomWeapon.shot()
        takeTotalDamage = 0

        listAmmo.forEach { damage ->
            if (!enemy.isKilled) {
                if (isHit(enemy)) {
                    if (!isAvoidHit(enemy)) {
                        enemy.takeDamage(damage)
                        takeTotalDamage += damage
                    } else {
                        println("${enemy.position} увернулся")
                    }
                } else {
                    println("Промах")
                }
            }
        }
        println("Нанесенный общий урон: $takeTotalDamage")
//        }

//        if (exception.isFailure) {
//            randomWeapon.recharge()
//        }
    }

    // получение урона
    override fun takeDamage(damage: Int) {
        if (damage >= currentHealth || currentHealth <= 0) {
            println("$position убит")
            isKilled = true
        } else {
            currentHealth -= damage
        }
    }

    // проверка на попадания
    private fun isHit(warrior: Warrior): Boolean {
        return (warrior as AbstractWarrior).accuracy.isChanceRealized()
    }

    // проверка на уворот
    private fun isAvoidHit(warrior: Warrior): Boolean {
        return warrior.chanceAvoidBeingHit.isChanceRealized()
    }

}