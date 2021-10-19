import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int assignmentIDs=0;
    Scanner sc = new Scanner(System.in);

    public static void addInstructor(String id) {
        Instructor inst = new Instructor();
        inst.setId(id);
    }

    public static void addStudent(String id) {
        Student stu = new Student();
        stu.setId(id);
        Student.setStudentClassList(id,stu);
    }

    public static void viewLectureDetails(String iden){
        ArrayList<Lecture> arr=Instructor.getInstructorToLectureMap(iden);
        if(arr!=null && arr.size()!=0) {
            for (Lecture i : arr) {
                System.out.println("Title: " + i.getTopic());
                ArrayList<String> slides = i.getSlides();
                for (int j = 0; j < slides.size(); j++) {
                    System.out.println("Slide " + (j + 1) + ": " + slides.get(j));
                }
                System.out.println("Number of slides: " + i.getNumSlides());
                System.out.println("Date of upload: " + i.getTimeAndDate());
                System.out.println("Uploaded by: " + i.getId());
                System.out.println();
            }
        }

    }

    public static void viewVideoLectureDetails(String iden){
        ArrayList<Video> arr=Instructor.getInstructorToLectureVideoMap(iden);
        if(arr!=null && arr.size()!=0) {
            for (Video i : arr) {
                System.out.println("Title of video: " + i.getVideo());
                String fileName = i.getVideoFileName();
                System.out.println("Video file: "+fileName);
                System.out.println("Date of upload: " + i.getTimeAndDate());
                System.out.println("Uploaded by: " + i.getId());
            }
        }
    }

    public static void viewLectureDetails(){
        ArrayList<String> instructors=Instructor.getInstructorsList();
        for(String i:instructors){
            viewLectureDetails(i);
            System.out.println();
            viewVideoLectureDetails(i);
            System.out.println();
        }

    }
    public static ArrayList<Assessment> viewAssignments(String iden){
        ArrayList<Assessment> arr=Instructor.getAssignments(iden);
        ArrayList<Assessment> check=new ArrayList<>();
        if(arr!=null && arr.size()!=0) {
            for (Assessment i : arr) {
                System.out.println("ID: "+i.getAssessmentID()+" Assignment: "+i.getProblemStatement()+" "+"Max Marks: "+i.getMarks());
                //System.out.println("----------------");
                check.add(i);
                System.out.println();
            }
        }
        return check;
    }
    public static ArrayList<Assessment> viewOpenAssignments(String iden){
        ArrayList<Assessment> arr=Instructor.getAssignments(iden);
        ArrayList<Assessment> check=new ArrayList<>();
        if(arr!=null && arr.size()!=0) {
            for (Assessment i : arr) {
                if(i.isClosed()==false) {
                    System.out.println("ID: " + i.getAssessmentID() + " Assignment: " + i.getProblemStatement() + " " + "Max Marks: " + i.getMarks());
                    //System.out.println("----------------");
                    check.add(i);
                    System.out.println();
                }
            }
        }
        return check;
    }
    public static ArrayList<Assessment> viewQuizzes(String iden){
        ArrayList<Assessment> arr=Instructor.getQuizzes(iden);
        ArrayList<Assessment> check=new ArrayList<>();
        if(arr!=null && arr.size()!=0) {
            for (Assessment i : arr) {
                System.out.println("ID: "+i.getAssessmentID()+" Question: "+i.getProblemStatement());
                //System.out.println("----------------");
                System.out.println();
                check.add(i);
            }
        }
        return check;
    }
    public static ArrayList<Assessment> viewOpenQuizzes(String iden){
        ArrayList<Assessment> arr=Instructor.getQuizzes(iden);
        ArrayList<Assessment> check=new ArrayList<>();
        if(arr!=null && arr.size()!=0) {
            for (Assessment i : arr) {
                if(i.isClosed()==false) {
                    System.out.println("ID: " + i.getAssessmentID() + " Question: " + i.getProblemStatement());
                    //System.out.println("----------------");
                    check.add(i);
                    System.out.println();
                }
            }
        }
        return check;
    }

    public static Boolean viewAssessments(){
        ArrayList<String> instructors=Instructor.getInstructorsList();
        Boolean assnCheck=true;
        Boolean qzCheck=true;
        for(String i:instructors){
            ArrayList<Assessment> arrA=viewAssignments(i);
            if(arrA!=null && arrA.size()!=0){
                assnCheck=false;
            }
            System.out.println("----------------");
            ArrayList<Assessment> arrQ=viewQuizzes(i);
            if(arrQ!=null && arrQ.size()!=0){
                qzCheck=false;
            }
            System.out.println("----------------");
        }
        if(assnCheck==false || qzCheck==false){
            return true;
        }else{
            return false;
        }
    }

    public static Boolean viewOpenAssessments(){
        ArrayList<String> instructors=Instructor.getInstructorsList();
        Boolean checkAssn=true;
        Boolean checkQz=true;
        for(String i:instructors){
            ArrayList<Assessment> arr11=viewOpenAssignments(i);
            if(arr11!=null && arr11.size()!=0){
                checkAssn=false;
            }
            System.out.println("----------------");
            ArrayList<Assessment> arr22=viewOpenQuizzes(i);
            if(arr22!=null && arr22.size()!=0){
                checkQz=false;
            }
            System.out.println("----------------");
        }
        if(checkAssn==false || checkQz==false){
            return true;
        }else{
            return false;
        }
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


//Incase students and instructors have to be added manually
//        System.out.print("Enter number of instructors to add: ");
//        int numInst=sc.nextInt();
//        for(int i=0;i<numInst;i++){
//            System.out.print("Enter id of the instructor: ");
//            String id=sc.next();
//            addInstructor(id);
//            System.out.println();
//        }
//
//        System.out.print("Enter number of Students to add: ");
//        int numStu=sc.nextInt();
//        for(int i=0;i<numStu;i++){
//            System.out.print("Enter id of the student: ");
//            String id2=sc.next();
//            addStudent(id2);
//            System.out.println();
//        }


        for (int i = 0; i < 2; i++) {
            addInstructor("I" + i);
        }

        for(int i=0;i<3;i++){
            addStudent("S"+i);
        }

        System.out.println("Welcome to Backpack\n" +
                "1. Enter as instructor\n" +
                "2. Enter as student\n" +
                "3. Exit");
        int input = sc.nextInt();
        while(input!=3) {
//**********Instructor**************\\
            if (input == 1) {
                System.out.println("Instructors:");
                ArrayList<String> instructors = Instructor.getInstructorsList();
                for (int i = 0; i < instructors.size(); i++) {
                    System.out.println(i + " - " + instructors.get(i));
                }
                System.out.print("Choose id: ");
                int identity = sc.nextInt();
                String inst = Instructor.getInstructorsList().get(identity);
                //int opt = -1;
                System.out.println("Welcome " + inst);
                System.out.println("INSTRUCTOR MENU\n" +
                        "1. Add class material\n" +
                        "2. Add assessments\n" +
                        "3. View lecture materials\n" +
                        "4. View assessments\n" +
                        "5. Grade assessments\n" +
                        "6. Close assessment\n" +
                        "7. View comments\n" +
                        "8. Add comments\n" +
                        "9. Logout");

                int ip = sc.nextInt();
                while (ip != 9) {


                    if (ip == 1) {
                        System.out.println("1. Add Lecture Slide\n" +
                                "2. Add Lecture Video");
                        int lectOption = sc.nextInt();

                        if (lectOption == 1) {
                            Lecture lect = new Lecture();
                            lect.setLectureInstructor(inst);
                            System.out.print("Enter topic of slides: ");
                            sc.nextLine();
                            String topic = sc.nextLine();
                            lect.setTopic(topic);
                            System.out.print("Enter number of slides: ");
                            int numSlides = sc.nextInt();
                            lect.setNumSlides(numSlides);
                            //sc.nextLine();

                            sc.nextLine();
                            System.out.println("Enter content of slides: ");
                            for (int i = 0; i < numSlides; i++) {

                                System.out.print("Content of slide "+(i+1)+": ");
                                //sc.nextLine();
                                String content = sc.nextLine();
                                lect.setSlides(content);
                                //sc.next();
                            }
                            Instructor.setInstructorToLectureMap(inst, lect);
                        } else if (lectOption == 2) {
                            System.out.print("Enter topic of video: ");
                            sc.nextLine();
                            String name = sc.nextLine();
                            System.out.print("Enter filename of video: ");


                            String filename = sc.next();
                            sc.nextLine();
                            //sc.nextLine();
                            if (filename.length() < 4) {
                                System.out.println("Wrong filename entered");
                            } else if (!filename.substring(filename.length() - 4).equals(".mp4")) {
                                System.out.println("Wrong filename entered");
                            } else {
                                Video v = new Video(inst);
                                v.setVideo(name);
                                v.setVideoFileName(filename);
                                Instructor.setInstructorToLectureVideoMap(inst, v);
                            }

                            //getLectureDetails(inst);


                        }
                    } else if (ip == 2) {
                        System.out.println("1. Add Assignment\n" +
                                "2. Add Quiz");
                        int option = sc.nextInt();
                        if (option == 1) {
                            System.out.print("Enter problem statement: ");
                            sc.nextLine();
                            String probStatement = sc.nextLine();
                            Assessment assn = new Assignment();
                            assn.setAssessmentID(assignmentIDs);
                            Assignment.setHashMap(assignmentIDs,assn);
                            assignmentIDs++;
                            assn.setProblemStatement(probStatement);
                            System.out.print("Enter max marks: ");

                            int maxMarks = sc.nextInt();
                            sc.nextLine();
                            assn.setMarks(maxMarks);
                            Instructor.setInstructorToAssignmentMap(inst, assn);


                        } else if (option == 2) {
                            Assessment qz = new Quiz();
                            qz.setId(inst);
                            qz.setAssessmentID(assignmentIDs);
                            Quiz.setHashMap(assignmentIDs,qz);
                            assignmentIDs++;

                            System.out.print("Enter quiz question: ");
                            sc.nextLine();
                            String probStatement = sc.nextLine();
                            qz.setProblemStatement(probStatement);
                            //sc.nextLine();   //change
                            Instructor.setInstructorToQuizMap(inst, qz);

                        }

                    }else if(ip==5){
                        System.out.println("List of assessments");
                        Boolean che=viewAssessments();
                        if(che==true) {
                            System.out.print("Enter ID of assessments to view submissions: ");
                            int assmID = sc.nextInt();
                            System.out.println("Choose ID from these ungraded submissions");
                            ArrayList<Integer> arrlist = Grading.getUngradedSubmissions(assmID);
                            if (arrlist != null && arrlist.size() != 0) {
                                int gradID = sc.nextInt();
                                Student std = Student.getStudentClassList().get(Student.getStudentList().get(gradID));
                                System.out.println("Submissions: " + std.getSubmissionsMap().get(assmID));
                                System.out.println("-------------------------------");
                                if (Assignment.getHashMap().containsKey(assmID)) {

                                    System.out.println("Max Marks: " + Assignment.getHashMap().get(assmID).getMarks());
                                } else if (Quiz.getHashMap().containsKey(assmID)) {
                                    System.out.println("Max Marks: " + 1);
                                } else {
                                    System.out.println("Wrong assessment id entered");
                                }
                                System.out.print("Marks Scored: ");
                                int marksScored = sc.nextInt();
                                Grading g = new Grading();
                                g.setAssessID(assmID);
                                g.setInstID(inst);
                                g.setMarksAwarded(marksScored);
                                g.setStuID(Student.getStudentList().get(gradID));
                                if (Assignment.getHashMap().containsKey(assmID)) {
                                    g.setAssn(Assignment.getHashMap().get(assmID));
                                } else if (Quiz.getHashMap().containsKey(assmID)) {
                                    g.setQz(Quiz.getHashMap().get(assmID));
                                }
                            } else {
                                System.out.println("No ungraded submissions");
                            }
                        }else{
                            System.out.println("No assessments to view");
                        }



                    }else if(ip==6){
                        System.out.println("List of open assignments: ");
                        Boolean che2=viewOpenAssessments();
                        if(che2==true) {
                            System.out.print("Enter id of assignment to be closed: ");
                            int asId = sc.nextInt();
                            if (Assignment.getHashMap().containsKey(asId)) {
                                Assignment.getHashMap().get(asId).setClosed(true);
                            } else if (Quiz.getHashMap().containsKey(asId)) {
                                Quiz.getHashMap().get(asId).setClosed(true);
                            } else {
                                System.out.println("Wrong ID entered");
                            }
                        }else{
                            System.out.println("No assessments to close");
                        }
                    }else if(ip==4){
                        viewAssessments();
                    }else if(ip==7){
                        Discussions.viewComments();
                    }else if(ip==8){
                        System.out.print("Enter comment: ");
                        sc.nextLine();
                        String comment=sc.nextLine();
                        Discussions d1=Instructor.getIdToInstructorMap().get(inst);
                        //Instructor.getIdToInstructorMap().get(inst).addComments(comment);
                        d1.addComments(comment);
                    }else if(ip==3){
                        viewLectureDetails();
                    }
                    System.out.println("----------------------------");
                    System.out.println("Welcome " + inst);
                    System.out.println("INSTRUCTOR MENU\n" +
                            "1. Add class material\n" +
                            "2. Add assessments\n" +
                            "3. View lecture materials\n" +
                            "4. View assessments\n" +
                            "5. Grade assessments\n" +
                            "6. Close assessment\n" +
                            "7. View comments\n" +
                            "8. Add comments\n" +
                            "9. Logout");

                    ip = sc.nextInt();


                }


            } else if (input == 2) {
                System.out.println("Students:");
                ArrayList<String> students = Student.getStudentList();
                for (int i = 0; i < students.size(); i++) {
                    System.out.println(i + " - " + students.get(i));
                }
                System.out.print("Choose id: ");
                int identity = sc.nextInt();
                String student = Student.getStudentList().get(identity);
                //int opt = -1;

                System.out.println("Welcome " + student);
                System.out.println("STUDENT MENU\n" +
                        "1. View lecture materials\n" +
                        "2. View assessments\n" +
                        "3. Submit assessment\n" +
                        "4. View grades\n" +
                        "5. View comments\n" +
                        "6. Add comments\n" +
                        "7. Logout");

                int ip2 = sc.nextInt();
                while (ip2 != 7) {
                    if(ip2==1) {
                        viewLectureDetails();
                    }else if(ip2==2){
                        viewAssessments();
                    }else if(ip2==3){
                        ArrayList<Integer> check=Student.getStudentClassList().get(student).viewPendingAssessments();
                        if(!(check==null || check.size()==0)) {
                            System.out.print("Enter ID of assessment: ");
                            int assnIden = sc.nextInt();
                            if (Assignment.getHashMap().containsKey(assnIden)) {
                                System.out.print("Enter filename of assignment: ");
                                sc.nextLine();
                                String filename = sc.nextLine();
                                //sc.nextLine();   //change
                                if (filename.length() < 4 || !filename.substring(filename.length() - 4).equals(".zip")) {
                                    System.out.println("Wrong filename entered");
                                } else {
                                    Student.getStudentClassList().get(student).setSubmissions(assnIden, filename);
                                }

                            } else if (Quiz.getHashMap().containsKey(assnIden)) {
                                System.out.print(Quiz.getHashMap().get(assnIden).getProblemStatement() + ": ");
                                sc.nextLine();
                                String ans = sc.nextLine();
                                Student.getStudentClassList().get(student).setSubmissions(assnIden, ans);
                                //sc.nextLine();
                            } else {
                                System.out.println("Wrong ID entered");
                            }
                        }else{
                            System.out.println("No pending assessments");
                        }

                    }else if(ip2==4){
                        System.out.println("Graded Submissions");
                        ArrayList<Grading> arr=Grading.getStudentToGradingMap().get(student);
                        ArrayList<Integer> gradedSubmissions=new ArrayList<>();
                        if(arr!=null && arr.size()!=0){
                            for(Grading g:arr) {
                                System.out.println("Submission: " +Student.getStudentClassList().get(student).getSubmission(g.getAssessID()));
                                System.out.println("Marks Scored: "+g.getMarksAwarded());
                                System.out.println("Graded by: "+g.getInstID());
                                gradedSubmissions.add(g.getAssessID());
                                System.out.println();
                            }

                        }else{
                            System.out.println();
                            System.out.println("----------------------------");
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("Ungraded Submissions");
                        if(!Student.getStudentClassList().get(student).getSubmissionsMap().isEmpty()) {
                            for (Integer i : Student.getStudentClassList().get(student).getSubmissionsMap().keySet()) {
                                if (!gradedSubmissions.contains(i)) {
                                    System.out.println("Submission: " + Student.getStudentClassList().get(student).getSubmission(i));
//                                    ArrayList<Grading> arrayList=Grading.getStudentToGradingMap().get(student);
//                                    for(Grading g:arrayList){
//                                        if(g.getAssessID()==i){
//                                            System.out.println("Marks Scored: "+g.getMarksAwarded());
//                                            System.out.println("Graded by: "+g.getInstID());
//                                            break;
//                                        }
//                                    }

                                }
                            }
                        }
                    }else if(ip2==5){
                        Discussions.viewComments();
                    }else if(ip2==6){
                        System.out.print("Enter comment: ");
                        sc.nextLine();
                        String comment=sc.nextLine();
                        Discussions d=Student.getStudentClassList().get(student);
                        d.addComments(comment);
                        //Student.getStudentClassList().get(student).addComments(comment);
                    }
                    System.out.println("----------------------------");
                    System.out.println("Welcome " + student);
                    System.out.println("STUDENT MENU\n" +
                            "1. View lecture materials\n" +
                            "2. View assessments\n" +
                            "3. Submit assessment\n" +
                            "4. View grades\n" +
                            "5. View comments\n" +
                            "6. Add comments\n" +
                            "7. Logout");

                    ip2 = sc.nextInt();
                }
            }
            System.out.println("----------------------------");
            System.out.println("Welcome to Backpack\n" +
                    "1. Enter as instructor\n" +
                    "2. Enter as student\n" +
                    "3. Exit");
            input = sc.nextInt();

        }
    }
}

