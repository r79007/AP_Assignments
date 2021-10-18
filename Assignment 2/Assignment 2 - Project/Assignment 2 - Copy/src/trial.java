import java.util.ArrayList;
import java.util.HashMap;

public class trial {
    String car;
    int speed;
    private static HashMap<String, ArrayList<Integer>> map=new HashMap<>();

    public trial(String car,int speed){
        this.car=car;
        this.speed=speed;
        if(map.get(car)!=null){
            map.get(car).add(speed);
        }else{
            ArrayList<Integer> speedArr=new ArrayList<>();
            speedArr.add(speed);
            map.put(car,speedArr);
        }
    }
}
