package ar.com.bancar.uala.feature1.di

import ar.com.bancar.uala.feature1.ui.Feature1Activity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class Feature1UIModule {

    @ContributesAndroidInjector
    abstract fun feature1Activity(): Feature1Activity
}