import java.util.HashMap;

public interface Assessment {
    //private static HashMap<Integer,Assessment> assessmentMap=new HashMap<>();
    void setProblemStatement(String s);
    String getProblemStatement();
    void setId(String id);
    void setAssessmentID(int assessmentID);
    int getAssessmentID();
    boolean isClosed();
    void setClosed(boolean closed);
    String getId();
}
