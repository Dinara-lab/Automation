package shop;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RealItemTest {

     private static Random random;


    @BeforeAll
    static void generateRandomNumber(){
        random = new Random();
        System.out.println("before all");
    }

    @Test
    void getWeight() {

        double var = random.nextDouble();

        RealItem realItem = new RealItem();
        realItem.setWeight(var);
        assertEquals(var,realItem.getWeight(), "the weight is different");
    }




}