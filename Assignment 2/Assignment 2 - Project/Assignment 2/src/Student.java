import java.util.ArrayList;
import java.util.HashMap;

public class Student{
    private static ArrayList<String> studentList=new ArrayList<>();
    private HashMap<Integer, String> submissions=new HashMap<>();
    //private static ArrayList<Student> studentClassList=new ArrayList<>();
    private static HashMap<String,Student> studentClassHashMap=new HashMap<>();
    //private static HashMap<String, ArrayList<String>> idToTopicsMap=new HashMap<>();
    private String id;

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

    public void viewPendingAssessments(){
        for(int i=0;i<Main.assignmentIDs;i++){
            if(!submissions.containsKey(i)){
                if(Assignment.getAssignmentHashMap().containsKey(i)){
                    System.out.println("ID "+Assignment.getAssignmentHashMap().get(i).getAssessmentID()+" "+Assignment.getAssignmentHashMap().get(i).getProbStatement()+" Max Marks: "+Assignment.getAssignmentHashMap().get(i).getMarks());
                }else if(Quiz.getQuizHashMap().containsKey(i)){
                    System.out.println("ID "+Quiz.getQuizHashMap().get(i).getAssessmentID()+" "+Quiz.getQuizHashMap().get(i).getProblemStatement());
                }
            }
        }
    }


}
