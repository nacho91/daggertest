package ar.com.bancar.uala.core.di

import ar.com.bancar.uala.core.data.CoreRepository
import dagger.Module
import dagger.Provides

@Module
class CoreModule {

    @Provides
    @PrivateToCore
    fun provideFeature1Repository() = CoreRepository()
}