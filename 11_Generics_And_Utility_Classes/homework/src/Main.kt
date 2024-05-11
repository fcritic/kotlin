import kotlin.random.Random

fun main() {
    startBattle()
}

fun startBattle() {
    val battle = Battle()
    var battleState = battle.getBattleState()

    while (battleState is BattleState.Progress) {
        battle.handleBattleState(battleState)
        battle.makeIterationBattle()
        battleState = battle.getBattleState()
    }
    battle.handleBattleState(battleState)
}

fun Int.isChanceRealized(): Boolean {
    return this >= Random.nextInt(1, 100)
}