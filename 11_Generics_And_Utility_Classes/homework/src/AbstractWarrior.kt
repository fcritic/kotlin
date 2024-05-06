import kotlin.random.Random

abstract class AbstractWarrior(
    override var isKilled: Boolean = false,                 // убит?
    override val chanceAvoidBeingHit: Int,                  // шанс избежать попадания
    val accuracy: Int                                       // точность
) : Warrior {
    private var maxHealth: Int = 100                        // макс.здоровье
    var currentHealth: Int = maxHealth                      // текущие здоровье
    var takeTotalDamage: Int = 0                            // общий полеченный урон

    private val randomWeapon: AbstractWeapon by lazy {      // возвращает вид оружия
        val weapons = listOf(
            Weapons.createPistol(),
            Weapons.createShotgun(),
            Weapons.createSniperRifle(),
            Weapons.createAssaultRifle()
        )
        weapons[Random.nextInt(weapons.size)]
    }

    // атака
    override fun attack(warrior: Warrior) {
        println("Персонаж имея звание: ${warrior.position}")
        println("Использовал оружие: ${randomWeapon.name}")
        val listDamage = randomWeapon.shot()


        listDamage.forEach { damage ->
            if (isHit(warrior)) {
                if (!isAvoidHit(warrior)) {

                    if (listDamage.sumOf { it } > currentHealth) {
                        println("Воин убит")
                        warrior.takeDamage(currentHealth)
                        warrior.isKilled = true
                        return
                    } else {
                        warrior.takeDamage(damage)
                    }

                    takeTotalDamage += damage

                } else {
                    println("Воин увернулся")
                }
            } else {
                println("Промах")
            }
        }
        println("Полученный общий урон: $takeTotalDamage")
    }

    // получение урона
    override fun takeDamage(damage: Int) {
        currentHealth -= damage
        if (currentHealth < 0) {
            println("Воин убит")
        }
    }

    // проверка на попадания
    private fun isHit(warrior: Warrior): Boolean {
        return accuracy.isChanceRealized()
    }

    // проверка на уворот
    private fun isAvoidHit(warrior: Warrior): Boolean {
        return warrior.chanceAvoidBeingHit.isChanceRealized()
    }

}