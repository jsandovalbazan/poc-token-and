package pro.jsandoval.poctoken.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pro.jsandoval.poctoken.data.repository.FirebaseRepositoryImpl
import pro.jsandoval.poctoken.domain.repository.FirebaseRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providesFirebaseRepository(firebaseRepositoryImpl: FirebaseRepositoryImpl): FirebaseRepository

}