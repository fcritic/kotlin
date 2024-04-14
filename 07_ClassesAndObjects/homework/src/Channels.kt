import kotlin.random.Random

object Channels {
    private val allChannels = listOf<String>(
        "Первый канал",
        "СТС",
        "ТНТ",
        "Канал",
        "Культура",
        "Интересный",
        "Кот",
        "НТВ",
    )

    fun getRandomChannels(): List<String> {
        // Определяем макс. и мин. кол-во каналов
        val maxCount = allChannels.size
        val minCount = maxCount / 2

        /** Рандомно заполняем кол-во каналов на тв,
         * где мин. кол-во это 50% от общего кол-во каналов **/
        val countChannels = Random.nextInt(minCount, maxCount)

        // Создаем массив с интерфейсом Set, чтобы избежать дубли
        val chosenIndices = mutableSetOf<Int>()

        // Заполняем массив до тех пор, пока он меньше нашему рандому
        while (chosenIndices.size < countChannels) {
            val index = Random.nextInt(0, maxCount)
            // Проверка на уникальность индекса
            if (index !in chosenIndices) {
                chosenIndices.add(index)
            }
        }
        // Сортировка по индекс
        val sortedChosenIndices = chosenIndices.toSortedSet()

        // Заполняем названием каналов на основе их индексов
        val listChannels = sortedChosenIndices.map { allChannels[it] }.toList()
        return listChannels
    }
}