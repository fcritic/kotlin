import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.onEach

class Presenter {
    fun generateNumbersBarrels(): Flow<Int> {
        return (1..90).shuffled().asFlow().onEach { delay(50) }
    }
}