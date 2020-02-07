package edu.boisestate.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SecondActivity : AppCompatActivity() {

    companion object{
        const val KEY_EXTRA = "KEY_EXTRA"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val extraString:String = intent.getStringExtra(KEY_EXTRA)

        Log.d("BSU", extraString)

    }
}
