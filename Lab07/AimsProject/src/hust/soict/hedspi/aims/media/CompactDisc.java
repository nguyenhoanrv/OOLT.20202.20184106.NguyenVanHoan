/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Scanner;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String artist) {
        this.artist = artist;
    }

    public CompactDisc(String artist, String title) {
        super(title);
        this.artist = artist;
    }

    public CompactDisc(String artist, String title, String category) {
        super(title, category);
        this.artist = artist;
    }

    public CompactDisc(String artist, String title, String category, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public void addTrack(Track track) {
        for(int i = 0; i < tracks.size(); i++)
            if(tracks.get(i).equals(track)) {
                System.out.println("Duplicated track.");
                return;
            }
        
        tracks.add(track);
        System.out.println("Add track successful.");
    }
    
    public void removeTrack(Track track) {
        for(int i = 0; i < tracks.size(); i++)
            if(tracks.get(i).equals(track)) {
                tracks.remove(track);
                System.out.println("Remove track successful.");
                return;
            }
        
        System.out.println("Track does not exist.");       
    }
    
    @Override
    public int getLength() {
        int cdLen = 0;
        for(int i = 0; i < tracks.size(); i++)
            cdLen += tracks.get(i).getLength();
        
        return cdLen;
    }
    
    public static CompactDisc getCD() {
        Scanner keyboard = new Scanner(System.in);
        String temp;
        String titleTemp,categoryTemp,artistTemp;
        float costTemp = 0;
        int lengthTemp = 0;
        Track trackTemp ;
        System.out.println("Enter the title:  ");
            titleTemp = keyboard.nextLine();
            //newDisc.setTitle(keyboard.nextLine());

        System.out.println("Enter the category: ");
            categoryTemp = keyboard.nextLine();
            //newDisc.setCategory(keyboard.nextLine());

        System.out.println("Enter the price: ");
            temp = keyboard.nextLine();
            try {
                if(!temp.isEmpty())
                    costTemp = Float.parseFloat(temp);
                if(costTemp < 0) costTemp = 0;
                //newDisc.setCost(Float.parseFloat(temp));   
            } catch (NumberFormatException e) {
                    System.err.println("Error occurs.");
            }        
            
        System.out.println("Enter the artist name (enter to skip): ");
                artistTemp = keyboard.nextLine();
            
        CompactDisc newCD = new CompactDisc(artistTemp, titleTemp, categoryTemp, costTemp);
        //from now will be track info
        do {            
                System.out.println("Do you want to add track(Y/n): ");
                temp = keyboard.nextLine();
                if(temp.equals("Y") || temp.equals("y")) {
                    newCD.addTrack(Track.getTrack());
                }
                else 
                    break;
        } while (true);
        
        System.out.println("Do you want to play CD(Y/n): ");
        temp = keyboard.nextLine();
        if(temp.equals("Y") || temp.equals("y")) 
            newCD.play();
        
        return newCD;
    }
    
    @Override
    public void play() {
        System.out.println("Title: " + getTitle());
        System.out.println("Artist : " + getArtist());
        System.out.println("Length : " + getLength());
        if(tracks.isEmpty()) 
            System.out.println("No track.");
        else
            for(int i = 0; i< tracks.size(); i++)
                tracks.get(i).play();
    }
}
