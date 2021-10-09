import java.util.HashMap;

public class VaccinationStatus {
    public static HashMap<Long,VaccinationStatus> vaxStatusMap=new HashMap<>();
    long uID;
    String vax;
    int numDosesGiven=0;

    public VaccinationStatus(long uID,String vax,int numDosesGiven){
        this.uID=uID;
        this.vax=vax;
        this.numDosesGiven+=1;
        vaxStatusMap.put(this.uID,this);
    }
    public void increaseDose(){
        this.numDosesGiven+=1;
    }
    public void numDosesRemaining(){

    }

}
