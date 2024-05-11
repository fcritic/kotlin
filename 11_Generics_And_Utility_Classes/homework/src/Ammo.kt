/** Критический урон = коэффициент * урон **/

/** Каждый патрон имеет возможность нанести критический урон.
Этот шанс представлен свойством «Шанс критического урона».
Например, шанс критического урона 25% означает,
что с вероятностью 25% патрон нанесёт урон, равный урон * коэффициент. **/

enum class Ammo(
    private var damage: Int,                        // урон
    private val criticalDamageCoefficient: Int,     // коэффициент критического урона
    private val criticalDamageChance: Int = 25      // шанс критического урона
) {
    PLAIN(10, 50),      // простой патрон
    FIREARM(20, 75),    // огнестрельный патрон
    EXPLOSIVE(25, 75);  // разрывной патрон

    fun getCurrentDamage(): Int {
        var criticalDamage: Int = 0
        if (criticalDamageChance.isChanceRealized()) {
            criticalDamage  += (damage * criticalDamageCoefficient / 100)
            println("Прошел критический урон - ${damage + criticalDamage}")
        }
        return damage + criticalDamage
    }
}