fun main() {
    /** Вывод: «n рублей = m %код валюты%». **/

    val converters = Converters
    val rub: Double = 100.0
    val currencyCode = listOf<String>("CNY", "USD", "HKD")

    for (code in currencyCode) {
        val rubToCny = converters.get(code)
        println("$rub рублей = ${rub * rubToCny.currencyRate} $code")
    }

}

object Converters {
    private val converters = mutableMapOf<String, CurrencyConverter>()

    init {
        converters["USD"] = RubToUsdConverter
        converters["CNY"] = RubToCnyConverter
        converters["EUR"] = RubToEurConverter
    }

    fun get(currencyCode: String): CurrencyConverter {
        return converters[currencyCode] ?: createUnidentifiedConverter(currencyCode)
    }

    private fun createUnidentifiedConverter(currencyCode: String): CurrencyConverter {
        return object : CurrencyConverter {
            override val currencyCode: String = currencyCode
            override val currencyRate: Double = 0.5

            override fun convertRub(rub: Double): Double {
                return rub * currencyRate
            }
        }
    }

}

object RubToUsdConverter : CurrencyConverter {
    override val currencyCode: String = "USD"
    override val currencyRate: Double = 0.010719

    override fun convertRub(rub: Double): Double {
        return rub * currencyRate
    }
}

object RubToCnyConverter : CurrencyConverter {
    override val currencyCode: String = "CNY"
    override val currencyRate: Double = 0.077884

    override fun convertRub(rub: Double): Double {
        return rub * currencyRate
    }
}

object RubToEurConverter : CurrencyConverter {
    override val currencyCode: String = "EUR"
    override val currencyRate: Double = 0.010044

    override fun convertRub(rub: Double): Double {
        return rub * currencyRate
    }
}
