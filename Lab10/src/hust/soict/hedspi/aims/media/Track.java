package hust.soict.hedspi.aims.media;

/**
* class Track models a track on a Compact disc
*/
public class Track implements Playable, Comparable<Object> {
    
    private String title;
    private int length;
    
    // constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // getter
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    
    // isEqualTittle()
    public boolean isEqualAll(Track aTrack) {
        if (this.title.equals(aTrack.getTitle())) {
            if (this.length == aTrack.length) {
                return true;
            }
        }
        return false;
    }
    
    // equals()
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track tmp = (Track) obj;
            if (this.getTitle() == tmp.getTitle() && this.getLength() == tmp.getLength()) {
                return true;
            }
        }
        return false;
    }
    
    // compareTo()
    public int compareTo(Object obj) {
        if (obj instanceof Track) {
            Track tmp = (Track) obj;
            if (this.title.equals(tmp.title)) {
                return 1;
            }
        }
        return -1;
    }
    
    // play()
    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

}