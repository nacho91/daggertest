package ar.com.bancar.uala.feature1.di

import ar.com.bancar.uala.feature1.data.Feature1Repository
import dagger.Module
import dagger.Provides

@Module
class Feature1Module {

    @Provides
    @PrivateToFeature1
    fun provideFeature1Repository() = Feature1Repository()
}