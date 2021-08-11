package ar.com.bancar.uala.feature1.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ar.com.bancar.uala.feature1.data.Feature1Repository
import ar.com.bancar.uala.feature1.di.Feature1ComponentProvider
import dagger.android.AndroidInjection
import javax.inject.Inject

class Feature1Activity : AppCompatActivity() {

    @Inject
    lateinit var feature1Repository: Feature1Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as Feature1ComponentProvider)
            .provideFeature1Component()
            .activityInjector
            .inject(this)

        Log.v("DaggerTest", feature1Repository.toString())
    }
}