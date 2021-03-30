package hust.soict.hedspi.aims.order;
import hust.soict.hedspi.aims.disc.*;
import hust.soict.hedspi.aims.utils.*;



public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITED_ORDERS = 5;

	private DigitalVideoDisc [] itemsOrdered;
	private int qtyOrdered;
	public static int nbOrders = 0;
	private MyDate dateOrdered;


	public Order() {
		this.itemsOrdered =  new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
		this.dateOrdered = new MyDate();
        nbOrders++;
	}
	
	public static Order getInstance() {
		System.out.println(nbOrders);
        if (nbOrders < MAX_LIMITED_ORDERS) {
            Order order = new Order();
            return order;
        }
        System.out.println("Vuoi qua so luong order duoc phep tao (MAX = 5)!");
        return null;
    }
	
	public MyDate getDateOrdered() {
		return dateOrdered;
	}
	
	public void setDateOrdered(MyDate dateOrdered) {
		this.dateOrdered = dateOrdered;
	}
	
	public void addDigitalVideoDisc  (DigitalVideoDisc disc)  {
		if(disc != null) {
			if(qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered[qtyOrdered] = disc; 
				System.out.println("The disc " + disc.getTitle()+ " has been added!");
				qtyOrdered ++;
			} else {
				System.out.println("\nThe order is almost full! " + disc.getTitle() + " is not added!");
			}
		}
	}
	
//	public void addDigitalVideoDisc (DigitalVideoDisc [] dvdList) {
//			for( DigitalVideoDisc disc: dvdList) {
//				this.addDigitalVideoDisc(disc);
//			}
//		
//	}
	
	public void addDigitalVideoDisc( DigitalVideoDisc ...dvdList) {
		if(dvdList != null && dvdList.length > 0) {
			for( DigitalVideoDisc disc: dvdList) {
				this.addDigitalVideoDisc(disc);
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		this.addDigitalVideoDisc(dvd1);
		this.addDigitalVideoDisc(dvd2);
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if(disc != null) {
			for (int i = 0; i < qtyOrdered; i++) {
			    if (disc.getTitle() == itemsOrdered[i].getTitle()) {
			        while(i < qtyOrdered) {
			        	itemsOrdered[i] = itemsOrdered[i+1];
			        	i++;
			        }
			        System.out.println("\nThe disc has been deleted!");
			        break;
			    }
			}
		}
	}
	
	public float totalCost() {
		float sum = 0.0f;
		for(int i = 0; i < qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
		}
		return sum;
	}
	
	public void print() {
		System.out.println("****************Order******************");
		System.out.print("Date: ");
		dateOrdered.print();
		System.out.println("Ordered Items:");
		for(int i = 0; i < this.qtyOrdered; i++) {
			System.out.println((i+1) + ". DVD - " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength() + ":" + itemsOrdered[i].getCost() + "$");
		System.out.println("***************************************");
		}
	}
	public DigitalVideoDisc getItemlucky() {
    	int rand = (int) (Math.random() * (qtyOrdered + 1));
    	System.out.println(itemsOrdered[rand].getTitle() + " - " +itemsOrdered[rand].getCategory() + " - " +itemsOrdered[rand].getDirector() +" - "+ itemsOrdered[rand].getLength() + " - " +  itemsOrdered[rand].getCost() );
    	for ( int i = rand ; i < qtyOrdered ; i++) {
    		itemsOrdered[i] = itemsOrdered[i+1]; 
    	}
    	qtyOrdered--;
    	return itemsOrdered[rand];
    }
}
    

