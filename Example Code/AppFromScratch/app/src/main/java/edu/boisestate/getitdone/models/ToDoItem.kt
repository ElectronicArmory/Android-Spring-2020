package edu.boisestate.getitdone.models

import java.io.Serializable
import java.util.*


data class ToDoItem(
    var todoTitle: String,
    var todoDescription: String,
    var todoDueDate: Date,
    var todoPriority: Int
):Serializable