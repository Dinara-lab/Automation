package shop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class VirtualItemTest {

    private static Random random;


    @BeforeAll
    static void generateRandomNumber(){
        random = new Random();
        System.out.println("before all");
    }


    @Test
    void setSizeOnDisk() {
        double size = random.nextDouble();
        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setSizeOnDisk(size);
        assertEquals(size,virtualItem.getSizeOnDisk(), "size is not equal");
    }
}