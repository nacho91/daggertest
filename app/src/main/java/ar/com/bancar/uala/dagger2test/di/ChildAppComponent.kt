package ar.com.bancar.uala.dagger2test.di

import android.app.Activity
import android.app.Application
import ar.com.bancar.uala.core.data.CoreRepository
import ar.com.bancar.uala.core.di.CoreInstallModule
import ar.com.bancar.uala.dagger2test.Dagger2TestApplication
import ar.com.bancar.uala.dagger2test.MainActivity
import ar.com.bancar.uala.feature1.data.Feature1Repository
import ar.com.bancar.uala.feature1.di.Feature1Component
import ar.com.bancar.uala.feature1.di.Feature1InstallModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.DispatchingAndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppComponent::class],
    modules = [
        AndroidInjectionModule::class,
        ChildModule::class,
        MainUIModule::class,
        Feature1InstallModule::class,
        CoreInstallModule::class]
)
interface ChildAppComponent {
    fun inject(application: Dagger2TestApplication)

    val activityInjector: DispatchingAndroidInjector<Activity>

    val feature1Repository: Feature1Repository

    val coreRepository: CoreRepository

}