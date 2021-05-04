package hust.soict.hedspi.aims.media.disc;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.book.Book;
import hust.soict.hedspi.exception.AddException;
import hust.soict.hedspi.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	private String playCd = "";
	public String getPlaying() {
		return playCd;
	}
	public String getArtist() {
		return artist;
	}
	public CompactDisc(int id,String title,String category,float cost,int length,String director,String artist) {
		super(id,title,category,cost,length,director);
		this.artist = artist;
	}
	public CompactDisc(int id,String title,String category,float cost,int length,String director,String artist,ArrayList<Track> tracks) {
		super(id,title,category,cost,length,director);
		this.artist = artist;
		this.tracks = tracks;
	}
	public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
		super(id,title,category,cost,director);
		this.artist = artist;
	}
	public int getLength() {
		int totalLength = 0;
		for(Track track: tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}	
	
	public void addTrack(Track track) throws AddException{
		if(tracks.contains(track) || track.getLength() == 0) {
			throw new AddException("Track bi loi khong them duoc vao CD"); 
		}
		else {
			tracks.add(track);
			this.length = this.getLength();
		}
	}
	
	public void removeTrack(Track track) {
		if(!tracks.contains(track)) {
			System.err.println("The track want to remove is not exist");
			return;
		}
		else {
			tracks.remove(track);
			this.length = this.getLength();
		}
	}
	
	public void play() throws PlayerException{
		if(this.getLength() > 0) {
			System.out.println("CompactDisc's name: "+this.getTitle());
			this.playCd += "CompactDisc's name: "+this.getTitle()+ "\n" + "---------------------------" + "\n";
			for(Track track : tracks) {
					track.play();
					this.playCd += track.playing;
			}
			this.playCd += "-------------------\n";
			this.playCd += "Length of CD: "+this.length+"\n"+"CD cost: "+ this.getCost()+"\n";
			System.out.println("Length of CD: "+this.length);
			System.out.println("CD cost: "+ this.getCost());
			
		}
		else {
			throw new PlayerException("CD length is non-positive");
		}
		
	}
	// sap xep theo so luong cac tracks cua CD, roi den tong do dai cua CD
	public int compareTo(Media obj) {
		if((obj instanceof Book))
			return 1;
		else if((obj instanceof DigitalVideoDisc))
			return -1;
		else {
			if(this.tracks.size() > ((CompactDisc)obj).tracks.size())
				return 1;
			else if(this.tracks.size() < ((CompactDisc)obj).tracks.size())
				return -1;
			else {
				if(this.length > ((CompactDisc)obj).length)
					return 1;
				else if(this.length < ((CompactDisc)obj).length)
					return -1;
				return 0;
			}
		}
		
	}

}
