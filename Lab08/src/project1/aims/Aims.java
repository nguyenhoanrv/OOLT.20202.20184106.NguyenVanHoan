package project1.aims;
import java.util.ArrayList;
import project1.disc.Disc;
import java.util.Scanner;
import project1.disc.CompactDisc;
import project1.disc.DigitalVideoDisc;
import project1.media.Book;
import project1.media.Media;
import project1.media.Track;
import project1.order.Order;

public class Aims {

	private static final String discs = null;

	public Aims() {
		super();
	}

	public static void main(String[] args) {
		
		ArrayList<String> authors = new ArrayList<String>();
		ArrayList<Track> tracks1 = new ArrayList<Track>();
		ArrayList<CompactDisc> discs = new ArrayList<CompactDisc>();
		ArrayList<Media> itemsOrdered = new ArrayList<Media>();
		ArrayList<DigitalVideoDisc> dvd = new ArrayList<DigitalVideoDisc>();
		ArrayList<Book> book = new ArrayList<Book>();
		
		authors.add(new String("Truong Chi"));
		authors.add(new String("Truong Li"));
		book.add(new Book("The Killer","Action",30.4f,authors));
		
		tracks1.add(new Track("La vi em",5));
		tracks1.add(new Track("Chang co yeu anh",4));
		discs.add(new CompactDisc("Nhuc bo doan","Sex",34.5f,tracks1));

		
		dvd.add(new DigitalVideoDisc("The Lion King","Animation",19.95f,"Roger Allers",87));
		dvd.add(new DigitalVideoDisc("The Cat","Animation",34.95f,"Alan Turing",47));
		DigitalVideoDisc dvd2 = new DigitalVideoDisc();
		dvd2.setTitle("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);

		int a = 0;
		do {
		System.out.println("*****************************");
		System.out.println("1.In ra thong tin CompactDisc :");
		System.out.println("2.In ra thong tin DVD");
		System.out.println("3.In ra thong tin Book");
		System.out.println("4.Thoat chuong trinh");
		
		System.out.println("Ban chon lua chon nao :");
		Scanner input = new Scanner(System.in);
		a = input.nextInt();
		if(a == 1) {
		
			for(CompactDisc a1 : discs) {
				a1.play();
			}
		}
		if(a == 2) {
			for(DigitalVideoDisc a1 : dvd) {
				a1.play();
				System.out.println("\n");
			}
		}
		if(a == 3) {
			for(Book a1 : book) {
				a1.play();
			}
		}
		if(a == 4) {
			System.out.println("Thoat chuong trinh \n Hen gap lai quy khach !");
		}
		}
		while(a != 4);
	}
}

	

	