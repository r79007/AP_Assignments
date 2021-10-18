public class Quiz implements Assessment{
    private String probStatement;

    @Override
    public void setProblemStatement(String ps) {
        this.probStatement=ps;

    }

    public String getProblemStatement(){
        return this.probStatement;
    }

}
