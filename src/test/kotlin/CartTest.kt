
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

//import kotlin.test.assertEquals.*
//import org.junit.jupiter.api.Test
//import kotlin.test.junit5.*

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
    @DisplayName("Test addProduct ")
    fun testAddProduct() {
        assertTrue(testCart.addProduct(Triple(4,"Banana","1.59")))
    }

     @Test
     @DisplayName("Test addProduct with bad price format ")
     fun testAddProductPriceWrongFormat() {
         assertFalse(testCart.addProduct(Triple(4,"Banana","bbb")))
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
    @Disabled
    fun testShowItemsInCart() {

    }
}