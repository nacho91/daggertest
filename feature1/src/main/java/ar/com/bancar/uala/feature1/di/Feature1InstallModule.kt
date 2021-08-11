package ar.com.bancar.uala.feature1.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [Feature1Component::class])
class Feature1InstallModule {

    @Singleton
    @Provides
    fun provideFeature1Component(feature1Component: Feature1Component.Builder) = feature1Component.featureModule1(Feature1Module()).build()

    @Singleton
    @Provides
    fun provideFeature1Repository(feature1Component: Feature1Component) = feature1Component.feature1Repository()

}