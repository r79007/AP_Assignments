
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
        }else if(age<18){
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
                if ((hslotArr.get(i).dayNumber == dayNumber) && hslotArr.get(i).vax.equals(vax)) {
                    System.out.println("There already exists a slot for this vaccine in this hospital for this day.");
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
        ArrayList<Quantity> quantityArrayList=HospitalSlot.slotQuantityMap.get(hosID);
        ArrayList<Integer> options=new ArrayList<>();
        if(quantityArrayList!=null){
            Quantity2 q2;
            int quan=-1;
            for(int i=0;i<hospitalSlotArrayList.size();i++){
                //q2=new Quantity2(hosID,hospitalSlotArrayList.get(i).vax,hospitalSlotArrayList.get(i).dayNumber);
                for(Quantity2 j:HospitalSlot.slotQuantityMap2.keySet()){
                    if(j.hospitID==hosID && j.vaxi.equals(hospitalSlotArrayList.get(i).vax) && j.dayNumber==hospitalSlotArrayList.get(i).dayNumber){
                        quan=HospitalSlot.slotQuantityMap2.get(j);
                        break;
                    }
                }
                //int quan=HospitalSlot.slotQuantityMap2.get(q2);
                System.out.println(i+"-> "+"Day: "+hospitalSlotArrayList.get(i).dayNumber+" "+"Vaccine: "+hospitalSlotArrayList.get(i).vax+" Available Qty: "+quan);
                options.add(i);
            }
            return options;

        }else{
            System.out.println("No slots available");
            return null;
        }

    }
    public static ArrayList<Integer> listAllSlotsByPin(int hosID,long uniqueID){
        ArrayList<HospitalSlot> hospitalSlotArrayList=HospitalSlot.HospitalSlotMap2.get(hosID);
        ArrayList<Integer> options=new ArrayList<>();
        if(hospitalSlotArrayList!=null){
            Quantity2 q2;
            int quan=-1;
            for(int i=0;i<hospitalSlotArrayList.size();i++) {
                if (VaccinationStatus.vaxStatusMap.get(uniqueID)==null) {
                    for(Quantity2 j:HospitalSlot.slotQuantityMap2.keySet()){
                        if(j.hospitID==hosID && j.vaxi.equals(hospitalSlotArrayList.get(i).vax) && j.dayNumber==hospitalSlotArrayList.get(i).dayNumber){
                            quan=HospitalSlot.slotQuantityMap2.get(j);
                            break;
                        }
                    }
                    System.out.println(i + "-> " + "Day: " + hospitalSlotArrayList.get(i).dayNumber + " " + "Vaccine: " + hospitalSlotArrayList.get(i).vax + " Available Qty: " + quan);
                    options.add(i);
                }else if(VaccinationStatus.vaxStatusMap.get(uniqueID).dueDate() == hospitalSlotArrayList.get(i).dayNumber){
//                    System.out.println(i + "-> " + "Day: " + hospitalSlotArrayList.get(i).dayNumber + " " + "Vaccine: " + hospitalSlotArrayList.get(i).vax + " Available Qty: " + hospitalSlotArrayList.get(i).quantity);
                    for(Quantity2 j:HospitalSlot.slotQuantityMap2.keySet()){
                        if(j.hospitID==hosID && j.vaxi.equals(hospitalSlotArrayList.get(i).vax) && j.dayNumber==hospitalSlotArrayList.get(i).dayNumber){
                            quan=HospitalSlot.slotQuantityMap2.get(j);
                            break;
                        }
                    }
                    System.out.println(i + "-> " + "Day: " + hospitalSlotArrayList.get(i).dayNumber + " " + "Vaccine: " + hospitalSlotArrayList.get(i).vax + " Available Qty: " + quan);

                    options.add(i);
                }
            }
            return options;

        }else{
            System.out.println("No slots available");
            return null;
        }

    }
    public static ArrayList<Integer> listAllSlotsByVax(int hosID,String vaxName,long uniqueID) {
        ArrayList<HospitalSlot> hospitalSlotArrayList = HospitalSlot.HospitalSlotMap2.get(hosID);
        ArrayList<Integer> options = new ArrayList<>();

        if (hospitalSlotArrayList != null) {
            Quantity2 q2;
            int quan=-1;

            for (int i = 0; i < hospitalSlotArrayList.size(); i++) {
                if (hospitalSlotArrayList.get(i).vax.equals(vaxName) && (VaccinationStatus.vaxStatusMap.get(uniqueID)==null)) {
                    for(Quantity2 j:HospitalSlot.slotQuantityMap2.keySet()){
                        if(j.hospitID==hosID && j.vaxi.equals(hospitalSlotArrayList.get(i).vax) && j.dayNumber==hospitalSlotArrayList.get(i).dayNumber){
                            quan=HospitalSlot.slotQuantityMap2.get(j);
                            break;
                        }
                    }
                    System.out.println(i + "-> " + "Day: " + hospitalSlotArrayList.get(i).dayNumber + " " + "Vaccine: " + hospitalSlotArrayList.get(i).vax + " Available Qty: " + quan);
                    options.add(i);
                }else if(hospitalSlotArrayList.get(i).vax.equals(vaxName) && (VaccinationStatus.vaxStatusMap.get(uniqueID).dueDate()==hospitalSlotArrayList.get(i).dayNumber)){
                    for(Quantity2 j:HospitalSlot.slotQuantityMap2.keySet()){
                        if(j.hospitID==hosID && j.vaxi.equals(hospitalSlotArrayList.get(i).vax) && j.dayNumber==hospitalSlotArrayList.get(i).dayNumber){
                            quan=HospitalSlot.slotQuantityMap2.get(j);
                            break;
                        }
                    }
                    System.out.println(i + "-> " + "Day: " + hospitalSlotArrayList.get(i).dayNumber + " " + "Vaccine: " + hospitalSlotArrayList.get(i).vax + " Available Qty: " + quan);
                    options.add(i);
                }
            }
            return options;

        } else {
            System.out.println("No slots available");
            return null;
        }
    }
    public static ArrayList<Integer> addSlotByVaccine(String vaxName){
            ArrayList<Integer> arrayList=HospitalSlot.vaxToHospMap.get(vaxName);
            ArrayList<Integer> arr=new ArrayList<>();
            if(arrayList!=null){
                for(int i=0;i<arrayList.size();i++){
                    System.out.println(arrayList.get(i)+" "+Hospital.IDtoHospitalMap.get(arrayList.get(i)));
                    arr.add(i);
                }



            }else{
                System.out.println("No hospitals available");
            }
            return arr;
    }
    public static void listAllSlotsByPinCode(int pinCode,long uniqueID){
        ArrayList<Hospital> arr=Hospital.pinCodeMap.get(pinCode);
        for(int i=0;i<arr.size();i++){

            System.out.println(arr.get(i).HID+" "+arr.get(i).name);
        }
    }
    public static void giveVaccine(long uniqueID,HospitalSlot hs){
        if(VaccinationStatus.vaxStatusMap.containsKey(uniqueID)){
            if(hs.vax.equals(VaccinationStatus.vaxStatusMap.get(uniqueID).vax)){
                if(VaccinationStatus.vaxStatusMap.get(uniqueID).numDosesRemaining()!=0){
                    VaccinationStatus.vaxStatusMap.get(uniqueID).giveDose();
                    System.out.println(Citizen.citizenMap.get(uniqueID).name+" vaccinated with "+hs.vax);
                }
                else{
                    System.out.println("Citizen is already fully vaccinated");
                }
            }else{
                System.out.println("Two different vaccines cannot be given to the same citizen or the the citizen is already vaccinated");
            }
        }else{
            VaccinationStatus vs=new VaccinationStatus(uniqueID,hs.vax,hs);

            System.out.println(Citizen.citizenMap.get(uniqueID).name+" vaccinated with "+hs.vax);
        }

    }
    public static void getVaxStatus(long uid){
        VaccinationStatus vs=VaccinationStatus.vaxStatusMap.get(uid);
        if(vs!=null) {
            vs.printVaxStatus();
        }else{
            if(Citizen.citizenMap.containsKey(uid)) {
                System.out.println("Citizen REGISTERED");
            }else{
                System.out.println("Not REGISTERED");
            }
        }
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
                sc.nextLine();
                String name=sc.nextLine();

                System.out.print("Number of Doses: ");
                int numDoses=sc.nextInt();
                sc.nextLine();
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
                sc.nextLine();
                String hospitalName=sc.nextLine();


                System.out.print("PinCode: ");

                int pinCode= sc.nextInt();
                sc.nextLine();
                registerHospital(hospitalName,pinCode);
            }else if(ip==3){
                System.out.print("Citizen Name: ");
                sc.nextLine();
                String citName=sc.nextLine();

                System.out.print("Age: ");

                int age=sc.nextInt();
                sc.nextLine();
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
                    System.out.print("Enter Quantity: ");
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
                if(Citizen.citizenMap.containsKey(uniqueID)) {

                    System.out.println(1 + ". " + "Search by area");
                    System.out.println(2 + ". " + "Search by Vaccine");
                    System.out.println(3 + ". " + "Exit");
                    System.out.print("Enter option: ");
                    int opt = sc.nextInt();
                    if (opt == 2) {
                        System.out.print("Enter Vaccine name: ");
                        sc.nextLine();
                        String vaxName = sc.nextLine();
                        //sc.nextLine();
                        ArrayList<Integer> opts = addSlotByVaccine(vaxName);
                        if (opts != null && opts.size() != 0) {
                            System.out.print("Enter hospital id: ");

                            int hospID = sc.nextInt();
                            sc.nextLine();
                            ArrayList<Integer> options = listAllSlotsByVax(hospID, vaxName, uniqueID);
                            if (options != null && options.size() != 0) {   //Should be && here
                                System.out.print("Choose Slot: ");
                                int slot = sc.nextInt();
                                HospitalSlot hs = HospitalSlot.HospitalSlotMap2.get(hospID).get(slot);
                                giveVaccine(uniqueID, hs);
                            } else {
                                System.out.println("No slots available");
                            }
                        }
                    } else if (opt == 1) {
                        System.out.print("Enter PinCode: ");
                        int pinCode = sc.nextInt();
                        listAllSlotsByPinCode(pinCode, uniqueID);
                        System.out.print("Enter hospital id: ");
                        int hospID = sc.nextInt();
                        ArrayList<Integer> options = listAllSlotsByPin(hospID, uniqueID);
                        if (options != null && options.size() != 0) {
                            System.out.print("Choose Slot: ");
                            int slot = sc.nextInt();
                            HospitalSlot hs = HospitalSlot.HospitalSlotMap2.get(hospID).get(slot);
                            giveVaccine(uniqueID, hs);
                        } else {
                            System.out.println("No slots available");
                        }
                    }
                }else{
                    System.out.println("Incorrect Unique Citizen ID entered");
                }
            }else if(ip==7){
                System.out.print("Enter Patient ID: ");
                long uid=sc.nextLong();
                getVaxStatus(uid);
            }
            System.out.println("---------------------------------");
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
                    "---------------------------------\n");
         ip=sc.nextInt();
        }


    }

}
