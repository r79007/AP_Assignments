public class Assignment implements Assessment{
    private String probStatement;
    private int marks;
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
}
