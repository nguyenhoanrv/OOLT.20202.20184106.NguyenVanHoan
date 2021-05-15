package hust.soict.hedspi.test.media;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
// import java.util.Iterator;


import hust.soict.hedspi.aims.media.*;

class TestMediaCompareTo {

    @Test
    void testDiscCompareTo() {
        DigitalVideoDisc dvd0 = new DigitalVideoDisc(0, "a", "", "", 2.0f, 3);
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "b", "", "", 1.0f, 5);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "c", "", "", 3.0f, 1);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "d", "", "", 6.0f, 6);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "e", "", "", 5.0f, 2);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc(5, "f", "", "", 4.0f, 4);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc(6, "a", "", "", 4.0f, 6);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc(7, "b", "", "", 0.5f, 2);
        DigitalVideoDisc dvd8 = new DigitalVideoDisc(8, "c", "", "", 5.0f, 5);
        DigitalVideoDisc dvd9 = new DigitalVideoDisc(9, "g", "", "", 2.5f, 7);
        DigitalVideoDisc[] dvds = {dvd0, dvd1, dvd2, dvd3, dvd4, dvd5, dvd6, dvd7, dvd8, dvd9};
        
        List<DigitalVideoDisc> collection = new ArrayList<DigitalVideoDisc>();
        
        // Add the DVD objects to the ArrayList
        for (DigitalVideoDisc dvd : dvds) {
            collection.add(dvd);
        }
        
        // Iterate through the ArrayList and output their titles in unsorted order
        // Iterator<DigitalVideoDisc> iterator = collection.iterator();
        // System.out.println("-----------------------------------");
        // System.out.println("The DVDs currently in the order are:");
        // while (iterator.hasNext()) {
        //     DigitalVideoDisc tmp = (DigitalVideoDisc)iterator.next();
        //     System.out.println(tmp.getTitle() + " " + tmp.getCost());
        // }
        
        // Sort the collection of DVDs - based on the compareTo() method
         Collections.sort((List<DigitalVideoDisc>)collection);
        
        // Iterate through the ArrayList and output their titles in unsorted order
        // iterator = collection.iterator();
        // System.out.println("-----------------------------------");
        // System.out.println("The DVDs in sorted order are:"); 
        // while (iterator.hasNext()) {
        //     DigitalVideoDisc tmp = (DigitalVideoDisc)iterator.next();
        //     System.out.println(tmp.getTitle() + " " + tmp.getCost());
        // }
        // System.out.println("-----------------------------------");
        
        boolean correctSort = true;
        for (int i = 0; i < collection.size() - 1; i++) {
            DigitalVideoDisc tmp1 = collection.get(i);
            for (int j = i + 1; j < collection.size(); j++) {
                DigitalVideoDisc tmp2 = collection.get(j);
                if (tmp1.getCost() <= tmp2.getCost()) {
                    continue;
                }
                // System.out.println("wrong cost");
                if (tmp1.getLength() <= tmp2.getLength()) {
                    continue;
                }
                // System.out.println("wrong len");
                if (tmp1.getTitle().compareTo(tmp2.getTitle()) <= 0) {
                    continue;
                }
                // System.out.println("wrong title");
                correctSort = false;
            }
            if (!correctSort) {
                break;
            }
        }
        assertTrue(correctSort, "Disc.compareTo(): wrong logic");
    }
    
    @Test
    void testCdCompareTo() {
        Track t = new Track("" , 1);
        
        List<Track> trackList1 = new ArrayList<Track>(); trackList1.add(t);
        List<Track> trackList2 = new ArrayList<Track>(); trackList2.add(t); trackList2.add(t);
        List<Track> trackList3 = new ArrayList<Track>(); trackList3.add(t); trackList3.add(t); trackList3.add(t);
        
        CompactDisc cd0 = new CompactDisc(0, "a", "", "", 2.0f, "", trackList1);
        CompactDisc cd1 = new CompactDisc(1, "b", "", "", 1.0f, "", trackList2);
        CompactDisc cd2 = new CompactDisc(2, "c", "", "", 3.0f, "", trackList3);
        CompactDisc cd3 = new CompactDisc(3, "d", "", "", 6.0f, "", trackList3);
        CompactDisc cd4 = new CompactDisc(4, "e", "", "", 5.0f, "", trackList2);
        CompactDisc cd5 = new CompactDisc(5, "f", "", "", 4.0f, "", trackList1);
        CompactDisc cd6 = new CompactDisc(6, "a", "", "", 4.0f, "", trackList2);
        CompactDisc cd7 = new CompactDisc(7, "b", "", "", 0.5f, "", trackList3);
        CompactDisc cd8 = new CompactDisc(8, "c", "", "", 5.0f, "", trackList2);
        CompactDisc cd9 = new CompactDisc(9, "g", "", "", 2.5f, "", trackList3);
        CompactDisc[] cds = {cd0, cd1, cd2, cd3, cd4, cd5, cd6, cd7, cd8, cd9};
        
        List<CompactDisc> collection = new ArrayList<CompactDisc>();
        
        // Add the DVD objects to the ArrayList
        for (CompactDisc cd : cds) {
            collection.add(cd);
        }
        
        Collections.sort((List<CompactDisc>)collection);
        
        boolean correctSort = true;
        for (int i = 0; i < collection.size() - 1; i++) {
            CompactDisc tmp1 = collection.get(i);
            for (int j = i + 1; j < collection.size(); j++) {
                CompactDisc tmp2 = collection.get(j);
                if (tmp1.getNumberOfTrack() <= tmp2.getNumberOfTrack()) {
                    continue;
                }
                if (tmp1.getCost() <= tmp2.getCost()) {
                    continue;
                }
                if (tmp1.getTitle().compareTo(tmp2.getTitle()) <= 0) {
                    continue;
                }
                correctSort = false;
                break;
            }
            if (!correctSort) {
                break;
            }
        }
        assertTrue(correctSort, "CompactDisc.compareTo(): wrong logic");
    }

}
