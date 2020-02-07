package edu.boisestate.firstapp

import java.util.*

object UsersRepository {
    private val usersList = mutableListOf<UserModel>()


    fun usersList(): List<UserModel> {
        return Collections.unmodifiableList(usersList)
    }

    fun addUser(user:UserModel){
        usersList.add(user)

    }

    fun removeAll(){
        usersList.clear()
    }


    fun loginUser(profile:UserModel):Boolean{

//        if( profile.username == "michaelziray@boisestate.edu"){
//
//            this.profile = profile
//            this.profile!!.loggedInTimes = this.profile!!.loggedInTimes?.plus(1)
//            return true
//        }

        return false
    }
}