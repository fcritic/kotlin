object Weapons {
    private fun createWeapon(maxAmmo: Int, fireType: FireType, name: String): AbstractWeapon {
        return object : AbstractWeapon(maxAmmo, fireType, name) {}
    }

    fun createPistol(): AbstractWeapon {
        return createWeapon(7, FireType.Single, "пистолет")
    }

    fun createSniperRifle() : AbstractWeapon {
        return createWeapon(5, FireType.Single, "снайперская винтовка")
    }

    fun createShotgun() : AbstractWeapon {
        return createWeapon(8, FireType.Single, "дробовик")
    }

    fun createAssaultRifle() : AbstractWeapon {
        return createWeapon(30, FireType.Queue(5), "штурмовая винтовка")
    }
}