package br.com.mobflix.ui.screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AddVideoScreenViewModel(
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _addVideoStateFlow = MutableStateFlow<AddVideoState>(AddVideoState.Idle)
    val addVideoState: StateFlow<AddVideoState> = _addVideoStateFlow

    fun processIntent(addVideoIntent: AddVideoIntent) {
        when (addVideoIntent) {
            is AddVideoIntent.SaveVideo -> saveVideo(
                addVideoIntent.videoThumbUrl, addVideoIntent.videoCategory
            )

            else -> Unit
        }
    }

    private fun saveVideo(videoThumbUrl: String, videoCategory: String) {
        viewModelScope.launch(dispatcher) {
            // show loading
            _addVideoStateFlow.emit(AddVideoState.Loading)

            if (videoThumbUrl.isEmpty() || videoCategory.isEmpty()) {
                _addVideoStateFlow.emit(AddVideoState.ShowAlertDialog)
                return@launch
            }
        }
    }
}