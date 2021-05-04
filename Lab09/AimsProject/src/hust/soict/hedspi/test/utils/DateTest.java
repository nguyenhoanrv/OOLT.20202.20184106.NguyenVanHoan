package hust.soict.hedspi.test.utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import hust.soict.hedspi.aims.utils.DateUtils;
import hust.soict.hedspi.aims.utils.MyDate;

public class DateTest {
	public static void main(String[] args) {
		System.out.println("Test Constructor no parameter"); 
		MyDate test1 = new MyDate();
		test1.print2();
		
		System.out.println("Test Constructor 3 parameter");
		MyDate test2 = new MyDate(30, 4, 2019);
		test2.print2();
		
		System.out.println("test constructor string");
		MyDate test3 = new MyDate("August 10 1999");
		test3.print2();
		
		System.out.println("Test constructor enter string from keyboard");
		MyDate test4 = new MyDate("");
		test4.print();
		
		String[] date = new String[]{"10/04/2019", "04/12/2011", "5/3/2021", "06/02/2022"};
		DateUtils.sortDates(date);

        // After Sort
        System.out.println("After Sort: ");
        for (int i = 0; i < date.length; i++) {
            System.out.println(date[i]);
        }
		
		MyDate test5 = new MyDate("first","April","twenty twenty five");
		test5.print();
		
		System.exit(0);
	}
}
