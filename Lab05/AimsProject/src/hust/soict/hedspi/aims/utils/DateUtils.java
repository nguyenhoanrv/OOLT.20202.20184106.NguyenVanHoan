package hust.soict.hedspi.aims.utils;

public class DateUtils{
    public static int compare(MyDate date1, MyDate date2) {
        // date1 < date2 => -1
        // date1 = date2 => 0
        // date1 > date2 => 1
        if (date1.getYear() < date2.getYear()) return -1;
        else {
            if (date1.getYear() > date2.getYear()) return 1;
            else {
                if (date1.getMonth() < date2.getMonth()) return -1;
                else {
                    if (date1.getMonth() > date2.getMonth()) return 1;
                    else {
                        if (date1.getDay() < date2.getDay()) return -1;
                        else {
                            if (date1.getDay() > date2.getDay()) return 1;
                            else {
                                return 0;
                            }
                        }
                    }
                }
            }
        }
    }
    public static void sort(MyDate [] dates){
        for(int i = 0 ; i < dates.length - 1 ; i++){
            if(compare(dates[i],dates[i+1]) == 1){
                MyDate temp = dates[i];
                dates[i] = dates[i+1];
                dates[i+1] = temp;
            }
        }
    }

    public static void print_arr(MyDate [] dates){
        for( int i = 0 ; i < dates.length ; i++)
        {
            dates[i].printFormat();
        }
    }

}