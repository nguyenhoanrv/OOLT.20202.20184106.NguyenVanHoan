package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media {
    
    private List<String> authors = new ArrayList<String>();
    private String content;
    private List<String> contentTokens = new ArrayList<String>();
    private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();
    
    // constructor
    public Book(int id, String title) {
        super(id, title);
    }
    
    public Book(int id, String title, String category) {
        super(id, title, category);
    }
    
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
    
    public Book(int id, String title, String category, List<String> authors) {
        this(id, title, category, authors, 0, "");
    }
    
    public Book(int id, String title, String category, List<String> authors, float cost, String content) {
        super(id, title, category, cost);
        this.authors = this.checkAuthors(authors);
        this.content = content;
        this.processContent();
    }

    // getter & setter
    public List<String> getAuthors() {
        return this.authors;
    }
    
    public int getNumberOfContentToken() {
        return this.contentTokens.size();
    }
    
    public Map<String, Integer> getWordFrequency() {
        return this.wordFrequency;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    
    // addAuthor()
    public void addAuthor(String authorName) {
        if (this.authors.contains(authorName)) {
            this.authors.add(authorName);
            System.out.println("Author " + authorName + " has been added to\"" + this.getTitle() + "\" 's Authors List!");
        } else {
            System.out.println("Cannot add author" + authorName + "to Authors List. " +
                    "Author's name already exists in \"" + this.getTitle() + "\" 's Authors List!");
        }
    }
    
    // removeAuthor()
    public void removeAuthor(String authorName) {
        if (this.authors.contains(authorName)) {
            this.authors.remove(authorName);
            System.out.println("Author " + authorName + " has been removed from \"" + this.getTitle() + "\" 's Authors List!");
        } else {
            System.out.println("Cannot remove author " + authorName + " from Authors List. " +
                    "Author's name does not exist in \"" + this.getTitle() + "\" 's Authors List!");
        }
    }
    
    // processContent()
    public void processContent() {
        // 1. get this.contentTokens
        // 1.1. get this.contentTokens in unsorted order
        String contentWithoutPunctuation = this.content.replace('.', ' ').trim().replaceAll(" +", " ");
        String[] tokens = contentWithoutPunctuation.split(" ");
        for (String token : tokens) {
            this.contentTokens.add(token);
        }
        // 1.2 sort this.contentTokens
        Collections.sort(this.contentTokens);
        // for (int i = 0; i < this.contentTokens.size(); i++) {
        //    System.out.println(this.contentTokens.get(i));
        // }
        
        // 2. get this.wordFrequency
        if (this.contentTokens.size() < 1) {
            return;
        }
        this.wordFrequency.put(this.contentTokens.get(0), 1);
        for (int i = 1; i < this.contentTokens.size(); i++) {
            String key = this.contentTokens.get(i);
            if (key.equals(this.contentTokens.get(i - 1))) {
                int oldValue = this.wordFrequency.get(key);
                this.wordFrequency.replace(key, oldValue, oldValue + 1);
                continue;
            }
            this.wordFrequency.put(key, 1);
        }
        // for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
        //     System.out.println("word: " + entry.getKey() + " - frequency: " + entry.getValue());    
        // }
    }
    
    // print()
    public void print() {
        System.out.printf("Book - %s - ", this.getTitle());
        
        System.out.print(this.authors.get(0));
        for (int i = 1; i < this.authors.size(); i++) {
            System.out.print(", " + this.authors.get(i));
        }
        
        System.out.printf(" - %s - %.2f$\n", this.getCategory(),this.getCost());
    }
    
    @Override
    public String toString() {
        StringBuffer bookStringBuffer = new StringBuffer();
        // id
        bookStringBuffer.append(this.getId() + " - ");
        // title
        bookStringBuffer.append(this.getTitle() + " - ");
        // author
        bookStringBuffer.append(this.authors.get(0));
        for (int i = 1; i < this.authors.size(); i++) {
            bookStringBuffer.append(", " + this.authors.get(i));
        }
        // category
        bookStringBuffer.append(this.getCategory() + " - ");
        // cost
        bookStringBuffer.append(this.getCost() + "\n");
        // contentTokens
        bookStringBuffer.append("Content tokens number: " + this.contentTokens.size() + "\n");
        // wordFrequency
        bookStringBuffer.append("Word frequency: \n");
        bookStringBuffer.append("Frequency | Word\n");
        wordFrequency.forEach((key, value) -> bookStringBuffer.append(String.format("%9d | %s\n", value, key)));
        return bookStringBuffer.toString();
    }
    
    // check authors list: no 2 same name
    public List<String> checkAuthors(List<String> inputtedAuthors) {
        List<String> authors = new ArrayList<String>();
        for (int i = 0; i < inputtedAuthors.size(); i++) {
            if (!authors.contains(inputtedAuthors.get(i))) {
                authors.add(inputtedAuthors.get(i));
            }
        }
        return authors;
    }
    
}