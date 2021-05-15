package hust.soict.hedspi.aims.order;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.utils.MyDate;


public class Order {
    
    public static final int MAX_NUMBER_ORDERED = 10;
    public static final int MAX_LIMITED_ORDERS = 5;
    private static final int PURCHASE_REMIND = 7;
    
    private static int nbOrders = 0;
    
    private int id;
    private List<Media> itemsOrdered;
    MyDate dateOrdered;
    
    // constructor
    public Order(int id) {
        if (nbOrders >= MAX_LIMITED_ORDERS) {
            System.out.println("\nThe Number of orders reached max! Cannot add more order.\n" +
                    "Please purchase your order first!\n");
        } else {
            this.id = id;
            this.dateOrdered = new MyDate();
            this.itemsOrdered = new ArrayList<Media>();
            nbOrders++;
            if (nbOrders == MAX_LIMITED_ORDERS) {
                System.out.println("\nThe Number of orders reached max! Please purchase your orders!\n");
            }
        }
    }
    
    // getter
    public List<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public static int getNbOrders() {
        return nbOrders;
    }

    // addMedia()
    public boolean addMedia(Media media) {
        if (this.itemsOrdered.size() == MAX_NUMBER_ORDERED) {
            System.out.println("\nThe number of items in order reached max! Cannot add \""+ media.getTitle() +"\" to Order.\n" +
                               "Please purchase or remove an item before adding more item to Order.\n");
        } else {
            this.itemsOrdered.add(media);
            int currentOrderSize = this.itemsOrdered.size();
            System.out.println("Item \"" + media.getTitle() + "\" has been added to Order! " +
                               "The number of items in order now is " + currentOrderSize + ".");
            if (currentOrderSize >= PURCHASE_REMIND && currentOrderSize < MAX_NUMBER_ORDERED) {
                System.out.println("The Order is almost full!");
            } else if (currentOrderSize == MAX_NUMBER_ORDERED) {
                System.out.println("The Order is full! Lets purchase your Order!");
            }
            return true;
        }
        return false;
    }

    public boolean addMedia(Media ... media) {
        int currentOrderSize = this.itemsOrdered.size();
        int spaceLeft = MAX_NUMBER_ORDERED - currentOrderSize;
        
        // System.out.println("space = " + spaceLeft);
        if (spaceLeft == 0) {
            System.out.println("The Order is full! Lets purchase your Order before adding more!");
        } else if (media.length > spaceLeft) {
            System.out.println("\nAdding too many items at the same time!\n" +
                    "The number of items now is " + currentOrderSize + "." +
                    "Please add a equal or smaller number of items than " + spaceLeft + ".\n");
        } else {
            for (int i = 0; i < media.length; i++) {
                addMedia(media[i]);
            }
            return true;
        }
        return false;
    }
    
    // removeMedia()
    public boolean removeMedia(Media media) {
        if (this.itemsOrdered.size() == 0) {
            System.out.println("\nYour Order is empty! Cannot remove anything from Order.\n" +
                               "Lets add an item to Order!\n");
        } else if (!this.itemsOrdered.contains(media)) {
            System.out.println("\nItem not found! Cannot remove \"" + media.getTitle() + "\" from Order.\n");
        } else {
            System.out.println("input id : " + media.getId());
            System.out.println("size : " + this.itemsOrdered.size());
            System.out.println(this.itemsOrdered.contains(media));
            
            // reset id of the item(s) behind the removed item
            int removeMediaId = this.itemsOrdered.indexOf(media);
            for (int i = removeMediaId + 1; i < this.itemsOrdered.size(); i++) {
                this.itemsOrdered.get(i).setId(i - 1);
            }
            // remove item
            this.itemsOrdered.remove(media);
            // inform the user
            System.out.println("Item \"" + media.getTitle() + "\" has been removed from Order! " +
                    "The number of items in order now is " + this.itemsOrdered.size() + ".");
            return true;
        }
        return false;
    }
    
    public boolean removeMedia(int mediaId) {
        return removeMedia(this.itemsOrdered.get(mediaId));
    }
    
    // totalCost()
    public float totalCost() {
        float total = 0;
        
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            total += this.itemsOrdered.get(i).getCost();
        }
        
        return total;
    }
    
    // getALuckyItem()
    public Media getALuckyItem() {
        int luckNum = getRandomNumber(0, this.itemsOrdered.size() - 1);
        // this.itemsOrdered.get(luckNum).setCost(0);
        return this.itemsOrdered.get(luckNum);
    }
    
    private int getRandomNumber(int min, int max) {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }
    
    // printOrder()
    public void printOrder() {
        if (this.itemsOrdered.size() == 0) {
            System.out.println("\nYour Order: is empty. Lets add something to your order!\n");
            return;
        }
        
        System.out.println("***********************************Order***********************************");
        System.out.println("Id: " + this.id);
        System.out.print("Date: ");
        dateOrdered.print();
        System.out.println("Ordered items:");
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            System.out.printf("%02d. ", this.itemsOrdered.get(i).getId() + 1);
            if (this.itemsOrdered.get(i) instanceof DigitalVideoDisc) {
                ((DigitalVideoDisc)this.itemsOrdered.get(i)).print();
            } else if (this.itemsOrdered.get(i) instanceof Book) {
                ((Book)this.itemsOrdered.get(i)).print();
            } else {
                this.itemsOrdered.get(i).print();
            }
        }
        System.out.println("Total cost: " + this.totalCost() + "$");
        System.out.println("***************************************************************************");
    }
    
}
