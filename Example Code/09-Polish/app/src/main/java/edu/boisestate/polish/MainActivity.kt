package edu.boisestate.polish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiHost = BuildConfig.WEB_SERVER + "/api/v1/"

        if (BuildConfig.BUILD_TYPE == "debug") {
            debugButton.visibility = View.GONE
        }
    }
}
