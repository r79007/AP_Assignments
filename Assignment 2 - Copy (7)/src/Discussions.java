import java.util.ArrayList;
import java.util.HashMap;

public interface Discussions {
    //ArrayList<String> comments=new ArrayList<>();
    void addComments(String comment);
    static void viewComments(){
        if(Student.getComments()!=null && Student.getComments().size()!=0) {
            for (String s : Student.getComments()) {
                System.out.println(s);
            }
        }
        System.out.println();
        if(Instructor.getInstructorComments()!=null && Instructor.getInstructorComments().size()!=0) {
            for (String str : Instructor.getInstructorComments()) {
                System.out.println(str);
            }
        }
    }


}
