package project1.media;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Book extends Media {
	
	private ArrayList<String> authors = new ArrayList<String>();
	
	public ArrayList<String> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
		if(!(authors.contains(authorName))) {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		if((authors.contains(authorName))) {
			authors.remove(authorName);
		}
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String category, float cost,ArrayList<String> authors ) {
		super(title, category, cost);
		this.authors = authors;
	}
	public void play() {
		System.out.println("Playing Book: " + this.getTitle());
		System.out.println("Authors :" + this.getAuthors());
		System.out.println("Category :" + this.getCategory());
		System.out.println("Cost :" + this.getCost());
	}

}
