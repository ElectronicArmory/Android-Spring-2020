package edu.boisestate.getitdone

import android.content.Context
import edu.boisestate.getitdone.models.MyObjectBox
import io.objectbox.BoxStore

object ObjectBox {

    lateinit var boxStore: BoxStore private set

    fun init(context: Context){
        boxStore = MyObjectBox.builder()
            .androidContext(context.applicationContext)
            .build()
    }
}