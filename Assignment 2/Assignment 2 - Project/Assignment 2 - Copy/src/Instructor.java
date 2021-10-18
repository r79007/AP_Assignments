import java.util.ArrayList;
import java.util.HashMap;

public class Instructor extends Lecture{
    private static ArrayList<String> instructorsList=new ArrayList<>();
    //private static HashMap<String, ArrayList<String>> idToTopicsMap=new HashMap<>();
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        instructorsList.add(this.id);
    }

    public static ArrayList<String> getInstructorsList(){
        return instructorsList;
    }


}
