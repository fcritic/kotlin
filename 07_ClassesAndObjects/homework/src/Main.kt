fun main() {
    val lg = Tv("lg", "g-146", 27.1)
//    val panasonic = Tv("Panasonic", "gsd-16", 17.4)

    printInfo(lg)
//    printInfo(panasonic)

    lg.includingOn()
    lg.switchingChannelsForward()
    lg.switchingChannelsBack()
    lg.switchingChannelsBack()
    lg.switchingChannelsForward()
    lg.switchingChannelsForward()
    lg.switchingChannelsForward()
    lg.switchingChannelsBack()
//    lg.getListChannel()
    lg.increaseSound(101)
    lg.decreaseSound(51)
    lg.includingOff()
    lg.searchChannel("4")
    lg.getListChannel()
}

fun printInfo(tv: Tv) {
    println("Бренд - ${tv.brand}, Модель - ${tv.model}, Диагональ  - ${tv.diagonalSize}")
}

