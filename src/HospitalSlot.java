import java.util.ArrayList;
import java.util.HashMap;

public class HospitalSlot {
    public static HashMap<Integer, HospitalSlot> HospitalSlotMap=new HashMap<>();
    public static HashMap<Integer, ArrayList<HospitalSlot>> HospitalSlotMap2=new HashMap<>();
    public static HashMap<String, ArrayList<Integer>> vaxToHospMap=new HashMap<>();
    public static HashMap<Integer,ArrayList<Quantity>> slotQuantityMap=new HashMap<>();
    public static HashMap<Quantity2,Integer> slotQuantityMap2=new HashMap<>();
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

        this.numberOfSlots+=numberOfSlots;
        Quantity quantity1=new Quantity(this.dayNumber,this.vax,this.quantity);
        ArrayList<Quantity> arrl=new ArrayList<>();
        arrl.add(quantity1);
        if(!slotQuantityMap.containsKey(this.HospitalID)){
            slotQuantityMap.put(this.HospitalID,arrl);
        }else{
            ArrayList<Quantity> qnew=slotQuantityMap.get(this.HospitalID);
            qnew.add(quantity1);
            slotQuantityMap.put(this.HospitalID,qnew);
        }
        Quantity2 q2=new Quantity2(this.HospitalID,this.vax,this.dayNumber);
        slotQuantityMap2.put(q2,this.quantity);
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

        if(vaxToHospMap.containsKey(this.vax)){
            vaxToHospMap.get(this.vax).add(this.HospitalID);
        }else{
            ArrayList<Integer> newArr=new ArrayList<>();
            newArr.add(this.HospitalID);
            vaxToHospMap.put(this.vax,newArr);
        }
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
