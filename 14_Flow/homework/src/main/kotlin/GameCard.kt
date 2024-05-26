class GameCard {

    fun createCard(): MutableList<Pair<Boolean, String>> {
        /* Игровая карта представлена в виде изменяемой коллекции
        которая хранит в себе пары в виде флага для выделения числа
        и число в строковом значении для того, чтобы к цифре подставить 0 */
        val card = mutableListOf<Pair<Boolean, String>>()
        /* Коллекция содержащая значения 1-90 в перемешанном состояние.
        Получаем первые 15 значений для игровой карты */
        val numbers = (1..NUMBER_OF_BARRELS).shuffled().take(NUMBER_DIGITS_IN_TICKET)
        var index = 0

        for (i in 1..27 step ROW_LENGTH) {
            val indexes = (i - ROW_LENGTH..<i).shuffled().take(NUMBER_DIGITS_IN_ROW)
            for (j in i - ROW_LENGTH..<i) {
                if (indexes.contains(j)) {
                    card.add(false to numbers[index].toString())
                    index++
                } else {
                    card.add(true to "  ")
                }
            }
        }
        return card
    }

    private companion object {
        const val NUMBER_DIGITS_IN_ROW = 5
        const val NUMBER_DIGITS_IN_TICKET = 15
        const val ROW_LENGTH = 9
        const val NUMBER_OF_BARRELS = 90
    }

}