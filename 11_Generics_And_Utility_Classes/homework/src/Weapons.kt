import kotlin.random.Random

object Weapons {
    fun randomWeapon(): AbstractWeapon {
        val weapons = listOf(
            createPistol(),
            createShotgun(),
            createSniperRifle(),
            createAssaultRifle()
        )
        return weapons[Random.nextInt(weapons.size)]
    }

    private fun createWeapon(maxAmmo: Int, fireType: FireType, name: String): AbstractWeapon {
        return object : AbstractWeapon(maxAmmo, fireType, name) {}
    }

    private fun createPistol(): AbstractWeapon {
        return createWeapon(7, FireType.Single, "пистолет")
    }

    private fun createSniperRifle(): AbstractWeapon {
        return createWeapon(5, FireType.Single, "снайперская винтовка")
    }

    private fun createShotgun(): AbstractWeapon {
        return createWeapon(8, FireType.Single, "дробовик")
    }

    private fun createAssaultRifle(): AbstractWeapon {
        return createWeapon(31, FireType.Queue(5), "штурмовая винтовка")
    }
}