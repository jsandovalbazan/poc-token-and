package pro.jsandoval.poctoken.domain.usecase.maintenance

import kotlinx.coroutines.flow.Flow

/**
 * Use case to check if the app is in maintenance
 */
interface GetMaintenanceFlagUseCase {

    /**
     * Get maintenance flag
     *
     * @return a boolean which determine if the app is in maintenance or not
     */

    suspend operator fun invoke(): Flow<Boolean>

}