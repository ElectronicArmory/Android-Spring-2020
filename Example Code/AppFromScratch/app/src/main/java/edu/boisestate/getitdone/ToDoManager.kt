package edu.boisestate.getitdone

import edu.boisestate.getitdone.models.ToDoItem
import java.util.*

object ToDoManager {
    private val mToDoList = mutableListOf<ToDoItem>()


    init {
        for (i in 1..20) {
            addToDoItem(ToDoItem("title", "description", Date(), i))
        }
    }



    fun todoList(): List<ToDoItem> {
        return mToDoList
    }

    fun addToDoItem( toDoTitle:String, toDoDescription:String = "", toDoDueDate:String = "", toDoPriority:Int = 9){
        var dueDate:Date
        if (toDoDueDate.isBlank()){
            dueDate = Date()
        }
        else {
            dueDate = Date(toDoDueDate)
        }

        val newToDoItem = ToDoItem(toDoTitle, toDoDescription, dueDate, toDoPriority)
        addToDoItem(newToDoItem)
    }

    private fun addToDoItem(newItem: ToDoItem) {
        mToDoList.add(newItem)
    }

    fun addToDoItems( listOfToDos:List<ToDoItem> ){
        mToDoList.addAll(listOfToDos)
    }

    /*
    *
     */
    fun removeToDo( todoToRemove:ToDoItem ){
        mToDoList.remove(todoToRemove)
    }

}