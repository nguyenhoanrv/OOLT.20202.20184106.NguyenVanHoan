package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    
    // constructor
    public DigitalVideoDisc(int id, String title) {
        super(id, title);
    }

    public DigitalVideoDisc(int id, String title, String category) {
        super(id, title, category);
    }
    
    public DigitalVideoDisc(int id, String title, String category, String director) {
        super(id, title, category, director);
    }
    
    public DigitalVideoDisc(int id, String title, String category, String director, float cost) {
        super(id, title, category, director, cost);
    }
    
    public DigitalVideoDisc(int id, String title, String category, String director, float cost, int length) {
        super(id, title, category, director, cost, length);
    }
    
    // search
    public boolean search(String title) {
        String[] tokensNeeded = title.trim().split(" ");
        String[] tokensSrc = this.getTitle().trim().split(" ");
        int tokenMatched = 0;
        
        for (int i = 0; i < tokensNeeded.length; i++) {
            for (int j = 0; j < tokensSrc.length; j++) {
                if (tokensNeeded[i].equalsIgnoreCase(tokensSrc[j])) {
                    tokenMatched++;
                    break;
                }
            }
        }
        
        if (tokenMatched == tokensNeeded.length) {
            return true;
        } else {
            return false;
        }
    }
    
    // isEqual()
    public boolean isEqualTitle(DigitalVideoDisc disc, boolean caseSensitive) {
        if (caseSensitive && this.getTitle().equals(disc.getTitle())) {
            return true;
        } else if (!caseSensitive && this.getTitle().equalsIgnoreCase(this.getTitle())) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isEqualAll(DigitalVideoDisc disc) {
        if (!this.getTitle().equals(disc.getTitle())) {
            return false;
        } else if (!this.getCategory().equals(disc.getCategory())) {
            return false;
        } else if (!this.getDirector().equals(disc.getDirector())) {
            return false;
        } else if (this.getLength() != disc.getLength()) {
            return false;
        } else if (this.getCost() != disc.getCost()) {
            return false;
        }
        return true;
    }
    
    // compareTo() inherits  from Disc
    
    // play()
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    
    // other
    public void print() {
        System.out.printf("DVD - %s - %s - %s - %d min - %.2f$\n",
                this.getTitle(), this.getCategory(), this.getDirector(), this.getLength(), this.getCost());
    }
    
    public static boolean swap(DigitalVideoDisc[] disc, int i, int j) {
        if ((i <= (disc.length - 1)) && (j <= (disc.length - 1))) {
            DigitalVideoDisc tmp = disc[i];
            disc[i] = disc[j];
            disc[j] = tmp;
            return true;
        }
        return false;
    }

}