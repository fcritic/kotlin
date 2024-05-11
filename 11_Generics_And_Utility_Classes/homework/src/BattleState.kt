sealed class BattleState {
    class Progress(
        val info: String,
        val firstTeam: String,
        val secondTeam: String
    ) : BattleState()

    object FirstTeamWin : BattleState()
    object SecondTeamWin : BattleState()
    object Draw : BattleState()
}