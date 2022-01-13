package parser;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.junit.jupiter.api.*;
import shop.Cart;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {
    private static Cart cart;


    @BeforeAll
    static void beforeAll(){
        Faker faker = new Faker();
        String name = faker.name().fullName();
        cart = new Cart(name);
        JsonParser jsonParser = new JsonParser();
        jsonParser.writeToFile(cart);


    }
    @Test
    void testIfExists(){
        File file = new File("src/main/resources/" + cart.getCartName() + ".json");
        assertTrue(file.exists(), "file does not exist");
    }


    @Test
    public void writeToFile() throws IOException {

        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + cart.getCartName() + ".json"));
        Cart newCart = gson.fromJson(reader.readLine(), Cart.class);

        assertAll(()-> assertEquals(cart.getCartName(), newCart.getCartName(), "object' names are not the same"),
                  () -> assertEquals(cart.getRealItems(), newCart.getRealItems(), "items are not the same"),
                  () ->  assertEquals(cart.getTotalPrice(), newCart.getTotalPrice(), "price is not the same"));



}

    @Test
    //@Disabled
    public void readFromFile(){
        File file = new File("src/main/resources/" + cart.getCartName() + ".json");
        JsonParser jsonParser = new JsonParser();
        Cart newCartObject = jsonParser.readFromFile(file);

        assertAll(()-> assertEquals(newCartObject.getCartName(), cart.getCartName(), "object' names are not the same"),
                () -> assertEquals(newCartObject.getRealItems(), cart.getRealItems(), "items are not the same"),
                () ->  assertEquals(newCartObject.getTotalPrice(), cart.getTotalPrice(), "price is not the same"));

        System.out.println(file.getName());



}

   @AfterAll
   static void removeFile(){

       File file = new File("src/main/resources/" + cart.getCartName() + ".json");
       String name = file.getName();

       if (file.exists()){
           file.delete();
       }
       System.out.println("file with the name " + name + "was deleted");
   }
}