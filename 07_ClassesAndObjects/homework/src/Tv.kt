class Tv(val brand: String, val model: String, val diagonalSize: Double) {

    private val listChannels = Channels.getRandomChannels()
    private var currentChannel = listChannels[0]
    private var flagStatusTv = false
    private var currentSound = 0

    init {
        println("Создан объект - $brand $model")
        println("Диагональ экран - $diagonalSize")
        getListChannel()
        println("----------------------")
    }

    fun includingOn() {
        if (flagStatusTv) {
            println("Телевизор уже включен")
        } else {
            println("Телевизор включен")
            val index = listChannels.indexOf(currentChannel)
            println("Текущий канал - ${index + 1}. $currentChannel")
            println("Текущая громкость: $currentSound")
            flagStatusTv = true
        }
    }

    fun includingOff() {
        if (!flagStatusTv) {
            println("Телевизор уже выключен")
        } else {
            println("Телевизор выключен")
            flagStatusTv = false
        }
    }

    fun switchingChannelsForward() {
        if (!flagStatusTv) {
            includingOn()
        }
        var index = listChannels.indexOf(currentChannel)
        if (listChannels.lastIndex == index) {
            currentChannel = listChannels[0]
            index = -1

        } else {
            this.currentChannel = listChannels[index + 1]
        }
        println("Канал переключен. Текущий канал - ${index + 2}. ${currentChannel}")
    }

    fun switchingChannelsBack() {
        if (!flagStatusTv) {
            includingOn()
        }
        var index = listChannels.indexOf(currentChannel)
        if (0 == index) {
            currentChannel = listChannels[listChannels.lastIndex]
            index = listChannels.lastIndex + 1

        } else {
            currentChannel = listChannels[index - 1]
        }
        println("Канал переключен. Текущий канал - ${index}. $currentChannel")
    }

    fun searchChannel(numberChannel: String?) {
        if (!flagStatusTv) {
            includingOn()
        }
        if (numberChannel != null) {
            val number = numberChannel.toInt()
            if (number > listChannels.lastIndex || number < 1) {
                println("Канал не найден")
                return
            }
            currentChannel = listChannels[number - 1]
            println("Канал переключен. Текущий канал - ${numberChannel}. $currentChannel")
        }
    }

    fun increaseSound(levelSound: Int) {
        if (!flagStatusTv) {
            println("Телевизор выключен")
            return
        }
        if (levelSound < 0) {
            println("Некорректный уровень громкости")
            return
        }
        val newSound = currentSound + levelSound

        currentSound = if (newSound <= MAX_SOUND_LEVEL) newSound else MAX_SOUND_LEVEL
        println("Текущая громкость: $currentSound")
    }

    fun decreaseSound(levelSound: Int) {
        if (!flagStatusTv) {
            println("Телевизор выключен")
            return
        }
        if (levelSound < 0) {
            println("Некорректный уровень громкости")
            return
        }
        val newSound = currentSound - levelSound

        currentSound = if (newSound >= 0) newSound else 0
        println("Текущая громкость: $currentSound")
    }

    fun getListChannel() {
        println("Список каналов: ")
        for (i in 0..listChannels.lastIndex) {
            println("${i + 1} - ${listChannels[i]}")
        }
    }

    companion object {
        const val MAX_SOUND_LEVEL = 100
    }
}