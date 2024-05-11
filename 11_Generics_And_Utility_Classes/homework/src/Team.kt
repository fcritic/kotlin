import kotlin.random.Random

class Team {
    val teamWarriors = mutableMapOf<String, MutableList<Warrior>>()
    private val maxWarriorsInTeams = 5

    init {
        callCount++
        createTeam()
    }

    private fun addWarrior(nameTeam: String, listWarriors: MutableList<Warrior>) {
        val sortedList = listWarriors.sortedBy { it.position }
        teamWarriors[nameTeam] = sortedList.toMutableList()
    }

    private fun createTeam() {
        val generalProbability: Int = 10
        val capitalProbability: Int = 40
        val teamList = mutableListOf<Warrior>()
        val nameTeam = "Team-$callCount"

        repeat(maxWarriorsInTeams) {
            when (Random.nextInt(100)) {
                in 0..<generalProbability ->
                    teamList.add(General(nameTeam))
                in generalProbability..<capitalProbability ->
                    teamList.add(Captain(nameTeam))
                else ->
                    teamList.add(Soldier(nameTeam))
            }
        }
        addWarrior(nameTeam, teamList)
    }

    fun getTeamWarriors(teamWarriors: MutableMap<String, MutableList<Warrior>>) {
        println("-----------------------------")
        for ((nameTeam, warriors) in teamWarriors) {
            println("Команда: $nameTeam")
            val warriorCounts = mutableMapOf<String, Int>()

            println("Состав =>")
            for (warrior in warriors) {
                val position = warrior.position
                warriorCounts[position] = (warriorCounts[position] ?: 0) + 1
            }
            for ((position, count) in warriorCounts) {
                println("$position ($count)")
            }
            val totalHealth = getTotalHealthTeam(teamWarriors)
            println("Общие здоровье команды: $totalHealth")
        }
    }

    private fun getTotalHealthTeam(teamWarriors: MutableMap<String, MutableList<Warrior>>): Int {
        val totalHealth = mutableListOf<Int>()
        var totalSumHealth: Int = 0

        teamWarriors.forEach { (_, listWarriors) ->
            for (warrior in listWarriors) {
                val currentHealth: Int = (warrior as AbstractWarrior).currentHealth
                totalHealth.add(currentHealth)
            }
        }
        totalSumHealth = totalHealth.sumOf { it }
        return totalSumHealth
    }

    companion object {
        var callCount = 0
    }

}