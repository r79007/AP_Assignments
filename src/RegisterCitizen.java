public class RegisterCitizen {
    Citizen c;

    public RegisterCitizen(Citizen c){
        c=new Citizen(c.name,c.age,c.uID);
    }

    public static void main(String[] args) {
        Citizen c=new Citizen("Rohan",19,1);
        c.printCitizen();
    }

}
