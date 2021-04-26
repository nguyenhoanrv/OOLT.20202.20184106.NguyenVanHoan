package project1.disc;
import project1.media.Media;

public class Disc extends Media{
	protected int length;
	protected int director;
	protected int getLength() {
		return length;
	}
	protected void setLength(int length) {
		this.length = length;
	}
	protected int getDirector() {
		return director;
	}
	protected void setDirector(int director) {
		this.director = director;
	}
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}
	
}
	
	