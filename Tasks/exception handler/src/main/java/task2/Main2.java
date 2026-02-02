package task2;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Enter number in a String: ");
            String str = sc.nextLine();
            int num = Integer.parseInt(str);
            System.out.println("number: " + num);
        }
        catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }
}
