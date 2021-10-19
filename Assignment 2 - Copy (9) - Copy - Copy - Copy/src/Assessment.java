import java.util.HashMap;

public interface Assessment {
    //static HashMap<Integer,Assessment> assessmentMap=new HashMap<>();
    void setProblemStatement(String s);
    String getProblemStatement();
    void setId(String id);
    void setAssessmentID(int assessmentID);
    int getAssessmentID();
    boolean isClosed();
    void setClosed(boolean closed);
    String getId();
    int getMarks();
    void setMarks(int mark);
//    void setHashMap(int assnID, Assessment qz);
//    HashMap<Integer,Assessment> getHashMap();

}
