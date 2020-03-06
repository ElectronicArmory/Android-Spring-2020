package edu.boisestate.databasetest

import io.objectbox.kotlin.query
import io.objectbox.query.QueryBuilder

object TodoManager {
    val todosBox = ObjectBox.boxStore.boxFor(ToDoItem::class.java)

    var currentResults:MutableList<ToDoItem>? = null

    val query = todosBox.query {
        order(ToDoItem_.todoDueDate, QueryBuilder.DESCENDING)
        less(ToDoItem_.weight, 5)
//        greater(ToDoItem_.todoDueDate, Date())
    }

    private val todoList:MutableList<ToDoItem> by lazy{
        currentResults = query.find()

        currentResults!!
    }

    fun addToDo(newToDoItem: ToDoItem){
        todosBox.put(newToDoItem)
    }

    fun todoList():MutableList<ToDoItem>{
        currentResults = query.find()
        return currentResults!!
    }
}