class Wheel {
    private var currentPressure: Double = 0.0

    // накачать колесо
    fun pump(pressure: Double) {
        currentPressure = pressure
    }

    // проверить уровень давления
    fun checkPressureLevel() {
        when {
            currentPressure > MAX_PRESSURE -> println("Колесо взорвалось")
//            currentPressure < MIN_PRESSURE -> throw IncorrectPressure()
            currentPressure > NORMAL_PRESSURE_MAX -> throw TooLowPressure()
            currentPressure < NORMAL_PRESSURE_MIN -> throw IncorrectPressure()
            else -> throw TooHighPressure()
        }
    }

    companion object {
        const val MIN_PRESSURE = 0.0
        const val MAX_PRESSURE = 10.0
        const val NORMAL_PRESSURE_MIN = 1.6
        const val NORMAL_PRESSURE_MAX = 2.5
    }
}