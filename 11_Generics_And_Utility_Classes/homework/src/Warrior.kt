interface Warrior {
    var isKilled: Boolean            // убит
    val chanceAvoidBeingHit: Int     // шанс избежать попадания
    val position: String             // звание

    fun attack(warrior: Warrior)     // атаковать
    fun takeDamage(damage: Int)      // получить урон
}