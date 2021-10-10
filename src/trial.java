import java.util.ArrayList;
import java.util.Scanner;

public class trial {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name: ");
        String s="";
        s+=sc.nextLine();
        System.out.print("Enter age: ");
        int age=sc.nextInt();
        System.out.println(s+" "+age);
    }
}
