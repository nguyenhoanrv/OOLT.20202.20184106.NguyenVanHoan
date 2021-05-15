package hust.soict.hedspi.aims.media;

public class Disc extends Media {

    private String director;
    private int length;
    
    // constructor
    public Disc(int id, String title) {
        super(id, title);
    }

    public Disc(int id, String title, String category) {
        super(id, title, category);
    }
    
    public Disc(int id, String title, String category, String director) {
        this(id, title, category, director, 0, 0);
    }
    
    public Disc(int id, String title, String category, String director, float cost) {
        this(id, title, category, director, cost, 0);
    }
    
    public Disc(int id, String title, String category, String director, float cost, int length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    // getter
    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }
    
    // compareTo()
    public int compareTo(Object obj) {
        if (obj instanceof Disc) {
            Disc tmp = (Disc) obj;
            if (this.getCost() > tmp.getCost()) { // sort by cost
                return 1;
            } else if (this.getCost() < tmp.getCost()) {
                return -1;
            } else if (this.length > tmp.length) {
                return 1;
            } else if (this.length < tmp.length) {
                return -1;
            } else {
                // this.cost == tmp.cost && this.length == tmp.length
                // -> sort by title
                return this.getTitle().compareTo(tmp.getTitle());
            }
        }
        return -1;
    }

}