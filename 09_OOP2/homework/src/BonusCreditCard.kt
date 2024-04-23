class BonusCreditCard(
    creditLimit: Double = 0.0
) : CreditCard(creditLimit) {
    private var bonusPoints: Double = 0.0

    /** На каждое пополнение 2% бонус **/
    override fun replenishment(sum: Double) {
        val bonusFunds = sum + sum * 0.02
        super.replenishment(bonusFunds)
    }

    /** Кэшбэк бонусами 5% при покупках от 5,000 одной транзакции и 2% на транзакции менее 5,000  **/
    override fun payment(sum: Double): Boolean {
        super.payment(sum)
        bonusPoints += if (sum >= 5000.0) {
            sum * 0.05
        } else {
            sum * 0.02
        }
        return true
    }

    /** Доп. инфо к выводу **/
    override fun getInfoAboutAvailableFunds(): String {
        return super.getInfoAboutAvailableFunds() + "\n" + ("Бонусные баллы (кэшбэк): $bonusPoints")
    }

}