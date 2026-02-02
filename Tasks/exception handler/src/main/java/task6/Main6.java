package task6;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            System.out.println("Enter a number1 ");
            int a=sc.nextInt();
            System.out.println("Enter a number2 ");
            int b=sc.nextInt();
            System.out.println(a/b);
            String str=null;
            convertToUpperCase(str);
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
        catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
    public static void convertToUpperCase(String str){
        String str1=str.toUpperCase();
        System.out.println(str1);
    }
}
