fun main() {
    val bonusDebitCard = BonusDebitCard()
    bonusDebitCard.replenishment(5000.0)
    bonusDebitCard.payment(2000.0)
    bonusDebitCard.replenishment(5000.0)

    println(bonusDebitCard.getBalanceInfo())
    

    val bonusCreditCard = BonusCreditCard(100000.0)
    bonusCreditCard.replenishment(5000.0)
    bonusCreditCard.payment(3000.0)
    bonusCreditCard.replenishment(5000.0)
    bonusCreditCard.payment(75000.0)
    bonusCreditCard.replenishment(20000.0)
    bonusCreditCard.replenishment(50000.0)
    bonusCreditCard.payment(90000.0)
    bonusCreditCard.replenishment(150000.0)

    println(bonusCreditCard.getInfoAboutAvailableFunds())
}