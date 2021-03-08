import java.util.*;  

class Bai5 {
  public static void main(String[] args) {
    java.util.Scanner input = new Scanner (System.in);  
    Double nb1, nb2;
    System.out.println("Enter number one: ");
    nb1 = input.nextDouble();
    System.out.println("Enter number two: ");
    nb2 = input.nextDouble();    
    System.out.printf("Sum: %g\n", nb1+nb2);
    System.out.printf("Difference: %g\n", nb1-nb2);
    System.out.printf("Product: %g\n", nb1*nb2);
    System.out.printf("Quotient: %g\n", nb1/nb2);
  }
}