package hust.soict.hedspi.aims.media.disc;

import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
	//constructor
	public DigitalVideoDisc(int id,String title,String category,float cost,int length,String director) {
		super(id,title,category,cost,length,director);
	}
	public DigitalVideoDisc(int id,String title,String category,float cost,String director) {
		super(id,title,category,cost,director);
	}
	
	//find out the corresponding disk of the current object contains the title
	public boolean search(String title) {
		int check = 0;
		title = title.toLowerCase().trim();
		String titleCurrentObj = this.title.toLowerCase().trim();
		String[] words = title.split("\\s");
		for(int i = 0;i< words.length;i++) {
			if(titleCurrentObj.contains(words[i]))
				check++;
		}
		if(check == words.length) 
			return true;
		else return false;
	}
	public void play() throws PlayerException {
		if(this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
			System.out.println("DVD cost: "+ this.getCost());
			String message = "Playing DVD: " + this.getTitle() +"\n"+"DVD length: " + this.getLength()+"\n"+"DVD cost: "+ this.getCost();
			JOptionPane.showMessageDialog(null, message, "Play DVD", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			throw new PlayerException("DVD length is non-positive");
		}
		
	}
	//sap xep theo cost cua DVD, roi den do dai cua DVD
	public int compareTo(Media obj) {
		if(obj instanceof DigitalVideoDisc) {
			if(this.cost > ((DigitalVideoDisc)obj).cost)
				return 1;
			else if(this.cost < ((DigitalVideoDisc)obj).cost)
				return -1;
			else {
				if(this.length > ((DigitalVideoDisc)obj).length)
					return 1;
				else if(this.length < ((DigitalVideoDisc)obj).length)
					return -1;
				return 0;
			}
		}
		else if(obj instanceof CompactDisc)
			return 1;
		else return -1;
	}
}