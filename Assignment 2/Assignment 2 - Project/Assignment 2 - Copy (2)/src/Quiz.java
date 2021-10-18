import java.util.HashMap;

public class Quiz implements Assessment {
    private String probStatement;
    private String id;
    private int assessmentID;
    private static HashMap<Integer,Quiz> quizHashMap=new HashMap<>();

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
    public void setProblemStatement(String ps) {
        this.probStatement=ps;

    }

    public String getProblemStatement(){
        return this.probStatement;
    }

    public static void setQuizHashMap(int assnID,Quiz qz){
        quizHashMap.put(assnID,qz);
    }

    public static HashMap<Integer,Quiz> getQuizHashMap(){
        return Quiz.getQuizHashMap();
    }

}
