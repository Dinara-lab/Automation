package shop;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    private static Faker faker;

    @BeforeAll
    static void generateName(){
        faker = new Faker();
        System.out.println("before all");
    }

   @Test
    void testGetCartName() {
        String name = faker.name().fullName();
        Cart cart = new Cart(name);
        assertEquals(name, cart.getCartName(), "names are not equal");
        System.out.println("test1");
    }

    @Test
    void testAddRealItem(){
        RealItem realItem = new RealItem();
        Cart cart = new Cart("");
        cart.addRealItem(realItem);
        assertTrue(cart.getRealItems().contains(realItem), "the item is not in the list");
        System.out.println("test2");
    }
}