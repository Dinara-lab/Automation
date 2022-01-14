package parser;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.junit.jupiter.api.*;
import shop.Cart;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonParserTest {

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
    @Tag("fast")
    void testIfExists(){
        File file = new File("src/main/resources/" + cart.getCartName() + ".json");
        assertTrue(file.exists(), "file does not exist");
    }


    @Test
    @Tag("slow")
    public void writeToFile() throws IOException {

        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + cart.getCartName() + ".json"));
        Cart newCart = gson.fromJson(reader.readLine(), Cart.class);
        reader.close();

        assertAll(()-> assertEquals(cart.getCartName(), newCart.getCartName(), "object' names are not the same"),
                  () ->  assertEquals(cart.getTotalPrice(), newCart.getTotalPrice(), "price is not the same"));



}

    @Test
    @Tag("slow")
    public void readFromFile(){
        File file = new File("src/main/resources/" + cart.getCartName() + ".json");
        JsonParser jsonParser = new JsonParser();
        Cart newCartObject = jsonParser.readFromFile(file);

        assertAll(()-> assertEquals(newCartObject.getCartName(), cart.getCartName(), "object' names are not the same"),
                  () ->  assertEquals(newCartObject.getTotalPrice(), cart.getTotalPrice(), "price is not the same"));

}
   @Test
   @Disabled
   @Tag("exception")
   public void exceptionTest(){

        JsonParser jsonParser = new JsonParser();

        File file = new File("file1.txt");
        File file1 = new File("");
        File file2 = null;
        File file3 = new File("fileName.txt");
        File file4 = new File("file2.json");

       List<File> list = new ArrayList<>();
       list.add(file);
       list.add(file1);
       list.add(file2);
       list.add(file3);
       list.add(file4);

       for (File f: list) {
           assertThrows(Exception.class, ()-> jsonParser.readFromFile(f));
       }
    }

   @AfterAll
   static void removeFile(){

       File file = new File("src/main/resources/" + cart.getCartName() + ".json");

       if (file.exists()){
            file.delete();
       }

   }
}