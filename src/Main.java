
import java.util.Scanner;

public class Main {

    public static void addVaccine(String name,int numDoses,int gap){
        Vaccine v1=new Vaccine(name,numDoses,gap);
        v1.printVaccine();
    }
    public static void main(String[] args) {
        System.out.println("CoWin Portal initialized....\n" +
                "---------------------------------\n" +
                "1. Add Vaccine\n" +
                "2. Register Hospital\n" +
                "3. Register Citizen\n" +
                "4. Add Slot for Vaccination\n" +
                "5. Book Slot for Vaccination\n" +
                "6. List all slots for a hospital\n" +
                "7. Check Vaccination Status\n" +
                "8. Exit\n" +
                "---------------------------------");

        Scanner sc=new Scanner(System.in);
        int ip=sc.nextInt();
        while(ip!=8){
            if(ip==1){
                System.out.print("Vaccine Name: ");
                String name=sc.next();
                System.out.print("Number of Doses: ");
                int numDoses=sc.nextInt();
                System.out.print("Gap between doses: ");
                int gap;
                if(numDoses<2){
                    gap=0;
                }else {
                    gap = sc.nextInt();
                }
                addVaccine(name,numDoses,gap);
            }
            System.out.println("---------------------------------");
         ip=sc.nextInt();
        }


    }

}
