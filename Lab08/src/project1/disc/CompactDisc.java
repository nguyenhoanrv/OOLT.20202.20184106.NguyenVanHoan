package project1.disc;
import java.util.ArrayList;
import java.util.Iterator;

import project1.media.Playable;
import project1.media.Track;

public class CompactDisc extends Disc implements Playable{
	private ArrayList<Track> tracks =new ArrayList<Track>();
	public ArrayList<Track> getTracks() {
		return tracks;
	}
	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}
	
	public void addTrack(Track a) {
		if(!(tracks.contains(a))) {
			tracks.add(a);
		}
	}
	public void removeTrack(Track a) {
		if(!(tracks.contains(a))) {
			tracks.remove(a);
		}
	}
	public int getLength() {
		int total=0;
		for(int i=0; i<tracks.size(); i++) {
			total+=tracks.get(i).getLength();
		}
		return total;
	}
	
	public void play() {
		System.out.println("Title: " + this.getTitle());
		System.out.println("Caterogy: "+this.getCategory());
		for(Track a1 : tracks) {
			a1.play();
		}
	}
	public CompactDisc(String title, String category, float cost,ArrayList<Track> tracks ) {
		super(title, category, cost);
		this.tracks = tracks;
	}
	
	
}

	