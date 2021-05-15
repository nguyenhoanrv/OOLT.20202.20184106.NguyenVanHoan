package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.order.*;

public class Aims {
    
    private static List<Order> orders = new ArrayList<Order>();

    public static List<Order> getOrders() {
        return orders;
    }

    // 1. Create new order
    public void createOrder() {
        int newOrderId = orders.size();
        if (newOrderId < Order.MAX_LIMITED_ORDERS) {
            orders.add(new Order(newOrderId));
            System.out.println("\nCreating new order with id = " + newOrderId + " succeeded!");
        } else {
            System.out.println("\nThe number of orders has reached max! Please purchase your orders before continue.");
        }
    }
    
    // 2. Add item
    public static void addItemToOrder(int orderId, Media newMedia) {
        // check if any order has been create
        if (orderId == -1) {
            return;
        }
        
        // add item to order 
        orders.get(orderId).addMedia(newMedia);
    }
    
    // 3. Delete item by id
    public static void deleteItemById(int orderId, int itemId) {
        // check if any order has been create
        if (orderId == -1) {
            return;
        }
        
        // delete item by id
        orders.get(orderId).removeMedia(itemId);
    }
    
}