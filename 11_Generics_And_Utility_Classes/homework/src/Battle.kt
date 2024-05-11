class Battle {
    private val objectFirstTeam: Team = Team()
    private val objectSecondTeam: Team = Team()

    private val firstTeam: MutableMap<String, MutableList<Warrior>> = objectFirstTeam.teamWarriors
    private val secondTeam: MutableMap<String, MutableList<Warrior>> = objectSecondTeam.teamWarriors
    private var isBattleFinished: Boolean = false

    fun getBattleState(): BattleState {
        val info: String = """
             -----------------------------
             
             -----------------------------
             Битва в процессе
             Информация о битве:
             """.trimIndent()

        val firstTeamWin = firstTeam.values.first().isEmpty()
        val secondTeamWin = secondTeam.values.first().isEmpty()

        return when {
            firstTeamWin && secondTeamWin -> BattleState.Draw
            firstTeamWin -> BattleState.SecondTeamWin
            secondTeamWin -> BattleState.FirstTeamWin
            else -> BattleState.Progress(
                println(info).toString(),
                objectFirstTeam.getTeamWarriors(firstTeam).toString(),
                objectSecondTeam.getTeamWarriors(secondTeam).toString()
            )
        }
    }

    fun makeIterationBattle() {
        val listFirstTeam = firstTeam.values.first()
        val listSecondTeam = secondTeam.values.first()

        if (listFirstTeam.isNotEmpty() && listSecondTeam.isNotEmpty()) {
            listFirstTeam.shuffle()
            listSecondTeam.shuffle()

            val warriorFirstTeam = listFirstTeam.removeFirst()
            val warriorSecondTeam = listSecondTeam.removeFirst()

            if (!isBattleFinished) {
                while (!warriorFirstTeam.isKilled && !warriorSecondTeam.isKilled) {
                    warriorFirstTeam.attack(warriorSecondTeam)
                    warriorSecondTeam.attack(warriorFirstTeam)
                }
                when {
                    !warriorFirstTeam.isKilled -> listFirstTeam.add(warriorFirstTeam)
                    !warriorSecondTeam.isKilled -> listSecondTeam.add(warriorSecondTeam)
                }
            }
        }
    }

    fun handleBattleState(battleState: BattleState) {
        var info: String = ""

        println("-----------------------------")
        when (battleState) {
            is BattleState.Progress -> {}

            is BattleState.FirstTeamWin ->
                info = """
                Битва завершена. 
                Результат: Победила первая команда
             """.trimIndent()

            is BattleState.SecondTeamWin -> info = """
                Битва завершена. 
                Результат: Победила вторая команда
             """.trimIndent()

            is BattleState.Draw -> info = """
                Битва завершена. 
                Результат: Ничья
             """.trimIndent()
        }
        println(info)
    }

}

