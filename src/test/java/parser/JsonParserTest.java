package parser;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.Cart;
import java.io.FileWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {

    @Test
    public void shouldWriteToFile() throws IOException {
        Cart cart = new Cart("nameOfCart");
        Gson gson = new Gson();
        FileWriter writer = new FileWriter("src/main/resources/" + cart.getCartName() + ".json");
        writer.write(gson.toJson(cart));

        Assertions.assertFalse(cart.getCartName().isEmpty());
        System.out.println("Object cart was successfully created");
        assertNotNull(writer);
        System.out.println("File is not null");


    }
}