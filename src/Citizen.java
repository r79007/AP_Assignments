public class Citizen {
    String name;
    int age;
    int uID;    //Unique ID

    public Citizen(String name,int age,int uID){
        this.name=name;
        this.age=age;
        this.uID=uID;
    }

    public void printCitizen(){
        System.out.println("Citizen Name: Age: Unique ID: Citizen Name: "+this.name+", "+"Age: "+this.age+", "+"Unique ID: "+this.uID);
        if(this.age<=18){
            System.out.println("Only above 18 are allowed");
        }
    }

    public static void main(String[] args) {
        Citizen c=new Citizen("Rohan",17,1);
        c.printCitizen();
    }
}
