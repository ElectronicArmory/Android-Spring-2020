package edu.boisestate.getitdone

import edu.boisestate.getitdone.models.ToDoItem
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WebServices {

    private var service: ToDoInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://bsu-electronicarmory.s3.us-west-2.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(ToDoInterface::class.java)
    }

    fun todos( callback: Callback<List<ToDoItem>>){
        service.currentTodos().enqueue(callback)
    }
}