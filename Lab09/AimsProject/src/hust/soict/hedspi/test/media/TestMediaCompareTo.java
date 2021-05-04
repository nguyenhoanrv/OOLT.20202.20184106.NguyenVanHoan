//package hust.soict.hedspi.test.media;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//import hust.soict.hedspi.aims.media.Media;
//import hust.soict.hedspi.aims.media.book.Book;
//import hust.soict.hedspi.aims.media.disc.CompactDisc;
//import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;
//
//public class TestMediaCompareTo {
//
//	public static void main(String args[]) {
//		ArrayList<Media> collection = new ArrayList<Media>();
//		Media dvd1 = new DigitalVideoDisc(1,"The Lion","Disney",259, 87,"Unkown"); collection.add(dvd1);
//		Media dvd2 = new DigitalVideoDisc(2,"Star War","Fox",129,124,"Unkown"); collection.add(dvd2);	
//		Media cd1 = new CompactDisc(1,"IBM Symphony","Music",130,120,"Unkown","Unkown"); collection.add(cd1);
//		collection.add(new Book(1,"Mat biec","Tieu thuyet",201));
//		Media cd2 = new CompactDisc(2,"Perfect","POPMusci",300,110,"Edsheeran","Unkown"); collection.add(cd2);
//		collection.add(new CompactDisc(3,"Alone","EDM",123,144,"AlanWalker","Unkown"));	
//		collection.add(new Book(1,"Anh hung xa dieu","Tieu thuyet",201));
//		Media dvd3 = new DigitalVideoDisc(3,"Aladin","Magic",130,90,"Unkown"); collection.add(dvd3);
//		System.out.println("The Medias currently are:");
//		for(Media cl : collection) {
//			if(cl instanceof DigitalVideoDisc)
//				((DigitalVideoDisc)cl).play();
//			else if(cl instanceof CompactDisc)
//				((CompactDisc)cl).play();
//			else
//				((Book)cl).play();
//		}
//		System.out.println("-----------------------------------------------");
//		java.util.Collections.sort(collection);
//		System.out.println("The Medias after sort are: ");
//		for(Media cl : collection) {
//		if(cl instanceof DigitalVideoDisc)
//			((DigitalVideoDisc)cl).play();
//		else if(cl instanceof CompactDisc)
//			((CompactDisc)cl).play();
//		else
//			((Book)cl).play();
//	}
//	}
//
//}
