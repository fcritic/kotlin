import kotlinx.coroutines.*

val parentJob = Job()
val scope = CoroutineScope(parentJob)

suspend fun main() {
    val fibonacci = Fibonacci

    val jobFirst = scope.launch {
        println("Start `first`...")
        try {
            withTimeout(3_000) {
                fibonacci.take(78)
            }
        } catch (e: TimeoutCancellationException) {
            println("\nПревышено время ожидания (Coroutine first)")
        }
        println("Finish `first`")

    }

    val jobSecond = scope.launch {
        println("Start `second`...")
        try {
            withTimeout(3_000) {
                fibonacci.take(285)
            }
        } catch (e: TimeoutCancellationException) {
            println("\nПревышено время ожидания (Coroutine second)")
        }
        println("Finish `second`")
    }

    val progressJob = scope.launch {
        while (jobFirst.isActive || jobSecond.isActive) {
            print(".")
            delay(100)
        }
    }
    jobFirst.join()
    jobSecond.join()
    progressJob.cancelAndJoin()
}