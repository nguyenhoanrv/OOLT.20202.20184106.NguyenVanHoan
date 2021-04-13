/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims;


public class MemoryDaemon implements Runnable {
    long memoryUsed = 0;
    @Override
    public void run() {
        Runtime rt = Runtime.getRuntime();
        long used;
        
        while(true) {
            used = rt.totalMemory() - rt.freeMemory();
            if(used != memoryUsed) {
                System.out.println("\tMemory used = " + used);
                memoryUsed = used;
            }
        }
    }
}
