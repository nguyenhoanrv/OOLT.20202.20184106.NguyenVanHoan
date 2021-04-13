/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.utils;
import java.text.ParseException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MyDate {
    private int iDay;
    private int iMonth; //Calendar using 0-11 month while LocalTime is 1-12
    private int iYear;

    public MyDate() {
        Calendar curDate = Calendar.getInstance();
        this.iDay = curDate.get(Calendar.DAY_OF_MONTH);
        this.iMonth = curDate.get(Calendar.MONTH);
        this.iYear = curDate.get(Calendar.YEAR);
    }

    public MyDate(int day, int month, int year) {
        Calendar fDate = Calendar.getInstance();
        fDate.set(year, month-1, 1);
        if(day < 1 || day > fDate.getActualMaximum(Calendar.DAY_OF_MONTH) ){ //getActualMaximum to get the last day of month
            System.out.println("Not valid date.");
            return;
        }
        
        this.iDay = day;
        this.iMonth = month-1;
        this.iYear = year;
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
                      "sixty", "seventy", "eighty", "ninety" };
        for(int i=0;i<=31;i++) {
            if(strDay[i].equals(day))
                this.iDay = i;
        }
        for(int i=0;i<12;i++) {
            if(strMonth[i].equals(month))
                this.iMonth = i;
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
                for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[1])) yNumber += i*10;
                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[1])) yNumber += i; 
                break;
            default:
                break;
        }

        this.iYear = yNumber;
    }
    
    public MyDate(String iDate) {
        String dateFormat = "MMMMM dd yyyy";
        Date bDate;
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar fDate = Calendar.getInstance();
        formatter.setLenient(false);
        try {
            if(iDate.contains("1st"))
               bDate = formatter.parse((iDate.replaceAll("st", "")).trim());
            else if(iDate.contains("2nd"))
                bDate = formatter.parse((iDate.replaceAll("nd", "")).trim());
            else if(iDate.contains("3rd"))
                bDate = formatter.parse((iDate.replaceAll("rd", "")).trim());
            else
                bDate = formatter.parse((iDate.replaceAll("th", "")).trim()); //replaceAll(): replace all st|nd|rd|th = ""
                                                                        //trim() to remove blank before and after the str
        } catch (ParseException pe) {
            System.out.println("Not a valid date or wrong format.");
            return;
        }      
        
        fDate.setTime(bDate);
        this.iDay = fDate.get(Calendar.DAY_OF_MONTH);
        this.iMonth = fDate.get(Calendar.MONTH);
        this.iYear = fDate.get(Calendar.YEAR);
    }    

    public int getDay() {
        return iDay;
    }

    public void setDay(int day) {
        Calendar fDate = Calendar.getInstance();
        fDate.set(iYear, iMonth, 1); //set the time
        if(day < 1 || day > fDate.getActualMaximum(Calendar.DAY_OF_MONTH) ){ //getActualMaximum to get the last day of month
            System.out.println("Not valid day.");
            return;
        }
            
        this.iDay = day;
    }

    public int getMonth() {
        return iMonth+1;
    }

    public void setMonth(int month) {
        Calendar fDate = Calendar.getInstance();
        fDate.set(iYear, month-1, 1); //get the first day of input month only for getting month, 1 or 2 day is not important
        if(iDay > fDate.getActualMaximum(Calendar.DAY_OF_MONTH)) { 
            System.out.println("Not valid month.");
            return;
        }
            
        this.iMonth = month-1;
    }

    public int getYear() {
        return iYear;
    }

    public void setYear(int year) {
        Calendar fDate = Calendar.getInstance();
        fDate.set(year, iMonth, 1); //get the first day of input month only for getting month, 1 or 2 day is not important
        if(iDay > fDate.getActualMaximum(Calendar.DAY_OF_MONTH)) { 
            System.out.println("Not valid year.");
            return;
        }
        
        this.iYear = year;
    }
        
    public void accept() {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Please enter a date: ");
        String strDate = keyboard.nextLine();
        String dateFormat = "MMMMMM dd yyyy";
        Date bDate;
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar fDate = Calendar.getInstance();
        formatter.setLenient(false);
        try {
            bDate = formatter.parse((strDate.replaceAll("st|nd|rd|th", "")).trim());
        } catch (ParseException pe) {
            System.out.println("Invalid date or format");
            return;
        }
        
        fDate.setTime(bDate);
        this.iDay = fDate.get(Calendar.DAY_OF_MONTH);
        this.iMonth = fDate.get(Calendar.MONTH);
        this.iYear = fDate.get(Calendar.YEAR);
        
        System.out.println("Updated sucessfully");
        keyboard.close();
    }
    
    public void print() {
        Calendar fDate = Calendar.getInstance();
        fDate.set(iYear, iMonth, iDay);
        String dateFormat;
        
        switch (iDay) {
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
    
    public void printFormat() {
        Calendar fDate = Calendar.getInstance();
        fDate.set(iYear, iMonth, iDay);
        String dateFormat;
        int opt;
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Please choose the optional date format; ");
        System.out.println("1. yyyy-MM-dd");
        System.out.println("2. d/M/yyyy");
        System.out.println("3. dd-MMM-yyyy");
        System.out.println("4. MMM d yyyy");
        System.out.println("5. mm-dd-yyyy");
        opt = keyboard.nextInt();
        
        switch (opt) {
            case 1:
                dateFormat = "yyyy-MM-dd";
                break;
            case 2:
                dateFormat = "d/M/yyyy";
                break;
            case 3:
                dateFormat = "dd-MMM-yyyy";
                break;
            case 4:
                dateFormat = "MMM d yyyy";
                break;
            case 5:
                dateFormat = "mm-dd-yyyy";
                break;
            default:
                dateFormat = "MMMMM dd yyyy";
                break;
        }
        
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        System.out.println(formatter.format(fDate.getTime())); 
                                                                
    }
}
