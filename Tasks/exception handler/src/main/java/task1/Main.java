package task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Enter first number: ");
            int n = sc.nextInt();
            System.out.print("Enter second number: ");
            int m = sc.nextInt();
            System.out.println(n/m);
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
}