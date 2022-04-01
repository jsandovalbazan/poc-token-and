package pro.jsandoval.poctoken.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import pro.jsandoval.poctoken.domain.usecase.access_token.GetAccessTokenUseCase
import pro.jsandoval.poctoken.domain.usecase.access_token.GetAccessTokenUseCaseImpl
import pro.jsandoval.poctoken.domain.usecase.maintenance.GetMaintenanceFlagUseCase
import pro.jsandoval.poctoken.domain.usecase.maintenance.GetMaintenanceFlagUseCaseImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun providesGetTokenUseCase(getAccessTokenImpl: GetAccessTokenUseCaseImpl): GetAccessTokenUseCase

    @Binds
    abstract fun providesGetMaintenanceFlagUseCase(getMaintenanceFlagUseCaseImpl: GetMaintenanceFlagUseCaseImpl): GetMaintenanceFlagUseCase

}