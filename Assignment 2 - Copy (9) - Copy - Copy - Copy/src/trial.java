import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class trial {
    private String car;
    private int speed;
    static ArrayList<trial> arr=new ArrayList<>();



    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
        //map.put(this.car,)
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;

    }

    public static void main(String[] args) {
//        trial t=new trial();
//        arr.add(t);
//        t.setCar("BMW");
//
//        t.setSpeed(100);
//        System.out.println(arr.get(0).getSpeed());
//        HashMap<Integer,String> map=new HashMap<>();
//        System.out.println(map.containsKey(2));

//        String name="Rohan\n";
//        name+="Kulkarni";
//        System.out.println(name);

        HashMap<Integer,String> map=new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");




    }




}
