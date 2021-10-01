package pro.jsandoval.poctoken.presentation.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import pro.jsandoval.poctoken.core.MessageType
import pro.jsandoval.poctoken.domain.usecase.GetAccessTokenUseCase
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAccessTokenUseCase: GetAccessTokenUseCase
) : ViewModel() {

    fun getAccessToken(): Flow<MainViewState> = flow {
        getAccessTokenUseCase().collect { dataState ->
            if (dataState.loading) emit(MainViewState.Loading)
            when (dataState.type) {
                MessageType.Success -> {
                    val data = dataState.data
                    Timber.d("token obtained: ${data?.token}")
                    emit(MainViewState.Loaded(data?.token ?: ""))
                }
                MessageType.Error -> {
                    Timber.e("there was an error getting data from firestore")
                    emit(MainViewState.Error(message = dataState.message ?: ""))
                }
            }
        }
    }

}