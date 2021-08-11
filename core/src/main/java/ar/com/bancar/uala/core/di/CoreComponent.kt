package ar.com.bancar.uala.core.di

import ar.com.bancar.uala.core.data.CoreRepository
import dagger.Subcomponent

@Subcomponent(modules = [CoreModule::class])
interface CoreComponent {

    @PrivateToCore
    fun coreRepository(): CoreRepository

    @Subcomponent.Builder
    interface Builder {
        fun build(): CoreComponent
    }
}