import java.util.HashMap;

public class Quiz implements Assessment {
    private String probStatement;
    private String id;
    private int assessmentID;
    private boolean isClosed=false;
    private int maxMarks=1;

    @Override
    public boolean isClosed() {
        return this.isClosed;
    }
    @Override
    public void setClosed(boolean closed) {
        this.isClosed = closed;
    }

    private static HashMap<Integer,Assessment> quizHashMap=new HashMap<>();
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
    public int getMarks() {
        return this.maxMarks;
    }

    @Override
    public void setMarks(int mark) {
        this.maxMarks=mark;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setProblemStatement(String ps) {
        this.probStatement=ps;

    }
    @Override
    public String getProblemStatement(){
        return this.probStatement;
    }

    public static void setHashMap(int assnID, Assessment qz){
        quizHashMap.put(assnID,qz);
    }

    public static HashMap<Integer,Assessment> getHashMap(){
        return quizHashMap;
    }

//    public static void main(String[] args) {
////        Quiz qz=new Quiz();
////        System.out.println(qz.isClosed);
////        qz.setClosed(true);
////        System.out.println(qz.isClosed);
//    }

}
