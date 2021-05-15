package hust.soict.hedspi.aims.media;

public abstract class Media implements Comparable<Object> {

    private int id;
    private String title;
    private String category;
    private float cost;
    
    // constructor
    public Media(int id, String title) {
        this(id, title, "", 0);
    }
    
    public Media(int id, String title, String category) {
        this(id, title, category, 0);
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // getter
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }
    
    // equals()
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Media) {
            Media tmp = (Media) obj;
            return this.id == tmp.id;
        }
        return false;
    }
    
    // compareTo()
    @Override
    public int compareTo(Object obj) {
        if (obj instanceof Media) {
            Media tmp = (Media) obj;
            if (this.cost > tmp.cost) { // sort by cost
                return 1;
            } else if (this.cost < tmp.cost) {
                return -1;
            } else { // this.cost == tmp.cost -> sort by title
                return this.title.compareTo(tmp.title);
            }   
        }
        return -1;
    }
    
    // print()
    public void print() {
        System.out.printf("Media - %s - %s - %.2f$\n", this.getTitle(), this.getCategory(),this.getCost());
    }

}