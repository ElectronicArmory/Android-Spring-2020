package map.boisestate.edu.webservices

import retrofit2.Call
import retrofit2.http.GET

interface CoinDeskApi {

    @GET("bpi/currentprice.json")
    fun getBitcoinPrice(): Call<BpiResponse>
}