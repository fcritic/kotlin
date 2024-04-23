class BonusDebitCard : DebitCard() {
    private var bonusPoints: Double = 0.0

    /** На каждое пополнение 1% бонус **/
    override fun replenishment(sum: Double) {
        val bonusFunds = sum + sum * 0.01
        super.replenishment(bonusFunds)
    }

    /** Кэшбэк бонусами 3% при покупках от 5,000 одной транзакции и 1% на транзакции менее 5,000  **/
    override fun payment(sum: Double): Boolean {
        super.payment(sum)
        bonusPoints += if (sum >= 5000.0) {
            sum * 0.03
        } else {
            sum * 0.01
        }
        return true
    }

    /** Доп. инфо к выводу **/
    override fun getBalanceInfo(): String {
        return super.getBalanceInfo() + "\n" + ("Бонусные баллы (кэшбэк): $bonusPoints")
    }
}