package hust.soict.hedspi.aims.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class DateUtils {
    public static int compareMyDate(MyDate dateS, MyDate dateD) {
        if(dateS.getYear() > dateD.getYear())
            return 1;
        else if (dateS.getYear() < dateD.getYear())
            return -1;
        else {
            if(dateS.getMonth() > dateD.getMonth())
                return 1;
            else if(dateS.getMonth() < dateD.getMonth())
                return -1;
            else {
                if(dateS.getDay() > dateD.getDay())
                    return 1;
                else if(dateS.getDay() < dateD.getDay())
                    return -1;
                else 
                    return 0;
            }
        }
    }
    
    public static void sortMyDate(MyDate[] dateList) {
        int n = dateList.length;
        for (int i=0;i<n-1;i++)
            for(int j=0;j<n-i-1;j++) {
                if(compareMyDate(dateList[j], dateList[j+1]) > 0) {
                    //swap 
                    MyDate tmp = new MyDate();
                    tmp.setDay(dateList[j].getDay());
                    tmp.setMonth(dateList[j].getMonth());
                    tmp.setYear(dateList[j].getYear());
                    dateList[j].setDay(dateList[j+1].getDay());
                    dateList[j].setMonth(dateList[j+1].getMonth());
                    dateList[j].setYear(dateList[j+1].getYear());
                    dateList[j+1].setDay(tmp.getDay());
                    dateList[j+1].setMonth(tmp.getMonth());
                    dateList[j+1].setYear(tmp.getYear());
                }
            }
    }
    
    public static void print(MyDate[] dateList) {
        int n = dateList.length;
        for(int i=0;i<n;i++)
            dateList[i].print();
    }
}


