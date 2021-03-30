package hoan.com;

public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("JungLe");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
	}
	
	public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
		DigitalVideoDisc tmp = new DigitalVideoDisc(o1.getTitle(), o1.getCategory(), o1.getDirector(), o1.getLength(), o1.getCost());
		o1.setCategory(o2.getCategory());
		o1.setCost(o2.getCost());
		o1.setDirector(o2.getDirector());
		o1.setLength(o2.getLength());
		o1.setTitle(o2.getTitle());
		
		o2.setCategory(tmp.getCategory());
		o2.setCost(tmp.getCost());
		o2.setDirector(tmp.getDirector());
		o2.setLength(tmp.getLength());
		o2.setTitle(tmp.getTitle());
	}
	
	public static void changeTitle (DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
		System.out.println(dvd.getTitle());
	}
}
