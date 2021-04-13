/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Scanner;

public class Book extends Media{
    private ArrayList<String> authors = new ArrayList<>();

    public Book() {
    }

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
    
    public Book(String title, String category, ArrayList<String> authors) {
        super(title, category);
        this.authors = authors;
        //TODO: check author contition
    }
    
    public static Book getBook() {
        Scanner keyboard = new Scanner(System.in);
        String temp;
        String titleTemp,categoryTemp;
        float costTemp = 0;
        System.out.println("Enter the title:  ");
            //newBook.setTitle(keyboard.nextLine());
            titleTemp = keyboard.nextLine();

        System.out.println("Enter the category: ");
            //newBook.setCategory(keyboard.nextLine());
            categoryTemp = keyboard.nextLine();

        System.out.println("Enter the price: ");
            temp = keyboard.nextLine();
            try {
                if(!temp.isEmpty())
                //newBook.setCost(Float.parseFloat(temp));
                    costTemp = Float.parseFloat(temp);
                if(costTemp < 0) costTemp = 0; //not accept negative value
            } catch (NumberFormatException e) {
                System.err.println("Error occurs.");
            }
           
        Book newBook = new Book(titleTemp, categoryTemp, costTemp);
        do {            
                System.out.println("Enter the author name (enter to skip): ");
                temp = keyboard.nextLine();
                if(!temp.isEmpty())
                    newBook.addAuthor(temp);
                else 
                    return newBook;     
        } while (true);
    }
    
    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        for (int i = 0; i < authors.size(); i++) 
            if(authors.get(i).equals(authorName)) {
                System.out.println("Duplicated name.");
                return;
            }
        authors.add(authorName);
    }
    
    public void removeAuthor(String authorName) {
        for (int i = 0; i< authors.size(); i++)
            if(authors.get(i).equals(authorName)) {
                authors.remove(i);
                System.out.println("Name has been deleted.");
                return;
            }
    }
    
    @Override
    public void print() {
        StringBuilder authorsList = new StringBuilder();
        if(!authors.isEmpty()) {
            authorsList.append(authors.get(0));
            for(int i = 1; i < authors.size(); i++) {
                authorsList.append(",");
                authorsList.append(authors.get(i));
            }        
        }
        System.out.printf("Book - " + getTitle() + " - " + getCategory() + " - " + authorsList + " : %.2f $\n", getCost());
        
    }
}
