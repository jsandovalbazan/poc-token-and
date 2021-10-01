package pro.jsandoval.poctoken.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import pro.jsandoval.poctoken.domain.usecase.GetAccessTokenUseCase
import pro.jsandoval.poctoken.domain.usecase.GetAccessTokenUseCaseImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun providesGetTokenUseCase(getAccessTokenImpl: GetAccessTokenUseCaseImpl): GetAccessTokenUseCase

}