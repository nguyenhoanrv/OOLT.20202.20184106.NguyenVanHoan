package hoan.com;

import java.util.*;
import java.text.SimpleDateFormat;

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
	 public MyDate(String day, String month, String year) {
	        String[] strDay = {"zero","first","second","third","fourth","fifth","sixth","seventh","eighth","ninth","tenth","eleventh","twelfth","thirteenth",
	            "fourteenth","fifteenth","sixteenth","seventeenth","eighteenth","nineteenth","twentieth","twenty-first","twenty-second","twenty-third",
	            "twenty-fourth","twenty-fifth","twenty-sixth","twenty-seventh","twenty-eighth","twenty-ninth","thirtieth","thirty-first"};
	        String[] strMonth = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	        String unitsArray[] = { "zero", "one", "two", "three", "four", "five", "six", 
	                      "seven", "eight", "nine", "ten", "eleven", "twelve",
	                      "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", 
	                      "eighteen", "nineteen" };
		String tensArray[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty",
	                      "sixty", "seventy", "eighty", "ninety", "hundred" };
	        for(int i=0;i<=31;i++) {
	            if(strDay[i].equals(day))
	                this.day = i;
	        }
	        for(int i=0;i<12;i++) {
	            if(strMonth[i].equals(month))
	                this.month = i;
	        }
	        
	        String[] yearList = year.split("\\s|-");
	        int yNumber = 0;
	        switch (yearList.length) {
	            case 4:
	                for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[0])) yNumber += i*1000;
	                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[1])) yNumber += i*100;
	                for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[2])) yNumber += i*10;
	                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[3])) yNumber += i;
	                break;
	            case 3:
	                for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[0])) yNumber += i*1000;
	                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[0])) yNumber += i*100;
	                for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[1])) yNumber += i*10;
	                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[1])) yNumber += i*100;
	                for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[2])) yNumber += i*10;
	                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[2])) yNumber += i;
	                break;
	            case 2:
	                for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[0])) yNumber += i*1000;
	                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[0])) yNumber += i*100;
	                for(int i=0;i<11;i++) {
	                	if(i != 10) {
	                		if(tensArray[i].equals(yearList[1])) 
		                		yNumber += i*10;
	                	} 
	                }
	                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[1])) yNumber += i; 
	                break;
	            case 1:
	                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[0])) yNumber += i;
	                for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[0])) yNumber += i;
	                break;
	            default:
	                break;
	        }
	        this.year = yNumber;
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
		in.close();
	}
	
	public void printFormat() {
		System.out.println(this.day + "/" + this.month + "/" + this.year);
	}
	
	public void print() {
        Calendar fDate = Calendar.getInstance();
        fDate.set(year, month, day);
        String dateFormat;
        
        switch (day) {
            case 1:
                dateFormat = "MMMMM d'st' yyyy";
                break;
            case 2:
                dateFormat = "MMMMM d'nd' yyyy";
                break;
            case 3:
                dateFormat = "MMMMM d'rd' yyyy";
                break;
            default:
                dateFormat = "MMMMM dd'th' yyyy";
                break;
        }
        
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        System.out.println(formatter.format(fDate.getTime())); 
                                                                
    }
	
}
