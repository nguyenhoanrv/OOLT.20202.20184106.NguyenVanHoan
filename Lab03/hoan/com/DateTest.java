package hoan.com;

public class DateTest {
	public static void main(String[] args) {
		MyDate date1 = new MyDate();
		MyDate date2 = new MyDate("13/10/2000");
		MyDate date3 = new MyDate();
		date1.print();
		date2.print();
		
		date3.accept();
		date3.print();
	}
}
