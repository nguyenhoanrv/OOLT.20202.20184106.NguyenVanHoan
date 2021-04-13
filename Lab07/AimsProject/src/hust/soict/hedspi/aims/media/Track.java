/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.media;

import java.util.Scanner;

public class Track implements Playable {
    private String title;
    private int length;

    public Track() {
    }

    public Track(String title) {
        this.title = title;
    }

    public Track(int length) {
        this.length = length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    
    public static Track getTrack() {
        Track newTrack;
        Scanner keyboard = new Scanner(System.in);
                
        String titleTemp, temp;
        int lenTemp = 0;
        System.out.println("Enter the track's title: ");
        titleTemp = keyboard.nextLine();
        System.out.println("Enter the track's length: ");
        temp = keyboard.nextLine();
        try {
            if(!temp.isEmpty())
                lenTemp = Integer.parseInt(temp);
            if(lenTemp < 0) lenTemp = 0; //not accept negative value.
        } catch (NumberFormatException e) {
            System.err.println("Error occurs.");
        }
        
        newTrack = new Track(titleTemp, lenTemp); //no need to close scanner now cuz may get error.
        return newTrack;
    }
    
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    
}
