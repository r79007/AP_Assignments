import java.util.HashMap;

public class Assignment implements Assessment{

    private String probStatement;
    private int marks;
    private String id;
    private int assessmentID;
    private boolean isClosed=false;

    @Override
    public boolean isClosed() {
        return this.isClosed;
    }
    @Override
    public void setClosed(boolean closed) {
        this.isClosed = closed;
    }

    private static HashMap<Integer,Assignment> assignmentHashMap=new HashMap<>();
    @Override
    public int getAssessmentID() {
        return this.assessmentID;
    }


    @Override
    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }
    @Override
    public String getId() {
        return this.id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }



    @Override
    public void setProblemStatement(String s) {
        this.probStatement=s;
    }
    @Override
    public String getProblemStatement(){
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
