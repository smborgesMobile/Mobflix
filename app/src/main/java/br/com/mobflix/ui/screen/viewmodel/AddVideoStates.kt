package br.com.mobflix.ui.screen.viewmodel

sealed interface AddVideoIntent {
    data class SaveVideo(
        val videoCategory: String,
        val videoThumbUrl: String
    ) : AddVideoIntent
}

sealed interface AddVideoState {
    object Idle : AddVideoState
    object Loading : AddVideoState
    object Saved : AddVideoState
    object Error : AddVideoState
    object ShowAlertDialog: AddVideoState
}