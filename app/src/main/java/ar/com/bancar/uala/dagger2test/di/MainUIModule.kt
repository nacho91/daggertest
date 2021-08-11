package ar.com.bancar.uala.dagger2test.di

import ar.com.bancar.uala.dagger2test.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainUIModule {

    @ContributesAndroidInjector
    abstract fun test() : MainActivity
}