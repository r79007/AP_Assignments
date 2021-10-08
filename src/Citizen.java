import java.util.HashMap;

public class Citizen {
    String name;
    int age;
    long uID;    //Unique ID
    public static HashMap<Long,Citizen> citizenMap=new HashMap<>();
    public Citizen(String name,int age,long uID){
        this.name=name;
        this.age=age;
        this.uID=uID;

        citizenMap.put(this.uID,this);
    }

    public void printCitizen(){
        System.out.println("Citizen Name: Age: Unique ID: Citizen Name: "+this.name+", "+"Age: "+this.age+", "+"Unique ID: "+this.uID);
        if(this.age<=18){
            System.out.println("Only above 18 are allowed");
        }
    }

    public static void main(String[] args) {
//        Citizen c=new Citizen("Rohan",17,1);
//        c.printCitizen();

//        Vaccine vax=new Vaccine("Covax",2,2);
//        vax.printVaccine();
    }
}
