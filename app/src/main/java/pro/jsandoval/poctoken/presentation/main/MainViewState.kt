package pro.jsandoval.poctoken.presentation.main

/**
 * Represents the possible UI state of Main Screen
 */

sealed class MainViewState {
    internal object Idle : MainViewState()
    internal object Loading : MainViewState()
    internal object InMaintenance : MainViewState()
    internal object CanProceed : MainViewState()
    internal data class Loaded(val accessToken: String) : MainViewState()
    internal data class Error(val message: String) : MainViewState()
}