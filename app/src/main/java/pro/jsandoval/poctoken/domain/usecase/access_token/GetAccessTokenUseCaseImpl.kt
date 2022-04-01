package pro.jsandoval.poctoken.domain.usecase.access_token

import kotlinx.coroutines.flow.Flow
import pro.jsandoval.poctoken.core.DataState
import pro.jsandoval.poctoken.domain.model.AccessToken
import pro.jsandoval.poctoken.domain.repository.FirebaseRepository
import javax.inject.Inject

class GetAccessTokenUseCaseImpl @Inject constructor(
    private val firebaseRepository: FirebaseRepository
) : GetAccessTokenUseCase {

    override suspend fun invoke(): Flow<DataState<AccessToken>> {
        return firebaseRepository.getAccessToken()
    }
}