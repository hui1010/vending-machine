package se.lexicon.group30;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DrinksTest {
    Drinks test1 = new Drinks("cola", 20, "pepsi zero", 250, true);
    Drinks test2 = new Drinks("latte", 30, "Starbucks", 70, false);

    @Test
    public void test_if_two_drinks_are_correctly_added() {
        assertEquals(1, test1.getProductId());
        assertEquals(2, test2.getProductId());
        assertEquals("cola", test1.getName());
        assertEquals(30, test2.getPrice());
        assertEquals("pepsi zero", test1.getDescription());
        assertEquals(70, test2.getVolume());
        assertFalse(test2.isBubbles());
    }

    @Test
    public void test_examine_method() {
        String str = "cola is 250 ml and costs 20 kr.";
        assertEquals(str, test1.examine());
    }

    @Test
    public void test_use_method() {
        String str = "You can take your latte, don't forget the change.";
        assertEquals(str, test2.use());
    }

    @After
    public void tearDown() throws Exception {
        Product.reset();
    }
}
