package ar.com.bancar.uala.dagger2test

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import ar.com.bancar.uala.core.data.CoreRepository
import ar.com.bancar.uala.dagger2test.di.ChildAppComponent
import ar.com.bancar.uala.dagger2test.di.DaggerAppComponent
import ar.com.bancar.uala.dagger2test.di.DaggerChildAppComponent
import ar.com.bancar.uala.feature1.data.Feature1Repository
import ar.com.bancar.uala.feature1.ui.Feature1Activity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var feature1Repository: Feature1Repository

    @Inject
    lateinit var coreRepository: CoreRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as Dagger2TestApplication).initChildAppComponent()

        (applicationContext as Dagger2TestApplication).childAppComponent.activityInjector.inject(this)

        Log.v("DaggerTest", feature1Repository.toString())
        Log.v("DaggerTest", coreRepository.toString())

        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            startActivity(Intent(this@MainActivity, Feature1Activity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}