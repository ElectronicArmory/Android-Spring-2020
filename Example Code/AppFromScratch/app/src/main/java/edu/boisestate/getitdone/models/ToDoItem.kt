package edu.boisestate.getitdone.models

import com.google.gson.annotations.SerializedName
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.io.Serializable
import java.util.*

@Entity
data class ToDoItem(
    @Id var id:Long = 0,

    @SerializedName("todoTitle")
    var todoTitle: String?,
    var todoDescription: String?,
    var isDone:Boolean?,
    var todoDueDate: String?,
    var todoPriority: Int?
):Serializable