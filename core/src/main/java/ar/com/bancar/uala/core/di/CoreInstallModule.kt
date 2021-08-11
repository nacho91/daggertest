package ar.com.bancar.uala.core.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [CoreComponent::class])
class CoreInstallModule {

    @Singleton
    @Provides
    fun provideFeature1Component(coreComponentBuilder: CoreComponent.Builder) = coreComponentBuilder.build()

    @Singleton
    @Provides
    fun provideFeature1Repository(coreComponent: CoreComponent) = coreComponent.coreRepository()
}