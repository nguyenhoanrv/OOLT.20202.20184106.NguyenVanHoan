/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.test.disc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class DiskTest {
    public static void main(String[] args) {
        Order anOrder = Order.getInstanceOrder();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Roger Allers", 87, "The Lion King", "Animation", 19.95f);
        anOrder.addMedia(dvd1);
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Geogre Lucas", 124, "Star Wars", "Science Fiction", 24.95f);
        anOrder.addMedia(dvd2);
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("John Musker", 90, "Aladdin", "Animation", 18.99f);
        anOrder.addMedia(dvd3);
        
        System.out.println(dvd1.search("King Pig"));
        System.out.println(dvd1.search("King Lion"));
        System.out.println(dvd1.search("King King"));

    }
}
