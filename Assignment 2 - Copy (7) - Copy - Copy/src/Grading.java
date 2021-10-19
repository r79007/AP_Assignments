import java.util.ArrayList;
import java.util.HashMap;

public class Grading {
    private String stuID;
    private String instID;
    private int assessID;
    private static HashMap<String, ArrayList<Grading>> studentToGradingMap =new HashMap<>();
    //private static HashMap<Integer,ArrayList<String>> assmIDtoStudentIDMap=new HashMap<>();

    public static HashMap<String, ArrayList<Grading>> getStudentToGradingMap() {
        return studentToGradingMap;
    }

    public static void setStudentToGradingMap(HashMap<String, ArrayList<Grading>> studentToGradingMap) {
        Grading.studentToGradingMap = studentToGradingMap;
    }

    public String getStuID() {
        return this.stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
        if(!studentToGradingMap.containsKey(this.stuID)) {
            ArrayList<Grading> arr = new ArrayList<>();
            arr.add(this);
            studentToGradingMap.put(this.stuID, arr);
        }else{
            studentToGradingMap.get(this.stuID).add(this);
        }
    }

    public static ArrayList<Integer> getUngradedSubmissions(int assID){
        ArrayList<Integer> ids=new ArrayList<>();
        for(int i=0;i<Student.getStudentList().size();i++){
            boolean flag=true;
            if(studentToGradingMap.get(Student.getStudentList().get(i))!=null) {
                for (Grading g : studentToGradingMap.get(Student.getStudentList().get(i))) {
                    if (assID == g.assessID) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag==true && Student.getStudentClassList().get(Student.getStudentList().get(i)).getSubmissionsMap().containsKey(assID)){
                System.out.println(i+ " " +Student.getStudentList().get(i));
                ids.add(i);
            }
        }
        return ids;
    }

    public String getInstID() {
        return this.instID;
    }

    public void setInstID(String instID) {
        this.instID = instID;
    }

    public int getAssessID() {
        return this.assessID;
    }

    public void setAssessID(int assessID) {
        this.assessID = assessID;

    }

    public Assignment getAssn() {
        return this.assn;
    }

    public void setAssn(Assignment assn) {
        this.assn = assn;
    }


    private Assignment assn=null;
    private int marksAwarded;
    private Quiz qz=null;

    public Quiz getQz() {
        return this.qz;
    }

    public void setQz(Quiz qz) {
        this.qz = qz;
    }

    public void setMarksAwarded(int givenMarks){
        this.marksAwarded=givenMarks;
    }

    public int getMarksAwarded(){
        return this.marksAwarded;
    }




}
