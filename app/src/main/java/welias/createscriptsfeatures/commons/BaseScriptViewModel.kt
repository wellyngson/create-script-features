package welias.createscriptsfeatures.commons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseScriptViewModel<ACTION, RESULT, STATE> : ViewModel() {
    private val _result = MutableSharedFlow<RESULT>()
    val result: SharedFlow<RESULT> = _result

    private val _uiState: MutableStateFlow<STATE> by lazy { MutableStateFlow(initialState) }
    val uiState: StateFlow<STATE> = _uiState

    protected abstract val initialState: STATE

    abstract fun sendIntent(action: ACTION)

    protected fun emitResult(result: RESULT) =
        viewModelScope.launch {
            _result.emit(result)
        }

    protected fun updateUiState(uiState: STATE) {
        _uiState.value = uiState
    }
}
