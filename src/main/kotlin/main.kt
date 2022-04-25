

import java.util.Scanner
fun main() {
    AppMenu()
    val myCart = Cart()
    var itemNum: Int = 0
    val scanner = Scanner(System.`in`)
    while (true) {
        val words = scanner.nextLine().split(" ")
        when(words[0]) {
            "done" -> {
                println("Thank you for shopping with us !")
                break
            }
            "add" -> myCart.addProduct(Triple(++itemNum, words[1], words[2]))
            "cart" -> myCart.showItemsInCart()
            "total" -> myCart.calculateTotal()
            "remove" -> myCart.removeProduct(words[1].toInt())
            else -> println("Please enter a valid command from the menu")
        }
    }
    scanner.close()
}

fun AppMenu() {
    println("Hello shopper!! Welcome to my store.\n")
    println("Enter add [name] [price] to add a Product to the Shopping Cart.")
    println("Enter cart to display all Products in the Shopping Cart.")
    println("Enter remove [id] to remove a Product from the Shopping Cart.")
    println("Enter total to sum and return the total price of Products in the Shopping Cart.")
    println("Enter done to exit the Shopping Cart App,")
}


    