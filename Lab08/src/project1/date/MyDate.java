package project1.date;
import java.util.Scanner;
public class MyDate {
	private int day;
	private int month;
	private int year;
	public int getDay() {
		return day;
	}
	public int setDay(int day) {
		if(day > 0) {
		this.day = day;
		return day;
		}
		else {
			System.out.println("Error ! Enter again. ");
			return day;
		}
	}
	public int getMonth() {
		return month;
	}
	public int setMonth(int month) {
		if((month > 0) || (month <13)) {
			this.month = month;
			return month;
			}
			else {
				System.out.println("Error ! Enter again. ");
				return month;
			}
	}
	public int getYear() {
		return year;
	}
	public boolean setYear(int year) {
		if(year > 0) {
			this.year = year;
			return true;
			}
			else {
				System.out.println("Error ! Enter again. ");
				return false;
			}
	}
	
	public MyDate() {
		super();
		this.day = 01;
		this.month = 01;
		this.year = 2021;
	}
	public MyDate(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public MyDate(String mydate) {
		MyDate a = new MyDate();
		String[] output = mydate.split("/");
		this.day = Integer.parseInt(output[0]);
		this.month = Integer.parseInt(output[1]);
		this.year = Integer.parseInt(output[2]);		
	}
	public void accept(MyDate a){
		
		String date;
		System.out.println("Enter date :");
		Scanner input = new Scanner(System.in);
		date = input.nextLine();
		String[] output = date.split("/");
		a.setDay(Integer.parseInt(output[0]));
		a.setMonth(Integer.parseInt(output[1]));
		a.setYear(Integer.parseInt(output[2]));		
		
		}
	public void print(MyDate a) {
		System.out.println("Date :" + a.getDay() +"/"+a.month+"/"+a.year);
	}
			
}
