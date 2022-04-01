package pro.jsandoval.poctoken.domain.repository

import kotlinx.coroutines.flow.Flow
import pro.jsandoval.poctoken.core.DataState
import pro.jsandoval.poctoken.domain.model.AccessToken

/**
 * Repository handles firebase operations
 */

interface FirebaseRepository {
    suspend fun getAccessToken(): Flow<DataState<AccessToken>>
    suspend fun isInMaintenance(): Flow<Boolean>
}