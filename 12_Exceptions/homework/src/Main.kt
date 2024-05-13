fun main() {
    val wheel = Wheel()
    val listPressure: List<Double> = listOf(-5.0, 1.0, 1.7, 3.6, 11.0)

    for (pressure in listPressure) {
        try {
            wheel.pump(pressure)
            wheel.checkPressureLevel()
        } catch (e: PressureException) {
            println("При накачке $pressure атмосфер ${e.message}")
        }
    }
}