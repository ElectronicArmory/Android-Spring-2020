package edu.boisestate.getitdone

import edu.boisestate.getitdone.models.ToDoItem
import retrofit2.http.GET
import retrofit2.Call


interface ToDoInterface {
    @GET("todos.json")
//    @GET("history")
    fun currentTodos(): Call<List<ToDoItem>>
}