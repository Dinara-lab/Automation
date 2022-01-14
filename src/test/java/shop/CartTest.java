package shop;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    private static Faker faker;
    private static Random random;

    @BeforeAll
    static void generateName(){
        faker = new Faker();
        random = new Random();
    }

   @Test
   @Tag("fast")
    void testGetCartName() {
        String name = faker.name().fullName();
        Cart cart = new Cart(name);
        assertEquals(name, cart.getCartName(), "names are not equal");
    }

    @Test
    @Tag("fast")
    void testGetTotalPrice(){
        double TAX = 0.2;
        RealItem realItem = new RealItem();
        double price = random.nextDouble();

        realItem.setPrice(price);
        Cart cart = new Cart(faker.name().fullName());
        cart.addRealItem(realItem);

        double totalPrice = price + price * TAX;
        assertEquals(totalPrice, cart.getTotalPrice(), "price is different");

    }
}