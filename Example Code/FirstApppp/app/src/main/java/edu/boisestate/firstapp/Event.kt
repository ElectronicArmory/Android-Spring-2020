package edu.boisestate.firstapp

import android.util.Log
import java.util.*

class Event {

    var eventName:String = "Default"
    var eventDate: Date = Date()
    var didAttend:Boolean = false

    companion object {
        val state: String = "Idaho"
        fun whichState():String{
            return state
        }
    }

    fun attendEvent(didAttend:Boolean){
        this.didAttend = didAttend
        Log.d("BSU", "Did attend: $didAttend in $state")
    }

}