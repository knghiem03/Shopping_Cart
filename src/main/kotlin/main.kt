

import java.util.Scanner
fun main() {
    AppMenu()
    val myCart = Cart()
    var itemNum: Int = 0
    val scanner = Scanner(System.`in`)
    while (true) {
        val words = scanner.nextLine().split("\\s+".toRegex()).toTypedArray()
        when(words[0]) {
            "done" -> {
                println("Thank you for shopping with us !")
                break
            }
            "add" -> {
                try {
                    myCart.addProduct(Triple(++itemNum, words[1], words[2]))
                }
                catch (e: java.lang.IndexOutOfBoundsException) {
                    --itemNum
                    println("Please re-enter the command, item and the price of the item")
                }
            }
            "cart" -> myCart.showItemsInCart()
            "total" -> myCart.calculateTotal()
            "remove" -> {
                try {
                    myCart.removeProduct(words[1].toInt())
                }
                catch (e: NumberFormatException) {
                    println("Please provide the item number to be remove from the cart")
                    println("Enter remove then item number")
                }
            }
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
    println("Enter done to exit the Shopping Cart App.")
}


    