package hust.soict.hedspi.aims.order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.book.Book;
import hust.soict.hedspi.aims.media.disc.CompactDisc;
import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;
import hust.soict.hedspi.exception.AddException;
import hust.soict.hedspi.exception.LuckyNumberException;
import hust.soict.hedspi.exception.PlayerException;
import hust.soict.hedspi.exception.RemoveException;

public class Order {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	int luckyNumber = -1;
	private String format_date;
	private float total = 0;
	private int idOrder = -1;
	private static final float sale = 0.2f;
	private static final float totalToSale = 200f;
	private static final float numberToSale = 5;
	
	public int getIdOrder() {
		return idOrder;
	}
	public void setDateOrdered() {
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	    this.format_date = myDateObj.format(myFormatObj);
	}
	public String getDateOrdered() {
		return this.format_date;
	}
	public Order() {
		this.setDateOrdered();
	}
	
	public ArrayList<Media> getItemsOrdered(){
		return this.itemsOrdered;
	}
	public void setTotalCost() {
		this.total = this.totalCost();
	}
	public float getTotalCost() {
		return this.total;
	}
	public void addMedia(Media media) throws AddException {
		if(itemsOrdered.contains(media)) {
			throw new AddException("Trung Media, khong the them vao Order");
		}
		else {
			itemsOrdered.add(media);
			java.util.Collections.sort(itemsOrdered);
			setTotalCost();
		}
	}
	public void removeMedia(Media media) {
		if(!itemsOrdered.contains(media)) {
			System.err.println("The media has ID is "+media.getId()+" is not exist");
			return;
		}
		else {
			itemsOrdered.remove(media);
			java.util.Collections.sort(itemsOrdered);
			System.out.println("The media has ID is "+media.getId()+" is exist");
		}
	}
	public int removeMedia(int id) throws Exception{
		int check_exist = 0;
		int target = 0;
		for(Media media: itemsOrdered) {
			if(id == media.getId()) {
				check_exist = 1;
				break;
			}
			target++;
		}
		if(check_exist == 0) {
			throw new RemoveException("Id Media vua nhap khong ton tai");
		}
		else {
			itemsOrdered.remove(target);
			java.util.Collections.sort(itemsOrdered);
			setTotalCost();
//			System.out.printf("The item has id %d has been Deleted\n",id);
			return 1;
		}
	}
	
	
	public float totalCost(){
		int i;
		float sum = 0,cost;
		for(i = 0; i< itemsOrdered.size();i++) {
			cost = itemsOrdered.get(i).getCost();
			sum = sum + cost;
		}
		return sum;
	}
	public void printOrdered() {
		float total=0;
//		java.util.Collections.sort(itemsOrdered);
		if(itemsOrdered.size() == 0) {
			System.out.println("itemsOrder is empty");
			return;
		}
		else {
		System.out.println("******************** ORDER *********************");
		System.out.printf("Date: %s\nOrder Items:\n", this.getDateOrdered());
		for(Media md : itemsOrdered) {
			if(md instanceof DigitalVideoDisc) {
				System.out.print(md.getId()+".");
				try {
					((DigitalVideoDisc)md).play();
				} catch (PlayerException e1) {
					System.out.println(e1.getMessage());
				}
			}
			else if (md instanceof CompactDisc) {
				System.out.print(md.getId()+".");
				try {
					((CompactDisc)md).play();
				} catch (PlayerException e1) {
					System.out.println(e1.getMessage());
				}
			}
			else{
				System.out.print(md.getId()+".");
				((Book)md).play();
			}
		}
		if(luckyNumber != -1) {
			System.out.printf("The title of disk free is: %d.%s\n",
					luckyNumber+1,itemsOrdered.get(luckyNumber).getTitle());
		}
		else {
			System.out.println("Lucky Number has not been selected");
		}
		total = this.totalCost();
		System.out.printf("Total cost: %.2f\n",total);
		System.out.println("************************************************");
		}
	}
	
	public boolean isEmpty() {
		if(itemsOrdered.size() == 0)
			return true;
		else return false;
	}
	public Media getALuckyItem() throws Exception{
		if(itemsOrdered.size() >= numberToSale && this.totalCost() >= totalToSale) {
			do {
				luckyNumber = 0 + (int)(Math.random()*(itemsOrdered.size()-1));
			} while (itemsOrdered.get(luckyNumber).getCost() > this.totalCost()*sale);
			return itemsOrdered.get(luckyNumber);
		}else {
			throw new LuckyNumberException("Khong du dieu kien nhan san pham mien phi\nSo luong SP >= " + numberToSale + "\nTotal >= " + totalToSale+"\nNeu duoc giam thi SP co gia khong qua 20% gia tri don hang");
		}		
	}
}