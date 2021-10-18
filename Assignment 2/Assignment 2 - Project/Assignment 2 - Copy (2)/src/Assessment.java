import java.util.HashMap;

public interface Assessment {
    //private static HashMap<Integer,Assessment> assessmentMap=new HashMap<>();
    void setProblemStatement(String s);
    void setId(String id);
    void setAssessmentID(int assessmentID);
    int getAssessmentID();
    String getId();
}
