// Consider using data class later ?
fun main() {

    class Product(id_param: String, name_param: String, price_param: Double) {

        var id = id_param  // product ID with custom setter
            set(value) {
                if ( value != "" ) field = value
            }
        var name = name_param  // product name with custom setter
            set(value) {
                if ( value != "" ) field = value
            }
        var price = price_param  // product price with custom setter
            set(value) {
                if ( value >  0.0 ) field = value
            }

        fun printItem() {
            print("$id - $name - $price")
            println()
        }
    }

    class Cart {
        private val items = mutableListOf<Product>()  // best data structure for items in cart ?

        fun addProduct(item: Product) {
            items.add(item)
        }

        fun removeProduct(item: Product) {
            items.remove(item)
        }

        fun showItemsInCart() {
            println("Items in my cart")
            for ( item in items ) {
                println("${item.id} - ${item.name} - ${item.price}")
            }
        }

        fun calculateTotal() {
            var total = 0.0
            for (item in items) {
                total += item.price
            }
            print("Total : $${total}")
        }
    }

    println("Hello shopper !!")
    val item1 = Product("001", "Banana", 1.59)
    item1.printItem()
    val item2 = Product("002", "Cheerios", 3.59)
    item2.printItem()
    val item3 = Product("003", "Ice cream", 5.59)
    item3.printItem()
    val myCart = Cart()
    myCart.addProduct(item1)
    myCart.addProduct(item2)
    myCart.addProduct(item3)
    myCart.addProduct(Product("004", "Milk", 3.99))
    myCart.showItemsInCart()
    myCart.removeProduct(item1)
    println("Remove banana from the cart")
    myCart.showItemsInCart()
    myCart.calculateTotal()
    println()
    println("Thank you for shopping with us !")

}
    