package ar.com.bancar.uala.feature1.di

import android.app.Activity
import ar.com.bancar.uala.feature1.data.Feature1Repository
import dagger.Subcomponent
import dagger.android.DispatchingAndroidInjector

@Subcomponent(modules = [Feature1Module::class, Feature1UIModule::class])
interface Feature1Component {

    val activityInjector: DispatchingAndroidInjector<Activity>

    @PrivateToFeature1
    fun feature1Repository(): Feature1Repository

    @Subcomponent.Builder
    interface Builder {
        fun featureModule1(module: Feature1Module): Builder
        fun build(): Feature1Component
    }
}