package task5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        try{
            File file=new File("data.txt");
            Scanner sc=new Scanner(file);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
