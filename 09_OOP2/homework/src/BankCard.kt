abstract class BankCard {
    abstract var balance: Double

    abstract fun replenishment(sum: Double)
    abstract fun payment(sum: Double): Boolean
    abstract fun getBalanceInfo(): String
    abstract fun getInfoAboutAvailableFunds(): String
}