import java.util.HashMap;

public class Quiz implements Assessment {
    private String probStatement;
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

    private static HashMap<Integer,Quiz> quizHashMap=new HashMap<>();
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
    public void setProblemStatement(String ps) {
        this.probStatement=ps;

    }
    @Override
    public String getProblemStatement(){
        return this.probStatement;
    }

    public static void setQuizHashMap(int assnID,Quiz qz){
        quizHashMap.put(assnID,qz);
    }

    public static HashMap<Integer,Quiz> getQuizHashMap(){
        return quizHashMap;
    }

//    public static void main(String[] args) {
////        Quiz qz=new Quiz();
////        System.out.println(qz.isClosed);
////        qz.setClosed(true);
////        System.out.println(qz.isClosed);
//    }

}
