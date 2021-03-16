package hoan.com;

public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;

	private DigitalVideoDisc [] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private static int qtyOrdered;
	
	public void addDigitalVideoDisc  (DigitalVideoDisc disc)  {
		if(qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc; 
			System.out.println("The disc has been added!");
			qtyOrdered ++;
		} else {
			System.out.println("The order is almost full!");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
		    if (disc.getTitle() == itemsOrdered[i].getTitle()) {
		        while(i < qtyOrdered) {
		        	itemsOrdered[i] = itemsOrdered[i+1];
		        	i++;
		        }
		        System.out.println("The disc has been deleted!a");
		        break;
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
}
