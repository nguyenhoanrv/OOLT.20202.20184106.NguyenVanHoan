package hust.soict.hedspi.test.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import hust.soict.hedspi.aims.utils.*;

class DateTest {
    
    @SuppressWarnings("unused")
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    
    // test DateUtils.compare(MyDate d1, MyDate d2)
    @Test
    void testDateUtilsCompare() {
        MyDate d0 = new MyDate(2, 5, 2015);
        MyDate d1 = new MyDate(2, 5, 2016); // to compare year with d0
        MyDate d2 = new MyDate(2, 5, 2014);
        MyDate d3 = new MyDate(2, 6, 2015); // to compare month with d0
        MyDate d4 = new MyDate(2, 4, 2015);
        MyDate d5 = new MyDate(3, 5, 2015); // to compare day with d0
        MyDate d6 = new MyDate(1, 5, 2015);
        MyDate d7 = new MyDate(30, 4, 2015); // d0.getDay() < d7.getDay() && d0.getMonth() > d7.getMonth()
        MyDate d8 = new MyDate(2, 5, 2015);
        MyDate d9 = new MyDate(1, 1, 2015);   // d8.getDay() < d9.getDay() && d8.getMonth() < d9.getMonth()
        MyDate d10 = new MyDate(31, 12, 2014); // d8.getYear() < d9.getYear()
        
        assertEquals(-1, DateUtils.compare(d0, d1), "DateUtils.compare(MyDate d1, MyDate d2): wrong logic");
        assertEquals( 1, DateUtils.compare(d0, d2), "DateUtils.compare(MyDate d1, MyDate d2): wrong logic");
        assertEquals(-1, DateUtils.compare(d0, d3), "DateUtils.compare(MyDate d1, MyDate d2): wrong logic");
        assertEquals( 1, DateUtils.compare(d0, d4), "DateUtils.compare(MyDate d1, MyDate d2): wrong logic");
        assertEquals(-1, DateUtils.compare(d0, d5), "DateUtils.compare(MyDate d1, MyDate d2): wrong logic");
        assertEquals( 1, DateUtils.compare(d0, d6), "DateUtils.compare(MyDate d1, MyDate d2): wrong logic");
        assertEquals( 1, DateUtils.compare(d0, d7), "DateUtils.compare(MyDate d1, MyDate d2): wrong logic");
        assertEquals( 0, DateUtils.compare(d0, d8), "DateUtils.compare(MyDate d1, MyDate d2): wrong logic");
        assertEquals( 1, DateUtils.compare(d9, d10), "DateUtils.compare(MyDate d1, MyDate d2): wrong logic");
    }
    
    // test DateUtils.sortASC(MyDate[] dates)
    @Test
    void testDateUtilssortASC() {
        MyDate d0 = new MyDate(2, 5, 2015);
        MyDate d1 = new MyDate(2, 5, 2016);
        MyDate d2 = new MyDate(2, 5, 2014);
        MyDate d3 = new MyDate(2, 6, 2015);
        MyDate d4 = new MyDate(2, 4, 2015);
        MyDate d5 = new MyDate(3, 5, 2015);
        MyDate d6 = new MyDate(1, 5, 2015);
        MyDate d7 = new MyDate(30, 4, 2015);
        MyDate d8 = new MyDate(2, 5, 2015);
        MyDate d9 = new MyDate(1, 1, 2015);
        MyDate d10 = new MyDate(31, 12, 2014);
        
        MyDate[] actual   = {d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10};
        DateUtils.sortASC(actual);
        MyDate[] expected = {d2, d10,d9, d4, d7, d6, d0, d8, d5, d3, d1};
        
        assertArrayEquals(expected, actual, "DateUtils.sortASC(MyDate[] dates): wrong logic");
    }
    
    // test print()
    @Test
    void testMyDatePrintNoParam1() {
        MyDate actual = new MyDate(1, 4, 2000);
        actual.print();
        assertEquals("April 1st 2000\n", outputStreamCaptor.toString());
    }
    
    @Test
    void testMyDatePrintNoParam2() {
        MyDate actual = new MyDate(17, 3, 1234);
        actual.print();
        assertEquals("March 17th 1234\n", outputStreamCaptor.toString());
    }
    
    @Test
    void testMyDatePrintNoParam3() {
        MyDate actual = new MyDate(22, 11, 2005);
        actual.print();
        assertEquals("November 22nd 2005\n", outputStreamCaptor.toString());
    }
    
    // test: print(int mode, boolean TwoCharNumber, boolean useMonthName, int monthNameMode, char separator)
    @Test
    void testMyDatePrintCustomized1() {
        MyDate date = new MyDate(1, 1, 2000);
        date.print(0, false, false, 0, '/');
        assertEquals("1/1/2000\n", outputStreamCaptor.toString());
    }
    
    @Test
    void testMyDatePrintCustomized2() {
        MyDate date = new MyDate("third", "December", "seventeen fifty");
        date.print(2, true, false, 0, '-');
        assertEquals("1750-12-03\n", outputStreamCaptor.toString());
    }
    
    @Test
    void testMyDatePrintCustomized3() {
        MyDate date = new MyDate("thirty-first", "Mar", "nineteen eighty-four");
        date.print(0, true, true, 0, '-');
        assertEquals("31-Mar-1984\n", outputStreamCaptor.toString());
    }
    
    @Test
    void testMyDatePrintCustomized4() {
        MyDate date = new MyDate("seventh", "Jul.", "twenty seventeen");
        date.print(1, true, true, 0, ' ');
        assertEquals("Jul 07 2017\n", outputStreamCaptor.toString());
    }
    
    @Test
    void testMyDatePrintCustomized5() {
        MyDate date = new MyDate("eighth", "November", "seventeen one");
        date.print(1, true, false, 0, '-');
        assertEquals("11-08-1701\n", outputStreamCaptor.toString());
    }
    
    // test MyDate(String inputDay, String inputMonth, String inputYear)
    @Test
    void testMyDateInput3String() {
        MyDate actual = new MyDate("first", "Jan.", "twenty hundred");
        MyDate expected = new MyDate(1, 1, 2000);
        actual.print();
        assertMyDateEquals(expected, actual);
        
        actual = new MyDate("thirteenth", "April", "fifteen nineteen");
        expected = new MyDate(13, 4, 1519);
        actual.print();
        assertMyDateEquals(expected, actual);
        
        actual = new MyDate("twenty-second", "Jun", "twenty twenty");
        expected = new MyDate(22, 6, 2020);
        actual.print();
        assertMyDateEquals(expected, actual);
        
        actual = new MyDate("thirtieth", "December", "eighteen twenty-six");
        expected = new MyDate(30, 12, 1826);
        actual.print();
        assertMyDateEquals(expected, actual);
    }
    
    void assertMyDateEquals(MyDate expected, MyDate actual) {
        assertEquals(expected.getDay(), actual.getDay(), "MyDate(String inputDay, String inputMonth, String inputYear): wrong day");
        assertEquals(expected.getMonth(), actual.getMonth(), "MyDate(String inputDay, String inputMonth, String inputYear): wrong month");
        assertEquals(expected.getYear(), actual.getYear(), "MyDate(String inputDay, String inputMonth, String inputYear): wrong year");
    }

}