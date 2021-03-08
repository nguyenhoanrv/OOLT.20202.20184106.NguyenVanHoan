import java.util.*;

import javax.swing.JOptionPane;

public class Bai6 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int [] arr = generateArray();
		System.out.println("Mang co san la: ");
		System.out.println(Arrays.toString(arr));
		int op = JOptionPane.showConfirmDialog(null, 
				"Ban muon dung mang co san khong?");
		if(op == JOptionPane.YES_OPTION) {
			printResult(arr);
		} else {
			System.out.println("Nhap so phan tu cua mang: ");
			int n = in.nextInt();
			int [] arr1 = new int[n];
			System.out.printf("Nhap %d phan tu cua mang: \n", n);
			for(int i = 0; i < n; i++) {
				String s = in.next();
				try {
					int temp = Integer.parseInt(s);
					arr1[i] = temp;
				} catch (NumberFormatException e) {
					if(Objects.equals(s, "$")) {
						arr1[i] = arr[i];
					}
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				}
			}
			printResult(arr1);
		}

	
		try {
		} catch (Exception e) {
			// TODO: handle exception
		}
		in.close();
	}
	
	
	public static int[] generateArray() {
		Random rand = new Random();
		int [] array = new int[1000];
		for (int i = 0; i<1000; i++)
		{
		    array[i] = rand.nextInt(1000);
		}
		return array;
	}
	
	
	public static int getSum(int [] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	public static double getAverage(int [] arr) {
		double avg = (double)(getSum(arr))/(arr.length);
		return avg;
	}
	
	public static void printResult(int [] arr) {
		int sum;
		double average;
		Arrays.sort(arr);
		System.out.println("Mang sau khi da sap xep la: ");
		System.out.println(Arrays.toString(arr));
		sum = getSum(arr);
		System.out.println("Tong cua mang la: " + sum);
		average = getAverage(arr);
		System.out.println("Trung binh cong cua mang la: " + average);
	}
}
