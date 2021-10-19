import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Student implements Discussions{
    private static ArrayList<String> Studentcomments=new ArrayList<>();

    public static ArrayList<String> getComments() {
        return Studentcomments;
    }

    public static void setComments(ArrayList<String> comments) {
        Student.Studentcomments = comments;
    }

    private static ArrayList<String> studentList=new ArrayList<>();
    private HashMap<Integer, String> submissions=new HashMap<>();
    //private static ArrayList<Student> studentClassList=new ArrayList<>();
    private static HashMap<String,Student> studentClassHashMap=new HashMap<>();
    //private static HashMap<String, ArrayList<String>> idToTopicsMap=new HashMap<>();
    private String id;

    public HashMap<Integer,String> getSubmissionsMap(){
        return this.submissions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        studentList.add(this.id);

    }

    public static ArrayList<String> getStudentList(){
        return studentList;
    }

    public void setSubmissions(int assessmentID,String filename){
        submissions.put(assessmentID,filename);
    }

    public String getSubmission(int assessmentID){
        return submissions.get(assessmentID);
    }

    public static void setStudentClassList(String id,Student stu){
        studentClassHashMap.put(id,stu);
    }

    public static HashMap<String, Student> getStudentClassList(){
        return studentClassHashMap;
    }

    public ArrayList<Integer> viewPendingAssessments(){
        ArrayList<Integer> check=new ArrayList<>();
        System.out.println("Pending Assessments");
        for(int i=0;i<=Main2.assignmentIDs;i++){
            if((Assignment.getHashMap().containsKey(i) && Assignment.getHashMap().get(i).isClosed()==false) || (Quiz.getHashMap().containsKey(i) && Quiz.getHashMap().get(i).isClosed()==false)) {
                if (submissions.isEmpty() == true || (submissions.isEmpty() == false && !submissions.containsKey(i))) {
                    if (Assignment.getHashMap().containsKey(i)) {
                        System.out.println("ID " + Assignment.getHashMap().get(i).getAssessmentID() + " " + Assignment.getHashMap().get(i).getProblemStatement() + " Max Marks: " + Assignment.getHashMap().get(i).getMarks());
                        check.add(i);
                    } else if (Quiz.getHashMap().containsKey(i)) {
                        System.out.println("ID " + Quiz.getHashMap().get(i).getAssessmentID() + " " + Quiz.getHashMap().get(i).getProblemStatement());
                        check.add(i);
                    }
                }
            }
        }
        return check;
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
        Studentcomments.add(comm);

    }


}
