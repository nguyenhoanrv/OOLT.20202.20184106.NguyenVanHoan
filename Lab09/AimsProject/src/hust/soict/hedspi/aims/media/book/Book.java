package hust.soict.hedspi.aims.media.book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.disc.CompactDisc;
import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	private String content;
	private List<String> contentTokens = new ArrayList<String>();
	Map<String,Integer> wordFrequency = new TreeMap<String,Integer>();
	public Book(String title,String category,float cost) {
		super(title,category,cost);
	}
	
	public Book(String title, String category,float cost, List<String> authors) {
		super(title,category,cost);
		this.authors = authors;
	}
	
	public Book(int idBook, String titleBook, String categoryBook, float costBook,List<String> authors) {
		this(titleBook,categoryBook,costBook);
		this.id = idBook;
		this.authors = authors;
	}
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("The "+authorName+" is already exists in list");
			System.exit(0);
		}
		else {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("The "+authorName+" is not already exists in List");
			System.exit(0);
		}
		else {
			authors.remove(authorName);
			System.out.println("The Author has removed");
		}
	} 
	public void play() {
		System.out.println("Book title: " + this.getTitle());
		System.out.println("Book cost: "+ this.getCost());
		
	}
	// sap xep theo title cua Book
	public int compareTo(Media obj) {
		if((obj instanceof DigitalVideoDisc) || (obj instanceof CompactDisc))
			return -1;
		else {
			if(this.title.compareTo(((Book)obj).getTitle()) > 0)
					return 1;
			else if(this.title.compareTo(((Book)obj).getTitle()) < 0)
					return -1;
			else return 0;
		}
	}
	public void processContent() {
		String splitContent[];
		splitContent = this.content.split("\\s+");
		for (String word : splitContent) {
			contentTokens.add(word);
			if(wordFrequency.containsKey(word)) {
				wordFrequency.put(word,wordFrequency.get(word)+1);
			}
			else {
				wordFrequency.put(word, 1);
			}
		}
		
	}
	public String toString() {
		processContent();
		System.out.println("The content length is: "+contentTokens.size());
		System.out.println("The list of word in content are:");
		Set<String> keySet = wordFrequency.keySet();
		for(String word : keySet) {
			System.out.print(word+" - The frequency in content: ");
			System.out.println(wordFrequency.get(word));
		}
		return this.content;
	}
}
