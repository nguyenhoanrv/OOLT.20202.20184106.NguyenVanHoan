/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.test.utils;
import hust.soict.hedspi.aims.utils.*;


public class DateTest {
    public static void main(String[] args) {
        MyDate aDate = new MyDate("first","February","twenty nineteen");
        MyDate bDate = new MyDate("first","February","twenty twenty");
        MyDate[] dateList = {bDate,aDate}; 
        //aDate.setMonth(2);
        //aDate.setDay(29);
        //aDate.setYear(2100);
        //aDate.accept();
        aDate.print();
        bDate.print();
        System.out.printf("aDate vs bDate is: %d\n", DateUtils.compareMyDate(aDate, bDate));
        System.out.println("Before sorting");
        DateUtils.print(dateList);
        DateUtils.sortMyDate(dateList);
        System.out.println("After sorting");
        DateUtils.print(dateList);
        //System.out.println(aDate.getDay()+"/"+aDate.getMonth()+"/"+aDate.getYear());
        //aDate.printFormat();
    }
}
