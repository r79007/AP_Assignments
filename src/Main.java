
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void addVaccine(String name,int numDoses,int gap){
        Vaccine v1=new Vaccine(name,numDoses,gap);
        v1.printVaccine();
    }
    public static void registerHospital(String name,int pinCode){
        Hospital h1=new Hospital(name,pinCode);
        h1.printHospital();
    }
    public static void registerCitizen(String name,int age,long uID){
        String countDigits=Long.toString(uID);
        if(countDigits.length()!=12){
            System.out.println("Invalid unique ID entered");
            return;
        }else if(age<=18){
            System.out.println("Citizen Name: Age: Unique ID: Citizen Name: "+name+", "+"Age: "+age+", "+"Unique ID: "+uID);
            System.out.println("Only above 18 are allowed");
        }
        else{
            Citizen cit1=new Citizen(name,age,uID);
            cit1.printCitizen();

        }

    }
    public static void addHospitalSlot(int numberOfSlots,int dayNumber,int quantity,String vax,int HospitalID){
        String countDigits=Long.toString(HospitalID);
        if(countDigits.length()!=6 || Hospital.hID<HospitalID){
            System.out.println("Invalid hospital ID entered");
            return;
        }
        ArrayList<HospitalSlot> hslotArr=HospitalSlot.HospitalSlotMap2.get(HospitalID);
        if(hslotArr!=null) {
            for (int i = 0; i < hslotArr.size(); i++) {
                if (hslotArr.get(i).dayNumber == dayNumber) {
                    System.out.println("There already exists a slot for this hospital for this day.");
                    return;
                }
            }
        }

        HospitalSlot hs1=new HospitalSlot(numberOfSlots,dayNumber,quantity,vax,HospitalID);
        hs1.addHospitalSlot();
        hs1.printHospitalSlot();


    }
    public static ArrayList<Integer> listAllSlots(int hosID){
        ArrayList<HospitalSlot> hospitalSlotArrayList=HospitalSlot.HospitalSlotMap2.get(hosID);
        ArrayList<Integer> options=new ArrayList<>();
        if(hospitalSlotArrayList!=null){
            for(int i=0;i<hospitalSlotArrayList.size();i++){
                System.out.println(i+"-> "+"Day: "+hospitalSlotArrayList.get(i).dayNumber+" "+"Vaccine: "+hospitalSlotArrayList.get(i).vax+" Available Qty: "+hospitalSlotArrayList.get(i).quantity);
                options.add(i);
            }
            return options;

        }else{
            System.out.println("No slots added");
            return null;
        }

    }
    public static ArrayList<Integer> listAllSlotsByVax(int hosID,String vaxName) {
        ArrayList<HospitalSlot> hospitalSlotArrayList = HospitalSlot.HospitalSlotMap2.get(hosID);
        ArrayList<Integer> options = new ArrayList<>();
        if (hospitalSlotArrayList != null) {
            for (int i = 0; i < hospitalSlotArrayList.size(); i++) {
                if (hospitalSlotArrayList.get(i).vax == vaxName) {
                    System.out.println(i + "-> " + "Day: " + hospitalSlotArrayList.get(i).dayNumber + " " + "Vaccine: " + hospitalSlotArrayList.get(i).vax + " Available Qty: " + hospitalSlotArrayList.get(i).quantity);
                    options.add(i);
                }
            }
            return options;

        } else {
            System.out.println("No slots added");
            return null;
        }
    }
    public static void addSlotByVaccine(String vaxName){
            ArrayList<Integer> arrayList=HospitalSlot.vaxToHospMap.get(vaxName);
            if(arrayList!=null){
                for(int i=0;i<arrayList.size();i++){
                    System.out.println(arrayList.get(i)+" "+Hospital.IDtoHospitalMap.get(arrayList.get(i)));
                }



            }
    }
    public static void listAllSlotsByPinCode(int pinCode){
        ArrayList<Hospital> arr=Hospital.pinCodeMap.get(pinCode);
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i).pinCode+" "+arr.get(i).name);
        }
    }
    public static void giveVaccine(long uniqueID,HospitalSlot hs){
        if(VaccinationStatus.vaxStatusMap.containsKey(uniqueID)){
            if(hs.vax.equals(VaccinationStatus.vaxStatusMap.get(uniqueID).vax)){
                if(VaccinationStatus.vaxStatusMap.get(uniqueID).numDosesRemaining()!=0){
                    VaccinationStatus.vaxStatusMap.get(uniqueID).giveDose();
                    System.out.println(Citizen.citizenMap.get(uniqueID).name+" vaccinated with "+hs.vax);
                }else{
                    System.out.println("Citizen is already fully vaccinated");
                }
            }else{
                System.out.println("Two different vaccines cannot be given to the same person");
            }
        }else{
            VaccinationStatus vs=new VaccinationStatus(uniqueID,hs.vax,hs);
            System.out.println(Citizen.citizenMap.get(uniqueID).name+" vaccinated with "+hs.vax);
        }

    }
    public static void getVaxStatus(long uid){
        VaccinationStatus vs=VaccinationStatus.vaxStatusMap.get(uid);
        vs.printVaxStatus();
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
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
            }else if(ip==2){
                System.out.print("Hospital Name: ");
                String hospitalName= sc.next();
                System.out.print("PinCode: ");
                int pinCode= sc.nextInt();
                registerHospital(hospitalName,pinCode);
            }else if(ip==3){
                System.out.print("Citizen Name: ");
                String citName=sc.next();
                System.out.print("Age: ");
                int age=sc.nextInt();
                System.out.print("Unique ID: ");
                long uniqueID=sc.nextLong();
                registerCitizen(citName,age,uniqueID);
            }else if(ip==4){
                System.out.print("Enter Hospital ID: ");
                int hosID=sc.nextInt();
                System.out.print("Enter number of Slots to be added: ");
                int numSlots=sc.nextInt();
                for(int j=0;j<numSlots;j++) {
                    System.out.print("Enter Day Number: ");
                    int dayNum = sc.nextInt();
                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();
                    System.out.println("Select Vaccine");

                    for (int i = 0; i < Vaccine.vaccines.size(); i++) {
                        System.out.println(i + ". " + Vaccine.vaccines.get(i));
                    }
                    int vaccineNum = sc.nextInt();
                    addHospitalSlot(numSlots, dayNum, quantity, Vaccine.vaccines.get(vaccineNum), hosID);
                }
            }else if(ip==6){
                System.out.print("Enter Hospital ID: ");
                int hosID=sc.nextInt();
                listAllSlots(hosID);
            }else if(ip==5){
                System.out.print("Enter patient Unique ID: ");
                long uniqueID=sc.nextLong();


                System.out.println(1+". "+"Search by area");
                System.out.println(2+". "+"Search by Vaccine");
                System.out.println(3+". "+"Exit");
                System.out.print("Enter option: ");
                int opt=sc.nextInt();
                if(opt==2) {
                    System.out.print("Enter Vaccine name: ");
                    String vaxName=sc.next();
                    addSlotByVaccine(vaxName);
                    System.out.print("Enter hospital id: ");
                    int hospID = sc.nextInt();
                    ArrayList<Integer> options = listAllSlotsByVax(hospID,vaxName);
                    System.out.print("Choose Slot: ");
                    int slot = sc.nextInt();
                    HospitalSlot hs = HospitalSlot.HospitalSlotMap2.get(hospID).get(slot);
                    giveVaccine(uniqueID, hs);
                }else if(opt==1){
                    System.out.print("Enter PinCode: ");
                    int pinCode=sc.nextInt();
                    listAllSlotsByPinCode(pinCode);
                    System.out.print("Enter hospital id: ");
                    int hospID = sc.nextInt();
                    ArrayList<Integer> options = listAllSlots(hospID);
                    System.out.print("Choose Slot: ");
                    int slot = sc.nextInt();
                    HospitalSlot hs = HospitalSlot.HospitalSlotMap2.get(hospID).get(slot);
                    giveVaccine(uniqueID, hs);
                }
            }else if(ip==7){
                System.out.print("Enter Patient ID: ");
                long uid=sc.nextLong();
                getVaxStatus(uid);
            }
            System.out.println("---------------------------------");
         ip=sc.nextInt();
        }


    }

}
