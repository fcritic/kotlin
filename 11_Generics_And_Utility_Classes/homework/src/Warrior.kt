interface Warrior {
    var isKilled: Boolean            // убит
    val chanceAvoidBeingHit: Int     // шанс избежать попадания
    val position: String             // звание
    val team: String

    fun attack(enemy: Warrior)       // атаковать
    fun takeDamage(damage: Int)      // получить урон
}