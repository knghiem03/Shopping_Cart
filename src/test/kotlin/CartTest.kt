import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.provider.ValueSource

internal class CartTest {
    private val item1: Product = Product("001", "Banana", 1.59)
    private val item2: Product = Product("002", "Cheerios", 3.59)
    private val item3: Product = Product("003", "Ice cream", 5.59)

    @ParameterizedTest
    @ValueSource()
    fun addProductTest() {
    }


}