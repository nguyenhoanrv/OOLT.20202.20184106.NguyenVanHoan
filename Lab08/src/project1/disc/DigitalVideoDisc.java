package project1.disc;
import project1.media.Media;
import project1.media.Playable;

import java.util.Scanner;

public class DigitalVideoDisc extends Media implements Playable{

	private String director;

	private int length;

	/**
	 * Constructor for DigitalVideoDisc
	 */
	public DigitalVideoDisc() {
		super();
	}

	/**
	 * @return Returns the director.
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director
	 *            The director to set.
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return Returns the length.
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length
	 *            The length to set.
	 */
	public void setLength(int length) {
		this.length = length;
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		System.out.println("Cost DVD: " + this.getCost());
		System.out.println("Category DVD " + this.getCategory());
		System.out.println("Director :" + this.getDirector());
	}
	

	public DigitalVideoDisc(String title, String category, float cost,String director, int length) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}

}