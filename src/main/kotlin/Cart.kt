import java.text.DecimalFormat

class Cart {
    private val items = mutableMapOf<Int,Pair<String,Double>>()
    // best data structure for items in cart ?

    fun addProduct(item: Triple<Int, String, String>): Boolean {
        return try {
            items[item.first.toInt()] = Pair(item.second, item.third.toDouble())
            true
        } catch (e: NumberFormatException) {
            println("Please enter the price of the item")
            false
        }
    }

    fun removeProduct(item: Int): Boolean {
        return when {
            items.containsKey(item) -> {
                items.remove(item)
                true
            }
            else -> {
                println("Item not in cart.")
                false
            }
        }
    }

    fun showItemsInCart() {
        println("Items in my cart")
        items.forEach {( key, value) -> println("$key - $value")}
    }

    fun calculateTotal(): Double {
        var grandTotal: Double = 0.0
        items.forEach {(key,value) -> grandTotal += value.second }
        val df = DecimalFormat("#.##")
        val grandTotalFormat = df.format(grandTotal)
        println("Total : $${grandTotalFormat}")
        return grandTotal
    }
}

