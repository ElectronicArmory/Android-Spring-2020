package map.boisestate.edu.webservices

import java.io.Serializable


data class BpiResponse(val bpi:BpiObject,
                       val date:String,
                       val open:Float,
                       val close:String):Serializable {
}

class BpiObject (val USD:BitcoinPrice)

class BitcoinPrice (val code:String,
                    val symbol:String? = null,
                    val rate:String,
                    val description:String,
                    val rate_float:Float)
