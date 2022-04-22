

import java.util.Scanner
fun main() {
    AppMenu()
//    val myProduct = Product()
    val myCart = Cart()
    var itemNum: Int = 0
    val scanner = Scanner(System.`in`)
    val validList = arrayOf("add","cart","remove","total","done")
    while (true) {
        val inputLine = scanner.nextLine()
        println(inputLine)
        val words = inputLine.split(" ")
        if (!validList.contains(words[0])) {
            println("Please enter a valid command from the menu")
        }
        else if (words[0] == "done") {
            println("Thank you for shopping with us !")
            break
        }
        else if (words[0] == "add") {
            itemNum += 1
            val product = Triple( itemNum, words[1], words[2] )
            myCart.addProduct(Triple( itemNum, words[1], words[2] ))
        }
        else if (words[0] == "cart")
            myCart.showItemsInCart()
        else if (words[0] == "total")
            myCart.calculateTotal()
        else if (words[0] == "remove")
            myCart.removeProduct(words[1].toInt())
    }
    scanner.close()
}

fun AppMenu() {
    println("Hello shopper!! Welcome to my store.")
    println("")
    println("Enter add [name] [price] to add a Product to the Shopping Cart.")
    println("Enter cart to display all Products in the Shopping Cart.")
    println("Enter remove [id] to remove a Product from the Shopping Cart.")
    println("Enter total to sum and return the total price of Products in the Shopping Cart.")
    println("Enter done to exit the Shopping Cart App,")
}


    