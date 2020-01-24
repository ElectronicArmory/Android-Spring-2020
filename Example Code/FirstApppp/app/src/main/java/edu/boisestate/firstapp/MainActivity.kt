package edu.boisestate.firstapp

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    var hasRestarted:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val localTextView = textView2

        setupUI(localTextView)
    }

    private fun setupUI(localTextView: TextView) {
        submitButton.setOnClickListener {
            val inputValue = editText.text.toString()
            val outputString = "Your principal ${inputValue.count() + 99} is $inputValue after $inputValue months"
//             "Your principal " + $$ + " is " + $$ + "after XX months"
            localTextView.text = "$outputString ${getString(R.string.name_key)}"
        }
    }


    override fun onDestroy() {
        // Tear down here before calling super class's function

        super.onDestroy()
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
            R.id.action_first -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
