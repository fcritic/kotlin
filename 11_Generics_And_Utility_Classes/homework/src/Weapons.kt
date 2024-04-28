object Weapons {
    private fun createWeapon(maxAmmo: Int, fireType: FireType): AbstractWeapon {
        return object : AbstractWeapon(maxAmmo, fireType) {}
    }

    fun createPistol(): AbstractWeapon {
        return createWeapon(7, FireType.Single)
    }

    fun createSniperRifle() : AbstractWeapon {
        return createWeapon(5, FireType.Single)
    }

    fun createShotgun() : AbstractWeapon {
        return createWeapon(8, FireType.Single)
    }

    fun createAssaultRifle() : AbstractWeapon {
        return createWeapon(30, FireType.Queue(5))
    }
}