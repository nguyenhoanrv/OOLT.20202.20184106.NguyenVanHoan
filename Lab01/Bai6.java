import java.util.*;  

class Bai6 {
  public static void main(String[] args) {
    Scanner input = new Scanner (System.in);  
    int s;
    do{
    System.out.print("1. Phuong trinh bac 1\n2. Phuong trinh bac 2\n3. He phuong trinh 2 an\n4. Thoat\n");
    System.out.println("Nhap lua chon: ");
    s= input.nextInt();
    switch(s){
      case 1:
        caseOne();
        break;
      case 2:
        caseTow();
        break;
      case 3:
        caseThree();
        break;
    }

    }while(s != 4);
  }

  public static void caseOne(){
    Scanner input = new Scanner (System.in);
    double a,b;  
    System.out.println("Nhap cac he so theo thu tu 'ax + b = 0'");
    a = input.nextDouble();
    b = input.nextDouble();
    System.out.printf("Ket qua la: x = %f\n\n", -b/a);
  }

  public static void caseTow() {
    Scanner input = new Scanner (System.in);
    double a,b,c, delta;
    System.out.println("Nhap cac he so theo thu tu 'ax^2 + bx + c = 0'");
    a = input.nextDouble();
    b = input.nextDouble();
    c = input.nextDouble();
    delta = Math.pow(b,2) - 4*a*c; 
    if(delta == 0) {
      System.out.printf("Ket qua la: x = %f\n\n", b/(2*a));
    } else {
      double temp = Math.sqrt(delta);
      System.out.printf("Ket qua la: x1 = %f ; x2 = %f\n\n", (-b+temp)/(2*a), (-b-temp)/(2*a));
    }
  }

  public static void caseThree() {
    Scanner input = new Scanner (System.in);
    double a1,b1,c1,a2,b2,c2, D, D1, D2;
    System.out.println("Nhap cac he so phuong trinh 1 theo thu tu 'a1*x1 + b1*x2 = c1'");
    a1 = input.nextDouble();
    b1 = input.nextDouble();
    c1 = input.nextDouble();

    System.out.println("Nhap cac he so phuong trinh 1 theo thu tu 'a2*x2 + b2*x2 = c2'");
    a2 = input.nextDouble();
    b2 = input.nextDouble();
    c2 = input.nextDouble();
    D = a1*b2 - a2*b1;
    if(D == 0) {
    System.out.println("Khong co ket qua cua x\n\n");
    } else {
      D1 = c1*b2 - c2*b1;
      D2 = a1*c2 - a2*c1;
      System.out.printf("Ket qua la: x1 = %f ; x2 = %f\n\n", D1/D, D2/D);
    }
  }
}