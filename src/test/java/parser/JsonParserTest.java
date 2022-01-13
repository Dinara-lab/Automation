package parser;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import shop.Cart;
import java.io.FileWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {
    private static Faker faker;

    @BeforeAll
    static void generateName(){
        faker = new Faker();
        System.out.println("before all");
    }

    @Test
    public void writeToFile(){
        String name = faker.name().fullName();
        Cart cart = new Cart(name);
        Gson gson = new Gson();
        String object = gson.toJson(cart);
        Cart newCart = gson.fromJson(object, Cart.class);
        assertAll(()-> assertEquals(cart.getCartName(), newCart.getCartName(), "object' names are not the same"),
                  () -> assertEquals(cart.getRealItems(), newCart.getRealItems(), "items are not the same"),
                  () ->  assertEquals(cart.getTotalPrice(), newCart.getTotalPrice(), "price is not the same"));



    }
}