package hoan.com;

public class Aims {
	public static void main(String[] args) {
		Order anOrder = new Order();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		anOrder.addDigitalVideoDisc(dvd3);

//		DigitalVideoDisc dvdList[] = {dvd1, dvd2, dvd3, dvd1, dvd2, dvd3, dvd1, dvd1};
		anOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3, dvd1, dvd2, dvd3, dvd1, dvd1);
		System.out.print("\nTotal cost is: ");
		System.out.println(anOrder.totalCost());
		
		Order order2 = Order.getInstance();
		order2.addDigitalVideoDisc(dvd1, dvd2, dvd3);
		Order order3 = Order.getInstance();
		order3.addDigitalVideoDisc(dvd1, dvd2, dvd3);
		Order order4 = Order.getInstance();
		order4.addDigitalVideoDisc(dvd1, dvd2, dvd3);
		Order order5 = Order.getInstance();
		order5.addDigitalVideoDisc(dvd1, dvd2, dvd3);
		Order order6 = Order.getInstance();
		order6.addDigitalVideoDisc(dvd1, dvd2, dvd3, dvd3);
		
		anOrder.print();
		order2.print();
		System.out.println("cai 6");
		order5.print();
		
		
	}
}
