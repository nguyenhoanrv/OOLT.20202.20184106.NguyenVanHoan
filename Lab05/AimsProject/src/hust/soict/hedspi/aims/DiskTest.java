package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.disc.*;
import hust.soict.hedspi.aims.order.*;

public class DiskTest {

	public static void main(String[] args) {
		Order anOrder = new Order();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",124,24.95f);
		
		anOrder.addDigitalVideoDisc(dvd1,dvd2);
		anOrder.print();
		
		System.out.println(dvd1.search("The Lion King"));
		
		System.out.println("Lucky item : ");
		anOrder.getItemlucky();
		System.out.println(" ListOrdered Update :");
		anOrder.print();
		
		
	}

}
