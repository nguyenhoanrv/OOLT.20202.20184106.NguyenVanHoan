package hust.soict.hedspi.aims.media.disc;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.exception.InputException;

public class Disc extends Media{
	protected int length = 0;
	protected String director;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return this.length;
	}
	public void setLength(String lengthStr) throws Exception{
		try {
			int length = Integer.parseInt(lengthStr);
			if(length <= 0) throw new InputException("Ban nhap sai. Length DVD phai la so duong");
			this.length = length;
		} catch (Exception e1){
			throw new InputException("Ban nhap sai dinh dang 'length DVD' (phai la so) ");
		}
	}
	public Disc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost);
		this.length = length;
		this.director = director;
	}
	public Disc(int id, String title, String category, float cost, String director) {
		super(id, title, category, cost);
		this.director = director;
	}
	
}
