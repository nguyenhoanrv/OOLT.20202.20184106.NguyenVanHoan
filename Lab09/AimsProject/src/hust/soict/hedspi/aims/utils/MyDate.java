package hust.soict.hedspi.aims.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MyDate {
	private int day;
	private int month;
	private int year;
	private String[] strDay = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth",
							"eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth", "nineteenth", "twentieth",
							"twenty-first", "twenty-second", "twenty-third", "twenty-fourth", "twenty-fifth", "twenty-sixth", "twenty-seventh", "twenty-eighth", "twenty-ninth", "thirtieth", "thiry-first"};
	private String[] strMonth = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	//setter and getter methods
	public void setDay(int day) {
		if(checkLeapYear(year)) {
			if(month == 2) {
				if(day <=0 || day >29) {
					System.out.println("Valude of day is invalid");
					return;
				}
				else {
					this.day = day;
				}
			}
			else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				if(day < 1 || day > 31) {
					System.out.println("Valude of day is invalid");
					return;
				}
				else {
					this.day = day;
				}
			}
			else {
				if(day <1 || day > 30) {
					System.out.println("Value of day is invalid");
					return;
				}
				else {
					this.day = day;
				}
			}
		}
		else {
			if(month == 2) {
				if(day <=0 || day > 28) {
					System.out.println("Valude of day is invalid");
					return;
				}
				else {
					this.day = day;
				}
			}
			else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				if(day < 1 || day > 31) {
					System.out.println("Valude of day is invalid");
					return;
				}
				else {
					this.day = day;
				}
			}
			else {
				if(day <1 || day > 30) {
					System.out.println("Value of day is invalid");
					return;
				}
				else {
					this.day = day;
				}
			}					
		}
	}
	public void setMonth(int month) {
		if(month <=0 || month > 12) {
			System.out.println("Value of month is invalid");
			return;
		}
		this.month = month;
	}
	public void setYear(int year) {
		if(year < 0 ) {
			System.out.println("Value of year is invalid");
			return;			
		}
		this.year = year;
	}
	public static boolean checkLeapYear(int year) {
		if(year%4 == 0) {
			if(year%100 == 0 && year%400 != 0) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	//setter mothod string type
	
	public void setDay(String day) {
		int isValid = 0;
		for (int i=0; i<strDay.length;i++) {
			if(day.equalsIgnoreCase(strDay[i])) {
				setDay(i+1);
				return;
			}
		}
		if(isValid == 0)
			System.out.println("String of day is wrong");
	}
	public void setMonth(String month) {
		int isValid = 0;
		for(int i=0;i<strMonth.length;i++) {
			if(month.equalsIgnoreCase(strMonth[i]) == true) {
				setMonth(i+1);
				isValid = 1;
				break;
			}
		}
		if(isValid == 0)
			System.out.println("String of month is wrong");
	}
	
	public void setYear(String year) {
		setYear(convertStringYear(year));
	}
	
	public int getDay() {
		return this.day;
	}
	public int getMonth() {
		return this.month;
	}
	public int getYear() {
		return this.year;
	}
	//Construct 3 parameter
	public MyDate(int day, int month, int year) {
		super();
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	// construct for lab4
	public MyDate(String day, String month, String year) {
		setDay(day);
		setMonth(month);
		setYear(year);
	}
	
	//Construct no parameter
	public MyDate() {
		Calendar c = Calendar.getInstance();
		this.year = c.get(Calendar.YEAR);
		this.month = c.get(Calendar.MONTH) + 1;
		this.day = c.get(Calendar.DATE);
	}
	public String accept() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter date (EX:'February 18 2019'): ");
		String strDate = sc.nextLine();
		return strDate;
	}
	public MyDate(String strDate) {
		if(strDate == "") {
			strDate = accept();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd yyyy");
        try {
            Date date = formatter.parse(strDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
    		this.year = cal.get(Calendar.YEAR);
    		this.month = cal.get(Calendar.MONTH) + 1;
    		this.day = cal.get(Calendar.DATE);           
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	
	// chuyen tu string year sang int year, 
	//nhung do co qua nhieu cach nhap string nen em chi lam string dang giong het nhu trong slide
	public int convertStringYear(String year) {
		boolean isValid = false;
	    int result = 0;
	    int resultConvert = 0;
	    String[] listYear = {"zero","one","two","three","four","five","six","seven",
	    					"eight","nine","ten","eleven","twelve","thirteen","fourteen",
	    					"fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
	    					"thirty","forty","fifty","sixty","seventy","eighty","ninety"
	    					};

	    if(year != null)
	    {
	        year = year.toLowerCase();
	        String[] splitted = year.trim().split("\\s");

	        for(String str : splitted)
	        {
	            for(int i = 0;i<listYear.length;i++) {
	            	if(str.equalsIgnoreCase(listYear[i])) {
	            		isValid = true;
	            		break;
	            	}
	            }
	            if(isValid == false) {
	            	System.out.println("Input is inValid.");
	            	break;
	            }
	            
	        }
	        if(isValid)
	        {	
	        	// chuyen hang nghin
	        	switch(splitted[0]) {
	        		case "ten":
	        			resultConvert = 1000;
	        			break;
	        		case "eleven":
	        			resultConvert = 1100;
	        			break;
	        		case "twelve":
	        			resultConvert = 1200;
	        			break;
	        		case "thirteen":
	        			resultConvert = 1300;
	        			break;
	        		case "fourteen":
	        			resultConvert = 1400;
	        			break;
	        		case "fifteen":
	        			resultConvert = 1500;
	        			break;
	        		case "sixteen":
	        			resultConvert = 1600;
	        			break;
	        		case "seventeen":
	        			resultConvert = 1700;
	        			break;
	        		case "eighteen":
	        			resultConvert = 1800;
	        			break;
	        		case "nineteen":
	        			resultConvert = 1900;
	        			break;
	        		case "twenty":
	        			resultConvert = 2000;
	        			break;
	        		default:
						System.out.println("String of year is wrong");
	        	}
	        	//chuyen hang chuc va don vi
	            for(int i = 1; i < splitted.length; i++)
	            {	
	            	String str = splitted[i];
	                if(str.equalsIgnoreCase("one")) {
	                    result += 1;
	                }
	                else if(str.equalsIgnoreCase("two")) {
	                    result += 2;
	                }
	                else if(str.equalsIgnoreCase("three")) {
	                    result += 3;
	                }
	                else if(str.equalsIgnoreCase("four")) {
	                    result += 4;
	                }
	                else if(str.equalsIgnoreCase("five")) {
	                    result += 5;
	                }
	                else if(str.equalsIgnoreCase("six")) {
	                    result += 6;
	                }
	                else if(str.equalsIgnoreCase("seven")) {
	                    result += 7;
	                }
	                else if(str.equalsIgnoreCase("eight")) {
	                    result += 8;
	                }
	                else if(str.equalsIgnoreCase("nine")) {
	                    result += 9;
	                }
	                else if(str.equalsIgnoreCase("ten")) {
	                    result += 10;
	                }
	                else if(str.equalsIgnoreCase("eleven")) {
	                    result += 11;
	                }
	                else if(str.equalsIgnoreCase("twelve")) {
	                    result += 12;
	                }
	                else if(str.equalsIgnoreCase("thirteen")) {
	                    result += 13;
	                }
	                else if(str.equalsIgnoreCase("fourteen")) {
	                    result += 14;
	                }
	                else if(str.equalsIgnoreCase("fifteen")) {
	                    result += 15;
	                }
	                else if(str.equalsIgnoreCase("sixteen")) {
	                    result += 16;
	                }
	                else if(str.equalsIgnoreCase("seventeen")) {
	                    result += 17;
	                }
	                else if(str.equalsIgnoreCase("eighteen")) {
	                    result += 18;
	                }
	                else if(str.equalsIgnoreCase("nineteen")) {
	                    result += 19;
	                }
	                else if(str.equalsIgnoreCase("twenty")) {
	                    result += 20;
	                }
	                else if(str.equalsIgnoreCase("thirty")) {
	                    result += 30;
	                }
	                else if(str.equalsIgnoreCase("forty")) {
	                    result += 40;
	                }
	                else if(str.equalsIgnoreCase("fifty")) {
	                    result += 50;
	                }
	                else if(str.equalsIgnoreCase("sixty")) {
	                    result += 60;
	                }
	                else if(str.equalsIgnoreCase("seventy")) {
	                    result += 70;
	                }
	                else if(str.equalsIgnoreCase("eighty")) {
	                    result += 80;
	                }
	                else if(str.equalsIgnoreCase("ninety")) {
	                    result += 90;
	                }
	            }

	            resultConvert += result;
	            result=0;
	        }
	    }
	    return resultConvert;
	}
	public void print() {
		if(day == 0 || month == 0 || year == 0) {
			System.out.println("Invalid Month/Day/Year");
		}else {
			int day = getDay();
			String str;
			if(day == 1) {
				str = Integer.toString(day) + "st";
			}
			else if(day == 2) {
				str = Integer.toString(day) + "nd";
			}
			else if(day == 3) {
				str = Integer.toString(day) + "rd";
			}
			else {
				str = Integer.toString(day) + "th";
			}
			System.out.printf("%s %s %d %n", strMonth[getMonth() - 1],str, getYear());
		}
	}
	public void print2() {
		if (this.day == 0 || month == 0 || year == 0) {
			System.out.println("Date is not created");
		} else {
			System.out.printf("%d/%d/%d\n",getDay(),getMonth(),getYear());
		}
	}
}
