open class CreditCard(private val creditLimit: Double = 0.0) : BankCard() {
    private var ownFunds: Double = 0.0
    private var creditFunds: Double = creditLimit

    override var balance: Double = creditFunds + ownFunds

    init {
        println("**********************************")
        println("Кредитная карта с лимитом $creditLimit")
        println("Кредитные средства: $creditFunds")
        println("Собственные средства: $ownFunds")
        println("-----------------------------------")
    }

    override fun replenishment(sum: Double) {
        if (balance < creditLimit) {
            val debt = creditLimit - balance

            if (sum <= debt) {
                creditFunds += sum
            } else {
                creditFunds = creditLimit
                ownFunds = sum - debt
            }
        } else {
            ownFunds += sum
        }
        balance = creditFunds + ownFunds

        println("После пополнения карты на $sum:")
        println("Кредитные средства: $creditFunds")
        println("Собственные средства: $ownFunds")
        println("-----------------------------------")
    }

    override fun payment(sum: Double): Boolean {
        if (balance > 0) {
            if (ownFunds >= sum) {
                ownFunds -= sum
                println("После оплаты на $sum:")
                println("Кредитные средства: $creditFunds")
                println("Собственные средства: $ownFunds")
                println("-----------------------------------")
                return true
            } else {
                creditFunds -= (sum - ownFunds)
                ownFunds = 0.0
                balance = creditFunds + ownFunds
                println("После оплаты на $sum:")
                println("Кредитные средства: $creditFunds")
                println("Собственные средства: $ownFunds")
                println("-----------------------------------")
                return true
            }
        }
        balance = creditFunds + ownFunds
        println("Недостаточно средств")
        return false
    }

    override fun getBalanceInfo(): String {
        return "Кредитные средства: $creditFunds, собственные средства: $ownFunds"
    }

    override fun getInfoAboutAvailableFunds(): String {
        return "Доступные средства: $balance"
    }

}