package task4;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5};
        Scanner sc=new Scanner(System.in);
        try{
            System.out.println("Enter an index");
            int index=sc.nextInt();
            System.out.println("The value of index is: "+arr[index]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}
