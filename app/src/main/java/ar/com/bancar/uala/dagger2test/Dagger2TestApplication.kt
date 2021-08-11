package ar.com.bancar.uala.dagger2test

import android.app.Application
import ar.com.bancar.uala.dagger2test.di.AppComponent
import ar.com.bancar.uala.dagger2test.di.ChildAppComponent
import ar.com.bancar.uala.dagger2test.di.DaggerAppComponent
import ar.com.bancar.uala.dagger2test.di.DaggerChildAppComponent
import ar.com.bancar.uala.feature1.di.Feature1Component
import ar.com.bancar.uala.feature1.di.Feature1ComponentProvider
import javax.inject.Inject

class Dagger2TestApplication : Application(), Feature1ComponentProvider {

    private lateinit var appComponent: AppComponent

    lateinit var childAppComponent: ChildAppComponent

    @Inject
    lateinit var feature1Component: Feature1Component

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
    }

    fun initChildAppComponent() {
        childAppComponent = DaggerChildAppComponent
            .builder()
            .appComponent(appComponent)
            .build()

        childAppComponent.inject(this)
    }

    override fun provideFeature1Component(): Feature1Component {
        return feature1Component
    }


}