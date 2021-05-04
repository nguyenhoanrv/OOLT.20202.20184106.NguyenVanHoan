package hust.soict.hedspi.aims.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static int compareDate(String sDate1, String sDate2) {
		SimpleDateFormat formated = new SimpleDateFormat("dd/MM/yyyy");
		Date date1=null,date2=null;
		try {
			date1 = formated.parse(sDate1);
			date2 = formated.parse(sDate2);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		if(date1 == null || date2 == null) {
			System.out.println("input string is inValid");
			return -2;
		}
		else {
			if (date1.compareTo(date2) > 0) {
				return 1; //date 1 after date 2
			} else if (date1.compareTo(date2) < 0) {
				return -1; //date 1 before date 2
			}
        return 0; //date 1 same date 2
		}
    }
	// sap xep theo trinh tu thoi gian
	public static void sortDates(String[] date) {
        for (int i = 0; i < date.length - 1; i++) {
            for (int j = i + 1; j < date.length; j++) {
                if (compareDate(date[i], date[j]) == 1) {
                    String tmp = date[i];
                    date[i] = date[j];
                    date[j] = tmp;
                }
            }
        }
    }
}
