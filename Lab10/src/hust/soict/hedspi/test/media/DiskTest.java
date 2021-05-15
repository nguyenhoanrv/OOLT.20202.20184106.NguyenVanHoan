package hust.soict.hedspi.test.media;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.order.Order;

class DiskTest {

    // test DigitalVideoDisc.search()
    @Test
    void testDigitalVideoDiscSearch() {
        DigitalVideoDisc dvd = new DigitalVideoDisc(0, "Harry Potter and the Chamber of Secrets");
        assertEquals(true, dvd.search("Harry Potter and the Chamber of Secrets"), "DigitalVideoDisc.search(): wrong logic");
        assertEquals(true, dvd.search("harry potter and the chamber of secrets"), "DigitalVideoDisc.search(): wrong logic");
        assertEquals(true, dvd.search("Harry Potter"), "DigitalVideoDisc.search(): wrong logic");
        assertEquals(true, dvd.search("poTtEr hArry"), "DigitalVideoDisc.search(): wrong logic");
        assertEquals(true, dvd.search("thE Secrets of the CHamber"), "DigitalVideoDisc.search(): wrong logic");
        assertEquals(true, dvd.search("Chamber the Potter"), "DigitalVideoDisc.search(): wrong logic");
        assertEquals(true, dvd.search("The Chamber of Secrets and Harry Potter"), "DigitalVideoDisc.search(): wrong logic");
        assertEquals(false, dvd.search("Harry Poter"), "DigitalVideoDisc.search(): wrong logic");
        assertEquals(false, dvd.search("Hary Poter"), "DigitalVideoDisc.search(): wrong logic");
    }
    
    // test Order.getALuckyItem()
    @Test
    void testOrderGetALuckyItem() {
        final int NUMBER_OF_ITEM = 10;
        final float maxCost = 50.0f;
        final float minCost = 10.0f;
        
        // create random cost
        float[] costOfDvds = new float[NUMBER_OF_ITEM];
        Random rand = new Random();
        
        for (int i = 0; i < costOfDvds.length; i++) {
            float rd = minCost + rand.nextFloat() * (maxCost - minCost);
            costOfDvds[i] = round2DecimalPoints(rd);
        }
        
        // create order
        Order anOrder = new Order(0);
        String itemName = "tmp";
        
        for (int i = 0; i < NUMBER_OF_ITEM; i++) {
            String dvdName = itemName + (i + 1);
            anOrder.addMedia(new DigitalVideoDisc(0, dvdName, "", "", costOfDvds[i]));
        }
        
        Media luckyItem = anOrder.getALuckyItem();
        
        // assert
        assertTrue(anOrder.getItemsOrdered().contains(luckyItem), "Order.getALuckyItem(): return wrong item");
    }
    
    float round2DecimalPoints(float floatNumber) {
        return Math.round(floatNumber * 100.0f) / 100.0f;
    }
}