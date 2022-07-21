import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class Timer {
    var seconds = 0
    private val scope = CoroutineScope(Dispatchers.IO)

    fun start() {
        scope.launch {
            while (isActive) {
                seconds++
                delay(1.seconds)
            }
        }
    }
}