package task10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        try{
            readFile();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void readFile() throws IOException {
        File file=new File("data.txt");
        if(!file.exists()){
            throw new IOException("File not found");
        }
        Scanner sc=new Scanner(file);
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }
}
