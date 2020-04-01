package edu.boisestate.bitcoinpriceslist.dummy

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object BitcoinPriceRepository {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<BitcoinPriceItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, BitcoinPriceItem> = HashMap()

    private val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: BitcoinPriceItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createDummyItem(position: Int): BitcoinPriceItem {
        return BitcoinPriceItem(position.toString(), "$$position.00", makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class BitcoinPriceItem(val id: String, val price: String, val priceDate: String) {
        override fun toString(): String = price
    }
}
