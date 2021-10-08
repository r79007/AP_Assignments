import java.util.ArrayList;
import java.util.HashMap;

public class Vaccine {
    public static HashMap<String,Vaccine> vaccineMap=new HashMap<>();
    public static ArrayList<String> vaccines=new ArrayList<>();
    String vaxName;
    int totalDoses;
    int gapBwDoses=0;

    public Vaccine(String vaxName, int totalDoses, int gapBwDoses){
        this.vaxName = vaxName;
        this.totalDoses=totalDoses;
        this.gapBwDoses=gapBwDoses;
        vaccines.add(this.vaxName);
        vaccineMap.put(this.vaxName,this);
    }



    public void printVaccine(){
        System.out.println("Vaccine Name: "+this.vaxName +", " + "Number of Doses: "+this.totalDoses+", "+ "Gap Between Doses: "+this.gapBwDoses);
    }

    public static void main(String[] args) {
        //Vaccine v1=new Vaccine("Covax",2,2);
        //System.out.println(vaccineMap.get("Covax").vaxName);

    }

}
