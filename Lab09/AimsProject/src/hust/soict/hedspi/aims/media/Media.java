package hust.soict.hedspi.aims.media;

public class Media implements Comparable<Media>{
	protected String title;
	protected String category;
	protected float cost = 0;
	protected int id = 0;
	
	public int getId() {
		return this.id;
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
	public Media(String title,String category,float cost) {
		this.cost = cost;
		this.title = title;
		this.category = category;
	}
	
	public Media(int id, String title, String category, float cost) {
		this(title,category,cost);
		this.id = id;
	}
	@Override
	public boolean equals(Object obj) throws NullPointerException, ClassCastException{
		if(obj != null) {
			if (obj instanceof Media) {
				if(this.title.compareTo(((Media)obj).getTitle()) == 0 && this.cost == ((Media)obj).getCost() )
					return true;
				return false;
			}
			else {
				throw new ClassCastException("Object Casting Error");
			}
		}
		else {
			throw new NullPointerException("Null Pointer Exception");
		}
	}
	
	public int compareTo(Media obj) {
		if((this.title.compareTo(obj.title) > 0))
			return 1;
		else if(this.title.compareTo(obj.title) < 0 )
			return -1;
		return 0;
	}

}

