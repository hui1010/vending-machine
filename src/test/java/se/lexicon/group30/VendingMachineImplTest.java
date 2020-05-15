package se.lexicon.group30;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineImplTest {
    VendingMachineImpl implTest = new VendingMachineImpl(new Product[0]);
    Product cola = new Drinks("cola", 19, "pepsi zero", 250, true);
    Product chocolate = new Snacks("chocolate", 30, "Marabou", 200, 1100);
    Product salad = new Foods("salad", 45, "vegetarian bean tofu salad", false, true, 350);

    @Before
    public void setUp() throws Exception {
        implTest.addProducts(cola);
        implTest.addProducts(chocolate);
        implTest.addProducts(salad);
    }

    @Test
    public void return_true_if_three_product_are_successfully_added() {
        assertTrue(implTest.addProducts(cola));
        assertTrue(implTest.addProducts(chocolate));
        assertTrue(implTest.addProducts(salad));
    }

    @Test
    public void test_add_currency_method() {
        implTest.addCurrency(20);
        assertEquals(20, implTest.getBalance());
        //if you put in money that doesn't exist in the enum, the balance will not be updated
        implTest.addCurrency(70);
        assertEquals(20, implTest.getBalance());
    }

    @Test //request method
    public void given_a_product_Number_will_return_that_product() {
        //check if they get the supposed id
        assertEquals(1, cola.getProductId());
        assertEquals(2,chocolate.getProductId());
        assertEquals(3, salad.getProductId());

        //check if I can get the corresponding product by calling the id
        //also need to make sure I have enough money
        implTest.addCurrency(50);
        assertEquals("cola", implTest.request(1).getName());
        assertEquals("Marabou", implTest.request(2).getDescription());

        //check if the balance is updated
        int expectedPrice = 50 - cola.getPrice() - chocolate.getPrice();
        assertEquals(expectedPrice, implTest.getBalance());
        //now the balance should be 0 and I should not be able to buy more
        assertEquals(null, implTest.request(3));

        //test the endSession method as well
        assertEquals(1, implTest.endSession());
        assertEquals(0, implTest.getBalance());
    }

    @Test
    public void test_getDescription_method() {
        assertEquals("Marabou", implTest.getDescription(2));
        assertEquals("vegetarian bean tofu salad", implTest.getDescription(3));
    }

    @Test
    public void test_getProduct_method() {

        assertEquals("1. cola", implTest.getProducts()[0]);
        assertEquals("2. chocolate", implTest.getProducts()[1]);
        assertEquals("3. salad", implTest.getProducts()[2]);

    }

    @After
    public void tearDown() throws Exception {
        Product.reset();
        implTest.setBalance(0);
    }
}
