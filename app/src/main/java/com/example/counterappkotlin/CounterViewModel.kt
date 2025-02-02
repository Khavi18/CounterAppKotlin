import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.example.counterappkotlin.CounterRepository

class CounterViewModel(): ViewModel() {
    private val _repository: CounterRepository = CounterRepository()
    private val _count = mutableIntStateOf(_repository.getCounter().count)
    //Expose count as an immutable state
    val count: MutableState<Int> = _count

    fun increment() {
        _repository.incrementCounter()
        _count.value = _repository.getCounter().count
    }

    fun decrement() {
        _repository.decrementCounter()
        _count.value = _repository.getCounter().count
    }
}