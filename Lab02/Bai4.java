import java.util.Scanner;

public class Bai4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Nhap so dong: ");
		int n = in.nextInt();
		if(n <= 0) {
			System.out.println("Gia tri khong hop le.\n");
			System.exit(1);
		}
		int sum = n*2 + 1;        // tổng kí tự 1 dòng
		for(int i = 0; i < n; i++){
			int x = i*2 + 1;      // tổng dấu sao 1 dòng
			for(int j = 0; j < (sum - x)/2; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < x; j++) {
				System.out.print("*");
			}
			for(int j = 0; j < (sum - x)/2; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		in.close();
		System.exit(1);
	}
}
