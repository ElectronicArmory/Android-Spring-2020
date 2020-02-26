package map.boisestate.edu.webservices

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var currentPrice:String
    lateinit var priceTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        priceTextView = price_textview


        val downloader = BitcoinPriceService()
        val callback = object: Callback<BpiResponse>{
            override fun onFailure(call: Call<BpiResponse>?, t: Throwable?) {
                Log.e("MainActivity", "Problems", t)
            }

            override fun onResponse(call: Call<BpiResponse>?, response: Response<BpiResponse>?) {
                response?.isSuccessful.let{
                    Log.d("Response", response.toString())
                    Log.d("Response", response?.body().toString())
                    val resp = response?.body()?.bpi?.USD
                    this@MainActivity.currentPrice = resp?.rate ?: "Unknown"


                    resp?.symbol?.let {
                        it.length

                    }
                    priceTextView.text = "%.2f".format(resp?.rate_float)
                }
            }

        }
        downloader.getBitcoinPrice(callback)
    }
}
