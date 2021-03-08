import java.util.Scanner;

enum Month{
	JAN(31), FEB(28), MAR(31), APR(30), MAY(31), JUN(30), JUL(31), AUG(31), SEP(30), OCT(31), NOV(30), DEC(31);
	private int value;
	Month(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
};
public class Bai5 {
	public static void main(String[] args) {			
		Scanner in = new Scanner(System.in);
		while(true) {
			try {
				System.out.println("Enter Month: ");
				String mon = in.next();
				System.out.println("Enter Year: ");
				int year = in.nextInt();
				switch(mon) {
					case "January":
					case "Jan.":
					case "Jan":
					case "1":
						System.out.println("Number of days in month is: " + Month.JAN.getValue());
						break;
					
					case "February":
					case "Feb.":
					case "Feb":
					case "2":
						if(year % 4 == 0 && year % 400 != 0)
							System.out.println("Number of days in month is: " + (Month.FEB.getValue() + 1));
						else 
							System.out.println("Number of days in month is: " + Month.FEB.getValue());
						break;
					
					case "March":
					case "Mar.":
					case "Mar":
					case "3":
						System.out.println("Number of days in month is: " + Month.MAR.getValue());
						break;
						
					case "April":
					case "Apr.":
					case "Apr":
					case "4":
						System.out.println("Number of days in month is: " + Month.APR.getValue());
						break;
					
					case "May":
					case "May.":
					case "5":
						System.out.println("Number of days in month is: " + Month.MAY.getValue());
						break;
						
					case "June":
					case "Jun.":
					case "Jun":
					case "6":
						System.out.println("Number of days in month is: " + Month.JUN.getValue());
						break;
					
					case "July":
					case "Jul.":
					case "Jul":
					case "7":
						System.out.println("Number of days in month is: " + Month.JUL.getValue());
						break;
					
					case "August":
					case "Aug.":
					case "Aug":
					case "8":
						System.out.println("Number of days in month is: " + Month.AUG.getValue());
						break;
						
					case "September":
					case "Sep.":
					case "Sep":
					case "9":
						System.out.println("Number of days in month is: " + Month.SEP.getValue());
						break;
						
					case "October":
					case "Oct.":
					case "Oct":
					case "10":
						System.out.println("Number of days in month is: " + Month.OCT.getValue());
						break;
						
					case "November":
					case "Nov.":
					case "Nov":
					case "11":
						System.out.println("Number of days in month is: " + Month.NOV.getValue());
						break;
						
					case "December":
					case "Dec.":
					case "Dec":
					case "12":
						System.out.println("Number of days in month is: " + Month.DEC.getValue());
						break;
					
					default:
						System.out.println("\nWrong month!\nPlease enter again!\n");
						continue;
				}
				break;
			}
			catch(Exception e){
					System.out.println("\nWrong year!\nPlease enter again!\n");
					in.next();
					continue;
			}
		}	
		in.close();
	}
}
