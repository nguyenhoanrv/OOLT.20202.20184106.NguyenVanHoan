/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;


public class Order {
    public static final int MAX_LIMITTED_ORDERS = 5;
    public static final int MAX_NUMBERS_ORDERED = 10;
    
    private static int nbOrders = 0;
    private float ttCost;
    private MyDate dateOrdered;
    private int id;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private Order() {
        dateOrdered = new MyDate();
        id = nbOrders - 1;
    }
   
    public static Order getInstanceOrder() { //refactor to limit the number of object
        if(nbOrders < MAX_LIMITTED_ORDERS)
        {
            nbOrders++;
            Order newOrder = new Order();
            return newOrder;
        }
        else {
            System.out.println("The numbers of orders is almost max.");
            return null;
        }         
    }
    
    public int listSize() {
        return itemsOrdered.size();
    }
    
    public static int size() {
        return nbOrders;
    }
    
    public void addMedia(Media item) {
        if(itemsOrdered.size() <= MAX_NUMBERS_ORDERED)
            itemsOrdered.add(item);
        else {
            System.out.println("Order is full. Cannot add more.");
            return;
        }
    }
    
    public void addMedia() {
        int type = 0;
        Scanner keyboard = new Scanner(System.in);
        if(itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("Order is full. Cannot add more.");
            return;
        }
    
        do {            
            System.out.println("Choose type of media you want to add : ");
            System.out.println("1. Book.");
            System.out.println("2. Compact Disc.");
            System.out.println("3. Digital Video Disc");
            if(keyboard.hasNextInt())
                type = Integer.parseInt(keyboard.nextLine());
            else 
                keyboard.nextLine(); //throw input not numeric.
        } while (type < 1 || type > 3);
        
        switch(type){
            case 1:
                Book newBook = Book.getBook();
                itemsOrdered.add(newBook);
                break;
            case 2:
                CompactDisc newCD = CompactDisc.getCD();
                itemsOrdered.add(newCD);
                break;
            case 3:
                DigitalVideoDisc newDVD = DigitalVideoDisc.getDVD();
                itemsOrdered.add(newDVD);
                break;
        }
    }
    
    public void removeMedia(Media item) {
        if(itemsOrdered.size() <= 0) {
            System.out.println("Empty order. Please add some items.");
            return;
        }
        itemsOrdered.remove(item);
    }
    
    public void removeMedia(int id) {
        if(itemsOrdered.size() <= 0) {
            System.out.println("Empty order. Please add some items.");
            return;
        }
        if(id < itemsOrdered.size())
                itemsOrdered.remove(id);

    }
    public float totalCost() {
        ttCost = 0;
        for(int i = 0; i < itemsOrdered.size(); i++){
            ttCost += itemsOrdered.get(i).getCost(); //this function can create precision number that affect the last result.
        }
        return ttCost;
    }
    
    public static int getOrderId() { //let user type the orderId
        Scanner keyboard = new Scanner(System.in);
        int orderId = 0;
        do {            
            System.out.println("Choose order id (press 0 to cancel): ");
            if(keyboard.hasNextInt())
                orderId = Integer.parseInt(keyboard.nextLine());
            } while (orderId < 0 || orderId > Order.size());
        
        return orderId;
    }
    
    public void printOrder() {
        System.out.println("***********************Order***********************");
        System.out.print("Date: ");
        dateOrdered.print();
        System.out.print("\nOrdered Items:\n");
        
        for(int i = 0; i < itemsOrdered.size(); i++) {
            System.out.printf("%d: ",i+1); //Count from 1
            itemsOrdered.get(i).print();
        }
        
        System.out.printf("Total cost: %.2f\n", totalCost());
        System.out.println("***************************************************");
    }
    public static boolean listOrder() { //print order and check if it is empty
        if (nbOrders == 0) {
            System.out.println("Order is not created. Please create an order.");
            return false;
        }
        System.out.println("Order list: ");
        for(int i = 0; i< nbOrders; i++)
            System.out.printf("Order %d\n", i+1);
        return true;
    }
    
}
