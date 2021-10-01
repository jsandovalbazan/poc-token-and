package pro.jsandoval.poctoken.data.repository

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import pro.jsandoval.poctoken.core.DataState
import pro.jsandoval.poctoken.core.await
import pro.jsandoval.poctoken.domain.model.AccessToken
import pro.jsandoval.poctoken.domain.repository.FirebaseRepository
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseRepositoryImpl @Inject constructor(
    private val firebaseFirestore: FirebaseFirestore
) : FirebaseRepository {

    override suspend fun getAccessToken(): Flow<DataState<AccessToken>> = flow {
        emit(DataState.loading(true))

        try {
            val config = firebaseFirestore.collection(CONFIG_COLLECTION)
            val snapshot = config
                .document(ACCESS_TOKEN_DOCUMENT)
                .get()
                .await()

            emit(DataState.data(data = parseAccessTokenItem(snapshot = snapshot)))

        } catch (ex: Exception) {
            Timber.e(ex, "there was an error reading access token")
            emit(DataState.error<AccessToken>(message = ex.message))
        }

    }.catch { error -> emit(DataState.error(message = error.message)) }

    private fun parseAccessTokenItem(snapshot: DocumentSnapshot): AccessToken {
        return AccessToken(
            token = snapshot["token"] as? String ?: ""
        )
    }

    companion object {
        private const val CONFIG_COLLECTION = "config"
        private const val ACCESS_TOKEN_DOCUMENT = "accessToken"
    }
}