package task3;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        convertToUpperCase(null);
    }
    public static void convertToUpperCase(String str){
        try{
            String str1=str.toUpperCase();
            System.out.println("The string in uppercase is: "+str1);
        }
        catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
