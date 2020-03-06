package edu.boisestate.databasetest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity(), TodoItemFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newTodo:ToDoItem = ToDoItem(todoTitle = "22 New title", todoDescription = "a new desc", todoDueDate = Date() )
        TodoManager.addToDo(newTodo)
    }

    override fun onListFragmentInteraction(item: ToDoItem?) {
        // Show details
    }
}
