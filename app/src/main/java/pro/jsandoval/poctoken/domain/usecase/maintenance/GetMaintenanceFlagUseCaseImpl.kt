package pro.jsandoval.poctoken.domain.usecase.maintenance

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pro.jsandoval.poctoken.domain.repository.FirebaseRepository
import javax.inject.Inject

class GetMaintenanceFlagUseCaseImpl @Inject constructor(
    private val firebaseRepository: FirebaseRepository
) : GetMaintenanceFlagUseCase {

    override suspend fun invoke(): Flow<Boolean> {
        return firebaseRepository.isInMaintenance()
    }
}