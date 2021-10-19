import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Instructor implements Discussions{
    private static ArrayList<String> instructorsList=new ArrayList<>();
    private static ArrayList<String> instructorComments=new ArrayList<>();
    private static HashMap<String,Instructor> idToInstructorMap=new HashMap<>();

    public static HashMap<String, Instructor> getIdToInstructorMap() {
        return idToInstructorMap;
    }

    public static void setIdToInstructorMap(HashMap<String, Instructor> idToInstructorMap) {
        Instructor.idToInstructorMap = idToInstructorMap;
    }

    public static ArrayList<String> getInstructorComments() {
        return instructorComments;
    }

    public static void setInstructorComments(ArrayList<String> instructorComments) {
        Instructor.instructorComments = instructorComments;
    }

    //private static HashMap<String, ArrayList<String>> idToTopicsMap=new HashMap<>();
    private static HashMap<String, ArrayList<Lecture>> instructorToLectureMap=new HashMap<>();
    private static HashMap<String, ArrayList<Video>> instructorToLectureVideoMap=new HashMap<>();
    private static HashMap<String, ArrayList<Assignment>> instructorToAssignmentMap=new HashMap<>();
    private static HashMap<String, ArrayList<Quiz>> instructorToQuizMap=new HashMap<>();
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        instructorsList.add(this.id);
        idToInstructorMap.put(this.id,this);
    }

    public static ArrayList<String> getInstructorsList(){
        return instructorsList;
    }

    public static void setInstructorToLectureMap(String iden,Lecture l){
        if(instructorToLectureMap!=null){
            if(instructorToLectureMap.get(iden)!=null){
                instructorToLectureMap.get(iden).add(l);
            }else{
                ArrayList<Lecture> lectArr=new ArrayList<>();
                lectArr.add(l);
                instructorToLectureMap.put(iden,lectArr);
            }
        }else{
            ArrayList<Lecture> lectArr=new ArrayList<>();
            lectArr.add(l);
            instructorToLectureMap.put(iden,lectArr);
        }
    }

    public static ArrayList<Lecture> getInstructorToLectureMap(String iden){
        return instructorToLectureMap.get(iden);
    }

    public static void setInstructorToLectureVideoMap(String iden,Video v){
        if(instructorToLectureVideoMap!=null){
            if(instructorToLectureVideoMap.get(iden)!=null){
                instructorToLectureVideoMap.get(iden).add(v);
            }else{
                ArrayList<Video> lectArr=new ArrayList<>();
                lectArr.add(v);
                instructorToLectureVideoMap.put(iden,lectArr);
            }
        }else{
            ArrayList<Video> lectArr=new ArrayList<>();
            lectArr.add(v);
            instructorToLectureVideoMap.put(iden,lectArr);
        }
    }

    public static ArrayList<Video> getInstructorToLectureVideoMap(String iden){
        return instructorToLectureVideoMap.get(iden);
    }

    public static void setInstructorToAssignmentMap(String iden,Assignment assn){
        if(instructorToAssignmentMap!=null){
            if(instructorToAssignmentMap.get(iden)!=null){
                instructorToAssignmentMap.get(iden).add(assn);
            }else{
                ArrayList<Assignment> lectArr=new ArrayList<>();
                lectArr.add(assn);
                instructorToAssignmentMap.put(iden,lectArr);
            }
        }else{
            ArrayList<Assignment> lectArr=new ArrayList<>();
            lectArr.add(assn);
            instructorToAssignmentMap.put(iden,lectArr);
        }
    }

    public static ArrayList<Assignment> getAssignments(String iden){
        return instructorToAssignmentMap.get(iden);
    }

    public static void setInstructorToQuizMap(String iden,Quiz assn){
        if(instructorToQuizMap!=null){
            if(instructorToQuizMap.get(iden)!=null){
                instructorToQuizMap.get(iden).add(assn);
            }else{
                ArrayList<Quiz> lectArr=new ArrayList<>();
                lectArr.add(assn);
                instructorToQuizMap.put(iden,lectArr);
            }
        }else{
            ArrayList<Quiz> lectArr=new ArrayList<>();
            lectArr.add(assn);
            instructorToQuizMap.put(iden,lectArr);
        }
    }

    public static ArrayList<Quiz> getQuizzes(String iden){
        return instructorToQuizMap.get(iden);
    }


    @Override
    public void addComments(String comment) {
        String comm=comment;
        comm+=" - "+this.id+"\n";
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter modifiedTime = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss yyyy");
        String newTime = time.format(modifiedTime);
        newTime+=" IST";
        comm+=newTime;
        instructorComments.add(comm);
    }
}
