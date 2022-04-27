import java.text.DecimalFormat

class customOutOfStockException(message: String) : Exception(message)
class Cart {
    private val items = mutableMapOf<Int,Pair<String,Double>>()
    private val outOfStockItems = listOf("bagel", "donut", "celery")
    // best data structure for items in cart ?

    fun addProduct(item: Triple<Int, String, String>): Boolean {
        return try {
            if (item.second.lowercase() in outOfStockItems) {
                    throw customOutOfStockException("Sorry we are out of $item.second")
            }
            items[item.first.toInt()] = Pair(item.second, item.third.toDouble())
            true
        } catch (e: NumberFormatException) {
            println("Please enter the command, item and the price of the item")
            false
        } catch (e: customOutOfStockException) {
            println("Sorry we are out of ${item.second}")
            print(outOfStockItems.joinToString(
                prefix = "(",
                separator = ", ",
                postfix = ")"
            ))
            println(" are currently out of stock")
            false
        }
    }

    fun removeProduct(item: Int): Boolean {
        return when {
            items.containsKey(item.toInt()) -> {
                items.remove(item)
                println("Item # $item was removed from the cart")
                true
            }
            else -> {
                println("Item not in cart.")
                false
            }
        }
    }

    fun showItemsInCart() {
            if (items.isNotEmpty()) {
                println("Items in my cart")
                items.forEach {( key, value) -> println("$key - $value")}
            }
            else {
                println("Cart is empty")
            }
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

