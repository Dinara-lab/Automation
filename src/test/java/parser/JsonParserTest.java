package parser;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import shop.Cart;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {
    private static Faker faker;
    private static String object;
    private static Gson gson;
    private static Cart cart;

    @BeforeAll
    static void beforeAll(){
        faker = new Faker();
        System.out.println("before all");
        String name = faker.name().fullName();
        cart = new Cart(name);
        gson = new Gson();
        object = gson.toJson(cart);
    }

    @Test
    public void writeToFile() throws IOException {

        try (FileWriter writer = new FileWriter("src/main/resources/" + cart.getCartName() + ".json")) {
            writer.write(object);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + cart.getCartName() + ".json"));
        Cart newCart = gson.fromJson(reader.readLine(), Cart.class);

        assertAll(()-> assertEquals(cart.getCartName(), newCart.getCartName(), "object' names are not the same"),
                  () -> assertEquals(cart.getRealItems(), newCart.getRealItems(), "items are not the same"),
                  () ->  assertEquals(cart.getTotalPrice(), newCart.getTotalPrice(), "price is not the same"));




}
}