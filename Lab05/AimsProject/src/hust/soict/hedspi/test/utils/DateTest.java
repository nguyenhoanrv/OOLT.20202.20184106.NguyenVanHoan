package hust.soict.hedspi.test.utils;

import hust.soict.hedspi.aims.utils.*;

public class DateTest {
	public static void main(String[] args) {
		MyDate date1 = new MyDate();
		MyDate date2 = new MyDate("13/10/2000");
		MyDate date3 = new MyDate();
		date1.printFormat();
		date2.printFormat();

		MyDate date4 = new MyDate("twenty-fifth", "January", "sixteen-hundred");
		MyDate date5 = new MyDate("twentieth", "January", "sixteen-sixteen");
		date4.print();
		date5.print();
		
		 date3.accept();
		 date3.printFormat();

	}
}
