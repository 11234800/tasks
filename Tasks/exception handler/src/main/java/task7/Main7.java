package task7;

import java.util.Scanner;

public class Main7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter your age");
            int age = sc.nextInt();
            checkUserAge(age);
        }
        catch(InvalidAgeException e){
            System.out.println(e.getMessage());
        }
    }
    public static void checkUserAge(int age) throws InvalidAgeException {
        if(age<18)
        {
            throw new InvalidAgeException("Invalid age");
        }
        System.out.println("age is "+age);
    }
}
