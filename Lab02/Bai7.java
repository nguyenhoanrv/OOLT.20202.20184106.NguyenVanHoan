import java.util.Scanner;

import javax.swing.JOptionPane;

public class Bai7 {
	static 	Scanner in = new Scanner(System.in); 
	public static void main(String args[]){  
		int a[][]={{1,3,100,6},{2,47,4,3},{3,6,4,5}};    
		int b[][]={{1,3,4,68},{2,76,4,3},{1,6,2,4}};    		  
		int op = JOptionPane.showConfirmDialog(null, 
				"Ban muon dung ma tran co san khong?");
		if(op == JOptionPane.YES_OPTION) {
			printResult(a, b);
		} else {
			System.out.println("Nhap so hang cua ma tran: ");
			int x = in.nextInt();
			System.out.println("Nhap so cot cua ma tran: ");
			int y = in.nextInt();
			System.out.println("Nhap ma tran 1: ");
			int mtx1[][] = enterMatric(x, y);
			System.out.println("Nhap ma tran 2: ");
			int mtx2[][] = enterMatric(x, y);
			printResult(mtx1, mtx2);
		}
	}
	
	public static void printResult(int a[][], int b[][]) {
		int rs[][] = new int[a.length][a[0].length];
		System.out.println("Ket qua la: ");
		for(int i = 0; i < a.length; i++){    
			for(int j = 0; j < a[0].length; j++){    
				rs[i][j] = a[i][j] + b[i][j];  
				System.out.print(rs[i][j] + " ");    
			}    
			System.out.println();
		}    

	}
	
	public static int[][] enterMatric(int x, int y) {
		int c[][] = new int[x][y];
		for(int i = 0; i < x; i++){    
			for(int j = 0; j < y; j++){  
				int temp = in.nextInt();
				c[i][j] = temp;
			}
		}
		return c;
	}
}
