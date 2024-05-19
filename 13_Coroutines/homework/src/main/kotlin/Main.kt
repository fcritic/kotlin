import kotlinx.coroutines.*
import kotlin.random.Random

val parentJob = Job()
val scope = CoroutineScope(parentJob)

suspend fun main() {
    val fibonacci = Fibonacci

    println("Запуск расчета:")
    val jobList = List(3) { count ->
        val infoCoroutine = "К - ${count + 1}"
        val n = Random.nextInt(100,250)

        scope.launch {
            try {
                withTimeout(3_000) {
                    val result = fibonacci.take(n)
                    println("\nЧисло Фибоначчи для $n: $result ($infoCoroutine)")
                }
            } catch (e: TimeoutCancellationException) {
                println("\nПревышено время ожидания числа: $n ($infoCoroutine)")
            }
        }

    }

    val progressJob = scope.launch {
        while (jobList.any { it.isActive}) {
            print(".")
            delay(200)
        }
    }
    jobList.forEach { it.join() }
    progressJob.cancelAndJoin()
}