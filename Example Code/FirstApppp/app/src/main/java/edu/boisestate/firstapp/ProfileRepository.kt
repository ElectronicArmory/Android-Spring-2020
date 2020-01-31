package edu.boisestate.firstapp

object ProfileRepository {
    var profile:UserModel? = null

    fun loginUser(profile:UserModel):Boolean{

        if( profile.username == "michaelziray@boisestate.edu"){

            this.profile = profile
            this.profile!!.loggedInTimes = this.profile!!.loggedInTimes?.plus(1)
            return true
        }

        return false
    }
}