
import org.hamcrest.CoreMatchers.startsWith
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import com.github.stefanbirkner.systemlambda.SystemLambda.*
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.Disabled


class CartTest {
    private val testCart: Cart = Cart()

    @Test
    @DisplayName("Test calculateTotal")
    fun testCalculateTotal() {
        testCart.addProduct(Triple(1,"Milk", "1.99"))
        testCart.addProduct(Triple(2,"Cake", "5.99"))
        testCart.addProduct(Triple(3,"Banana","1.59"))
        assertEquals(9.57, testCart.calculateTotal())
    }

     @Test
     @DisplayName("Calculate total when cart is empty")
     fun testCalculateTotalCartIsEmpty() {
         val expectedTotal = 0.00
         assertEquals(expectedTotal, testCart.calculateTotal())
     }

    @Test
    @DisplayName("Test addProduct ")
    fun testAddProduct() {
        assertTrue(testCart.addProduct(Triple(4,"Banana","1.59")))
    }

    @Test
    @DisplayName("Test addProduct with out of stock item ")
    fun testAddProductThatIsOutOfStock() {
        assertFalse(testCart.addProduct(Triple(4,"bagel","1.59")))
    }

     @Test
     @DisplayName("Test addProduct with bad price format ")
     fun testAddProductPriceWrongFormat() {
         assertFalse(testCart.addProduct(Triple(4,"Banana","bbb")))
     }

    @Test
    @DisplayName("Remove product without giving the product number")
    @Disabled("????? How to test this case via Junit ?????")
    fun testRemoveProductWithoutProductNumber() {
        testCart.addProduct(Triple(1,"Milk", "1.99"))
        testCart.addProduct(Triple(2,"Cake", "5.99"))
        testCart.addProduct(Triple(3,"Banana","1.59"))

//        assertTrue(testCart.removeProduct(""))

    }

    @Test
    @DisplayName("Add product without giving the price")
    fun testAddProductWithNoPrice() {
        assertFalse(testCart.addProduct(Triple(4,"Banana","")))
    }

    @Test
    @DisplayName("Add out of stock product without giving the price")
    fun testAddOutOfStockProductWithNoPrice() {
        assertFalse(testCart.addProduct(Triple(4,"bagel","")))

    }
    @Test
    fun testRemoveProduct() {
        testCart.addProduct(Triple(3,"Banana","1.59"))
        assertTrue(testCart.removeProduct(3))
    }

     @Test
     fun testRemoveNonExistingProduct() {
         testCart.addProduct(Triple(3,"Banana","1.59"))
         assertFalse(testCart.removeProduct(9))
     }

     @Test
     fun testShowItemsInCart() {
         testCart.addProduct(Triple(1, "Milk", "1.99"))
         testCart.addProduct(Triple(2, "Cake", "5.99"))
         testCart.addProduct(Triple(3, "Banana", "1.59"))
         val output = tapSystemOut { testCart.showItemsInCart() }
         val expected = "Items in my cart\n1 - (Milk, 1.99)\n2 - (Cake, 5.99)\n3 - (Banana, 1.59)"
         assertEquals(expected, output.trim())
     }

     @Test
     fun testShowItemsInCartWhenCartIsEmpty() {
         val output = tapSystemOut { testCart.showItemsInCart() }
         val expected = ("Cart is empty")
         assertEquals(expected, output.trim())
     }
}

annotation class Before
