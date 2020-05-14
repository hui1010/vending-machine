package se.lexicon.group30;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class FoodsTest {
    Foods test1 = new Foods("sandwich", 40, "chicken sandwich", true, false, 300);
    Drinks test = new Drinks ("mineral water", 20, "Loka", 150, true);
    Foods test2 = new Foods("salad", 45, "vegetarian bean tofu salad", false, true, 350);

    @Test
    public void test_if_two_foods_are_correctly_added() {
        assertEquals(1, test1.getProductId());
        assertEquals(3, test2.getProductId());
        assertEquals(2, test.getProductId());
        //test the setter for nuts
        test1.setNuts(true);
        assertTrue(test1.isNuts());
        assertFalse(test2.isMeat());
        assertEquals("chicken sandwich", test1.getDescription());
    }

    @Test
    public void test_examine_method() {
        String str = "sandwich is 300 g, contains meat and no nuts, and costs 40 kr.";
        assertEquals(str, test1.examine());
    }

    @Test
    public void test_use_method() {
        String str = "You can take your salad, don't forget the change";
        assertEquals(str, test2.use());
    }

    @After
    public void tearDown() throws Exception {
        Product.reset();
    }
}
