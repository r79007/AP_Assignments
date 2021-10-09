import java.util.HashMap;

public class VaccinationStatus {
    public static HashMap<Long,VaccinationStatus> vaxStatusMap=new HashMap<>();
    long uID;
    String vax;
    int numDosesGiven=0;

    public VaccinationStatus(long uID,String vax){
        this.uID=uID;
        this.vax=vax;
        this.numDosesGiven+=1;
        vaxStatusMap.put(this.uID,this);
    }
    public void giveDose(){
        this.numDosesGiven+=1;
    }
    public int numDosesRemaining(){
        return Vaccine.vaccineMap.get(this.vax).totalDoses-this.numDosesGiven;
    }

    public int dueDate(){
        return Vaccine.vaccineMap.get(this.vax).gapBwDoses;
    }

    public void printVaxStatus(){
        if(this.numDosesRemaining()!=0){
            System.out.println("PARTIALLY VACCINATED");
        }else{
            System.out.println("FULLY VACCINATED");
        }
        System.out.println("Vaccine Given: "+this.vax);
        System.out.println("Number of Doses given: "+this.numDosesGiven);
        System.out.println();
    }


}
