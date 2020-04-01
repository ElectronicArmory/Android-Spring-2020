package edu.boisestate.bitcoinpriceslist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import edu.boisestate.bitcoinpriceslist.dummy.BitcoinPriceRepository

class MainActivity : AppCompatActivity(), BitCoinPriceListFragment.OnListFragmentInteractionListener {

    val listFragment = BitCoinPriceListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .add(R.id.contentView, listFragment)
                .addToBackStack("LIST")
                .commit()
    }

    override fun onListFragmentInteraction(item: BitcoinPriceRepository.BitcoinPriceItem?) {
        Log.d("BSU", item!!.id)
        val newPrice = BitcoinPriceRepository.BitcoinPriceItem(item!!.id + item!!.id, "$4200.00", "Description")
        BitcoinPriceRepository.ITEMS.add(newPrice)


        listFragment.adapter.notifyDataSetChanged()
//        val intent = Intent(this, MainActivity::class.java)
//        intent.putExtra("id", item.id)
//        startActivity(intent)
    }
}
