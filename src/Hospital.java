import java.util.ArrayList;
import java.util.HashMap;

public class Hospital {
    public static HashMap<Integer, ArrayList<Hospital>> pinCodeMap=new HashMap<>();

    int pinCode;
    String name;
    long HID;
    static long hID=100000;

    {
        hID++;
    }

    public Hospital(String name,int pinCode){
        this.pinCode=pinCode;
        this.name=name;
        this.HID=hID;
        if(!pinCodeMap.containsKey(this.pinCode)){
            ArrayList<Hospital> newArr=new ArrayList<>();
            newArr.add(this);
            pinCodeMap.put(this.pinCode,newArr);
        }else{
            pinCodeMap.get(this.pinCode).add(this);
        }


    }

    public void printHospital(){
        System.out.println("Hospital Name: "+this.name+", "+ "PinCode: "+this.pinCode+", "+"Unique ID: "+this.HID);
    }

    public static void main(String[] args) {
        Hospital h1=new Hospital("AIIMS",248001);

        Hospital h2=new Hospital("Medanta",110010);
        h1.printHospital();
        h2.printHospital();
    }

}
