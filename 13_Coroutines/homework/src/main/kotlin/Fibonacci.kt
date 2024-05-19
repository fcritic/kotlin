import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import java.math.BigInteger

object Fibonacci {
    suspend fun take(n: Int): BigInteger {
        var x = BigInteger.ZERO
        var y = BigInteger.ONE
        var result = x

        when {
            n <= 0 -> {
                println("Число Фибоначчи для $n: ошибка")
                return result
            }
            n == 1 -> result = BigInteger.ONE
        }

        for (i in 2..n) {
            if (!currentCoroutineContext().isActive) {
                println("Расчет был отменен")
                return result
            }
            result = x + y
            x = y
            y = result
            delay(1)
        }
        return result
    }
}