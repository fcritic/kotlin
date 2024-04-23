open class DebitCard() : BankCard() {
    override var balance: Double = 0.0

    override fun replenishment(sum: Double) {
        balance += sum
        println("После пополнения карты на $sum:")
        println("Баланс: $balance")
        println("-----------------------------------")
    }

    override fun payment(sum: Double): Boolean {
        if (balance >= sum) {
            balance -= sum
            println("После оплаты на $sum:")
            println("Баланс: $balance")
            println("-----------------------------------")
            return true
        }
        println("Недостаточно средств")
        return false
    }

    override fun getBalanceInfo(): String {
        return "Баланс дебетовой карты: $balance"
    }

    override fun getInfoAboutAvailableFunds(): String {
        return getBalanceInfo()
    }
}