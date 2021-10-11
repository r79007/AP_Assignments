import java.util.ArrayList;
import java.util.HashMap;

public class VaccinationStatus {
    public static HashMap<Long,VaccinationStatus> vaxStatusMap=new HashMap<>();
    public static HashMap<Long,Integer> dueDateMap=new HashMap<>();

    long uID;
    String vax;
    int numDosesGiven=0;
    HospitalSlot hs;

    public VaccinationStatus(long uID,String vax,HospitalSlot hs){
        this.uID=uID;
        this.vax=vax;
        this.numDosesGiven=0;
        this.hs=hs;
        vaxStatusMap.put(this.uID,this);
    }
    public void giveDose(){
        this.numDosesGiven+=1;
        //this.hs.quantity--;
        //HospitalSlot.vaxToHospMap.put(HospitalSlot.vaxToHospMap.get(this.hs.HospitalID),
//        ArrayList<HospitalSlot> newList=HospitalSlot.HospitalSlotMap2.get(this.hs.HospitalID);
//        if(newList!=null){
//            for(int i=0;i< newList.size();i++){
//                if(newList.get(i).HospitalID==this.hs.HospitalID && newList.get(i).vax.equals(this.hs.vax) && newList.get(i).dayNumber==this.hs.dayNumber){
//                    //newList.get(i).quantity=this.hs.quantity;
//                    newList.get(i).quantity--;
//                }
//            }
//            HospitalSlot.HospitalSlotMap2.put(this.hs.HospitalID,newList);
//        }

//        ArrayList<Quantity> arrli=HospitalSlot.slotQuantityMap.get(this.hs.HospitalID);
//        for(int i=0;i<HospitalSlot.slotQuantityMap.get(this.hs.HospitalID).size();i++){
//            if(arrli.get(i).dayNumber== this.hs.dayNumber && arrli.get(i).vax.equals(this.hs.vax)){
//                int qua=arrli.get(i).quant;
//                qua--;
//                arrli.get(i).quant=qua;
//            }
//        }
        //Quantity2 q=new Quantity2(this.hs.HospitalID,this.vax,this.hs.dayNumber);
//        int Quantityf=-1;
//        for(Quantity2 j:HospitalSlot.slotQuantityMap2.keySet()){
//            if(j.hospitID==this.hs.HospitalID && j.vaxi.equals(this.vax) && j.dayNumber==this.hs.dayNumber){
//                Quantityf=HospitalSlot.slotQuantityMap2.get(j);
//                Quantityf--;
//                HospitalSlot.slotQuantityMap2.put(j,Quantityf);
//                break;
//            }
//        }

        vaxStatusMap.put(this.uID,this);
        //int Quantityf=HospitalSlot.slotQuantityMap2.get(q);



    }
    public int numDosesRemaining(){

        return Vaccine.vaccineMap.get(this.vax).totalDoses-this.numDosesGiven;
    }

    public int dueDate(){
        return Vaccine.vaccineMap.get(this.vax).gapBwDoses+this.hs.dayNumber;
    }

    public void printVaxStatus(){
        if(this.numDosesRemaining()!=0){
            System.out.println("PARTIALLY VACCINATED");
            System.out.println("Vaccine Given: "+this.vax);
            System.out.println("Number of Doses given: "+this.numDosesGiven);
            if(Vaccine.vaccineMap.get(this.vax).gapBwDoses!=1 && Vaccine.vaccineMap.get(this.vax).gapBwDoses!=0) {  //change
                System.out.println("Next Dose due date: " + dueDateMap.get(this.uID));
            }
        }else{
            System.out.println("FULLY VACCINATED");
            System.out.println("Vaccine Given: "+this.vax);
            System.out.println("Number of Doses given: "+this.numDosesGiven);
        }
//        System.out.println("Vaccine Given: "+this.vax);
//        System.out.println("Number of Doses given: "+this.numDosesGiven);
//        if(this.numDosesRemaining()!=0 || (Vaccine.vaccineMap.get(this.vax).gapBwDoses!=1 && Vaccine.vaccineMap.get(this.vax).gapBwDoses!=0)) {  //change
//            System.out.println("Next Dose due date: " + dueDateMap.get(this.uID));
//        }
    }


}
