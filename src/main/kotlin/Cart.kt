import java.text.DecimalFormat

class Cart {
    private val items = mutableMapOf<Int,Pair<String,Double>>()
    // best data structure for items in cart ?

    fun addProduct(item: Triple<Int, String, String>) {
        items[item.first.toInt()] = Pair(item.second, item.third.toDouble())
    }

    fun removeProduct(item: Int) {
        items.remove(item)
    }

    fun showItemsInCart() {
        println("Items in my cart")
        for ( key in items.keys ) {
            println("$key - ${items[key]}")
        }
    }

    fun calculateTotal() {
        var grandTotal: Double = 0.0
        for (key in items.keys) {
            grandTotal += items.getValue(key).second
        }
        val df = DecimalFormat("#.##")
        val grandTotalFormat = df.format(grandTotal)
        print("Total : $${grandTotalFormat}")
    }
}

