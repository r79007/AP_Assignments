import java.util.HashMap;

public class Assignment implements Assessment{

    private String probStatement;
    private int marks;
    private String id;
    private int assessmentID;
    private static HashMap<Integer,Assignment> assignmentHashMap=new HashMap<>();

    public int getAssessmentID() {
        return this.assessmentID;
    }

    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }



    @Override
    public void setProblemStatement(String s) {
        this.probStatement=s;
    }

    public String getProbStatement(){
        return this.probStatement;
    }

    public void setMarks(int mark){
        this.marks=mark;
    }

    public int getMarks() {
        return this.marks;
    }

    public static void setAssignmentHashMap(int assessmentID,Assignment assn){
        assignmentHashMap.put(assessmentID,assn);
    }

    public static HashMap<Integer, Assignment> getAssignmentHashMap(){
        return assignmentHashMap;
    }


}
