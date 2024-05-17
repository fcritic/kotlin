import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.math.BigInteger

fun main(): Unit = runBlocking {
    val fibonacci = Fibonacci
    println("Введите число больше 0: ")
    val n: Int = readlnOrNull()?.toIntOrNull() ?: return@runBlocking println("Ошибка")

    launch {
        println("Start runBlocking...")
        for (i in 0..4) {
            delay(1000)
            fibonacci.take(n + i)
        }
        println("Finish runBlocking")
    }
}

object Fibonacci {
    suspend fun take(n: Int): BigInteger {
        var result: BigInteger = BigInteger.ZERO
        var numberOne: BigInteger = BigInteger.ZERO
        var numberTwo: BigInteger = BigInteger.ONE

        when {
            n <= 0 -> {
                println("Ошибка")
                return result
            }

            n == 1 -> result = BigInteger.ONE
            else -> {
                for (i in 2..n) {
                    result = numberOne + numberTwo
                    numberOne = numberTwo
                    numberTwo = result
                }
            }
        }
        println("Число Фибоначчи для $n: $result")
        return result
    }
}