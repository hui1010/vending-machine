package se.lexicon.group30;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SnacksTest {
    Snacks test1 = new Snacks("chocolate", 30, "Marabou", 200, 1100);
    Snacks test2 = new Snacks("chips", 12, "OLW BBQ flavor", 50, 237);

    @Test
    public void test_if_two_snacks_are_correctly_created() {
        assertEquals(1, test1.getProductId());
        assertEquals(2, test2.getProductId());
        assertEquals(30, test1.getPrice());
        assertEquals(50, test2.getWeight());
        assertEquals(1100, test1.getCalorie());
    }


    @Test
    public void test_examine_method() {
        String str = "chocolate is 200 g, 1100 Kcal and costs 30 kr.";
        assertEquals(str, test1.examine());
    }

    @Test
    public void test_use_method() {
        String str = "You can take your chips, don't forget the change.";
        assertEquals(str, test2.use());
    }

    @After
    public void tearDown() throws Exception {
        Product.reset();
    }
}
