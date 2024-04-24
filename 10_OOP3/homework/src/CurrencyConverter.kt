interface CurrencyConverter {
   val currencyCode: String
   val currencyRate: Double
   fun convertRub(rub: Double): Double
}