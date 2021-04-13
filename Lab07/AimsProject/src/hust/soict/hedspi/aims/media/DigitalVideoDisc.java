/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.media;
import java.util.Scanner;

public class DigitalVideoDisc extends Disc implements Playable{
    protected String director;

    public DigitalVideoDisc(String director) {
        this.director = director;
    }

    public DigitalVideoDisc(String director, String title) {
        super(title);
        this.director = director;
    }

    public DigitalVideoDisc(String director, String title, String category) {
        super(title, category);
        this.director = director;
    }

    public DigitalVideoDisc(String director, String title, String category, float cost) {
        super(title, category, cost);
        this.director = director;
    }

    public DigitalVideoDisc(String director, int length) {
        super(length);
        this.director = director;
    }

    public DigitalVideoDisc(String director, int length, String title) {
        super(length, title);
        this.director = director;
    }

    public DigitalVideoDisc(String director, int length, String title, String category) {
        super(length, title, category);
        this.director = director;
    }

    public DigitalVideoDisc(String director, int length, String title, String category, float cost) {
        super(length, title, category, cost);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }
    
    public static DigitalVideoDisc getDVD() {
        Scanner keyboard = new Scanner(System.in);
        String temp;
        String titleTemp,categoryTemp,directorTemp;
        float costTemp = 0;
        int lengthTemp = 0;
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
            
        System.out.println("Enter the director name (enter to skip): ");
                directorTemp = keyboard.nextLine();

        System.out.println("Enter the lenght of disc (enter to skip): ");
            temp = keyboard.nextLine();
            try {
                if(!temp.isEmpty())
                //newDisc.setLength(Integer.parseInt(temp));
                    lengthTemp = Integer.parseInt(temp);
                if(lengthTemp < 0) lengthTemp = 0; //not accept negative value.
            } catch (NumberFormatException e) {
                    System.err.println("Error occurs.");
            }
            
        DigitalVideoDisc newDVD = new DigitalVideoDisc(directorTemp, lengthTemp, titleTemp, categoryTemp, costTemp);
        
        System.out.println("Do you want to play CD(Y/n): ");
        temp = keyboard.nextLine();
        if(temp.equals("Y") || temp.equals("y")) 
            newDVD.play();
        
        return newDVD;
    }
    
    public boolean search(String title) {
        Scanner scanStr = new Scanner(title);
        String tmp;
        String lowerTitle = this.title.toLowerCase();
        while(scanStr.hasNext()) {
            tmp = scanStr.next().toLowerCase();
            if(!lowerTitle.contains(tmp))
                return false;
        }
        scanStr.close();
        
        return true;
    }
    
    @Override
    public void print() {
        if(getCost() == 0)
                System.out.printf("DVD - " + getTitle() + " - " + getCategory() +
                    " - " + getDirector() + " - %d: Free\n",getLength());
            else
                System.out.printf("DVD - " + getTitle() + " - " + getCategory() +
                    " - " + getDirector() + " - %d: %.2f $\n",getLength(), getCost());
    }
    
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}

