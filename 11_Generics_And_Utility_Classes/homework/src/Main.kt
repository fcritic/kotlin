import kotlin.random.Random

fun main() {
    val expectedEarnings = 500
    val goodMetalPrice = 120
    val badMetalPrice = 50
    val expenses = 300

    val day1Earnings = 6 * goodMetalPrice + 8 * badMetalPrice - expenses
    val day2Earnings = 3 * goodMetalPrice + 2 * badMetalPrice - expenses
    val day3Earnings = 4 * goodMetalPrice + 11 * badMetalPrice - expenses
    val day4Earnings = 7 * goodMetalPrice + 0 * badMetalPrice - expenses
    val day5Earnings = 3 * goodMetalPrice + 7 * badMetalPrice - expenses
    val day6Earnings = 0 * goodMetalPrice + 0 * badMetalPrice - expenses

    val actualEarnings = (day1Earnings + day2Earnings + day3Earnings + day4Earnings + day5Earnings + day6Earnings) / 6f

    println(actualEarnings)
    println(actualEarnings >= expectedEarnings)
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