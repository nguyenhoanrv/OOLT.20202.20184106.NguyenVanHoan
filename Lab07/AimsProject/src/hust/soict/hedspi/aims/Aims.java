/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.order.Order;
import static hust.soict.hedspi.aims.order.Order.MAX_LIMITTED_ORDERS;
import java.util.Scanner;
 class Aims {
    public static void showMenu() {
        System.out.println("Order Management Application: ");
        System.out.println("________________________________");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("________________________________");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }
    
    public static void main(String[] args) {
        Thread memCon = new Thread(new MemoryDaemon(), "Memory Observation");
        memCon.setDaemon(true);
        memCon.start();
        
        int choice;
        int n = 0;
        int orderId;
        int itemId = 0;
        Scanner keyboard = new Scanner(System.in);
        Order[] orderList = new Order[Order.MAX_LIMITTED_ORDERS];  
        
        do {            
            showMenu();
            choice = Integer.parseInt(keyboard.nextLine());
            switch(choice) {
                case 1: 
                    orderList[n++] = Order.getInstanceOrder();
                    System.out.println("Order created.");
                    break;
                case 2:
                    if(!Order.listOrder()) break; //if empty, break.                   
                    orderId = Order.getOrderId();                
                    if(orderId == 0) break; // we set 0 as exit id 
                        
                    orderList[orderId-1].addMedia(); //cuz print id is real id + 1
                    System.out.println("Add successful");
                    break;
                case 3:
                    if(!Order.listOrder()) break; //if empty, break.
                    orderId = Order.getOrderId();
                    if(orderId == 0) break; // we set 0 as exit id 
                    
                    if(orderList[orderId-1].listSize() == 0) {
                        System.out.println("Order is empty. Nothing to delete.");
                        break;
                    }
                    
                    orderList[orderId-1].printOrder();
                    
                    do {
                        System.out.println("Choose the item you want to delete: ");
                        if(keyboard.hasNextInt())
                            itemId = Integer.parseInt(keyboard.nextLine());
                        else 
                            keyboard.nextLine(); //throw input not numeric
                    } while(itemId < 1 || itemId > orderList[orderId-1].listSize());
                    
                    orderList[orderId-1].removeMedia(itemId-1); //cuz id count from 1 but array index from 0
                    System.out.println("Delete successful.");
                    break;
                case 4:
                    if(!Order.listOrder()) break; //if empty, break.
                    orderId = Order.getOrderId();
                    if(orderId == 0) break;
                    
                    orderList[orderId-1].printOrder();
                    break;
                default:
                    break;
            }
        } while (choice != 0);
        
        
        keyboard.close();
    }
}
