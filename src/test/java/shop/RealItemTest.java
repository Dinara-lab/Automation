package shop;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class RealItemTest {

     private static Random random;


    @BeforeAll
    static void generateRandomNumber(){
        random = new Random();
    }

    @Test
    @Tag("fast")
    void getWeight() {

        double var = random.nextDouble();

        RealItem realItem = new RealItem();
        realItem.setWeight(var);
        assertEquals(var,realItem.getWeight(), "the weight is different");
    }




}