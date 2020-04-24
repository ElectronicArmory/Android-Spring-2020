package edu.boisestate.getitdone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.boisestate.getitdone.models.ToDoItem
import edu.boisestate.getitdone.ui.todoitemcrud.ToDoItemCrudFragment

class ToDoItemCrudActivity : AppCompatActivity() {

    var todoItem:ToDoItem? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.to_do_item_crud_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ToDoItemCrudFragment.newInstance())
                .commitNow()

            val bundleExtra = intent.getSerializableExtra("todoItem")
            bundleExtra?.let {
                todoItem = it as ToDoItem
            }
        }
    }
}
