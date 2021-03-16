package hoan.com;

import java.util.*;

public class MyDate {

	private int day;
	private int month;
	private int year;
	public MyDate() {
		super();
		Calendar now = Calendar.getInstance();
		this.day = now.get(Calendar.DAY_OF_MONTH);
		this.month = now.get(Calendar.MONTH) + 1;
		this.year = now.get(Calendar.YEAR);
	}
	
	public MyDate(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public MyDate(String date) {
		super();
		if (date.length() != 10)
		{
			throw new IllegalArgumentException("Date invalid.");
		}
		try {
			this.day = Integer.parseInt(date.substring(0, 2));
			this.month = Integer.parseInt(date.substring(3, 5));
			this.year = Integer.parseInt(date.substring(6, 10));
			if(this.day <= 0 || this.day > 31)
				throw new IllegalArgumentException();
			if(this.month <= 0 || this.month > 12)
				throw new IllegalArgumentException();
			if(this.year < 0 )
				throw new IllegalArgumentException();
		}catch(Exception e) {
			throw new IllegalArgumentException("Date invalid.");
		}
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if(day <= 0 || day > 31) {
			System.out.println("Day invalid");
		}
		else {
			this.day = day;
		}
	}

	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		if(month <= 0 || month > 12) {
			System.out.println("Month invalid");
		} else {
			this.month = month;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if(year < 0) {
			System.out.println("Year invalid");
		} else {
			this.year = year;
		}	
	}
	
	public void accept() {
		Scanner in = new Scanner(System.in);
		int day, month, year;
		System.out.println("Enter day, month, year (dd/mm/yyyy):");
		while(true) {
			day = in.nextInt();
			month = in.nextInt();
			year = in.nextInt();
			if(day <= 0 || day > 31 || month <=  0 || month > 12 || year < 0) {
				System.out.println("Date invalid. Enter again (dd/mm/yyyy): ");
			}
			else 
				break;
		}
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
	}
	
	public static void main(String[] args) {
		MyDate date1 = new MyDate();
		MyDate date2 = new MyDate("13/10/2000");
		MyDate date3 = new MyDate();
		System.out.println("Date 1:");
		System.out.println(date1.getDay() + "/" + date1.getMonth() + "/" + date1.getYear());
		System.out.println("Date 2:");
		System.out.println(date2.getDay() + "/" + date2.getMonth() + "/" + date2.getYear());
		System.out.println("Date 3: ");
		date3.accept();
		System.out.println(date3.getDay() + "/" + date3.getMonth() + "/" + date3.getYear());
		
	}
}
