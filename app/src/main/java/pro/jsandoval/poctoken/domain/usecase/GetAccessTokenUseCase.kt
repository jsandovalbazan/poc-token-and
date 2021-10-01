package pro.jsandoval.poctoken.domain.usecase

import kotlinx.coroutines.flow.Flow
import pro.jsandoval.poctoken.core.DataState
import pro.jsandoval.poctoken.domain.model.AccessToken

/**
 * Use case to get access token from network
 */

interface GetAccessTokenUseCase {

    /**
     * Get token
     *
     * @return a string which contains the token
     */

    suspend operator fun invoke(): Flow<DataState<AccessToken>>

}