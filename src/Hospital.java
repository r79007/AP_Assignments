public class Hospital {

    int pinCode;
    String name;
    int HID;
    static int hID=0;
    {
        hID++;
    }

    public Hospital(String name,int pinCode){
        this.pinCode=pinCode;
        this.name=name;
        this.HID=hID;
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
