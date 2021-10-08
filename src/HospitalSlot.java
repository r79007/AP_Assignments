import java.util.ArrayList;
import java.util.HashMap;

public class HospitalSlot {
    public static HashMap<Integer, HospitalSlot> HospitalSlotMap=new HashMap<>();
    public static HashMap<Integer, ArrayList<HospitalSlot>> HospitalSlotMap2=new HashMap<>();
    public static HashMap<String, ArrayList<Integer>> vaxToHospMap=new HashMap<>();
    int HospitalID;
    int numberOfSlots=0;
    int dayNumber;
    int quantity;
    String vax;

    public HospitalSlot(int numberOfSlots,int dayNumber,int quantity,String vax,int HospitalID){

        this.dayNumber=dayNumber;
        this.quantity=quantity;
        this.vax=vax;
//        this.nameQuantity.nameOfVaccine=vax;
//        this.nameQuantity.availableQuantity+=quantity;
        this.HospitalID=HospitalID;
        if(vaxToHospMap.containsKey(this.vax)){
            vaxToHospMap.get(this.vax).add(this.HospitalID);
        }else{
            ArrayList<Integer> newArr=new ArrayList<>();
            newArr.add(this.HospitalID);
            vaxToHospMap.put(this.vax,newArr);
        }
        this.numberOfSlots+=numberOfSlots;


    }

    public void addHospitalSlot(){

        //HospitalSlotMap.put(HospitalID,new HospitalSlot(numberOfSlots,dayNumber,quantity,vax,HospitalID));
        if(!HospitalSlotMap2.containsKey(this.HospitalID)) {
            ArrayList<HospitalSlot> newAr = new ArrayList<>();
            newAr.add(this);
            HospitalSlotMap2.put(this.HospitalID, newAr);
        }else{
            HospitalSlotMap2.get(this.HospitalID).add(this);
        }
        HospitalSlotMap.put(HospitalID,this);
    }

    public void printHospitalSlot(){
        System.out.println("Slot added by Hospital " + this.HospitalID+ " for Day: "+this.dayNumber+", "+ "Available Quantity: "+this.quantity+ " of Vaccine "+this.vax);
    }

    public static void main(String[] args) {
        HospitalSlot h1=new HospitalSlot(2,1,5,"Covax",123456);
        h1.addHospitalSlot();
        System.out.println(HospitalSlotMap.get(123456).vax);
        HospitalSlot h2=new HospitalSlot(2,1,5,"Covi",123455);
        h2.addHospitalSlot();
        System.out.println(HospitalSlotMap.get(123455).vax);


    }

}
