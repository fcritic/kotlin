/** Критический урон = коэффициент * урон **/

/** Каждый патрон имеет возможность нанести критический урон.
Этот шанс представлен свойством «Шанс критического урона».
Например, шанс критического урона 25% означает,
что с вероятностью 25% патрон нанесёт урон, равный урон * коэффициент. **/

enum class Ammo(
    var damage: Int,                    // урон
    val criticalDamageCoefficient: Int, // коэффициент критического урона
    val criticalDamageChance: Int = 25  // шанс критического урона
) {
    PLAIN(10, 50),      // простой патрон
    FIREARM(20, 75),    // огнестрельный патрон
    EXPLOSIVE(25, 75);  // разрывной патрон

    fun getCurrentDamage() {
        if (criticalDamageChance.isChanceRealized()) {
            damage += (damage * criticalDamageCoefficient / 100)
            println("Прошел критический урон - $damage")
        } else {
            println("Прошел урон - $damage")
        }
    }
}