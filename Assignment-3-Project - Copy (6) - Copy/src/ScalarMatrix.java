import java.util.ArrayList;

public class ScalarMatrix extends DiagonalMatrix{
    private String id;
    private int rows;
    //private int columns;
    private double[][] matrix;
    private ArrayList<String> labels=new ArrayList<>();


    public ScalarMatrix(int rows, double[][] matrix) {
        super(rows, matrix);
        this.matrix=matrix;
        this.rows=rows;
        labels.addAll(super.getLabels());
        labels.add("Scalar Matrix");
        if(matrix[0][0]==0){
            labels.add("Singular Matrix");
            labels.add("Null Matrix");
            labels.add("Skew Symmetric Matrix");
        }

        labels.add("Symmetric Matrix");


    }
    public double allMean() {
        System.out.println(((double) this.matrix[0][0]*this.rows)/Math.pow(this.rows,2));
        return -1;
    }

    public double rowWiseMean(){

        for(int rows=0;rows<this.rows;rows++){
            System.out.println("Mean of row "+rows+1+" : ");

            System.out.println(((double)this.matrix[0][0])/this.rows);
        }
        return -1;
    }

    public double colWiseMean(){
        for(int rows=0;rows<this.rows;rows++){
            System.out.println("Mean of column "+rows+1+" : ");

            System.out.println(((double)this.matrix[0][0])/this.rows);
        }
        return -1;
    }

    public ArrayList<String> getLabels(){
        return this.labels;
    }
    public double[] eigenValues(Matrix matrix) {

        double trA=this.matrix[0][0]*2;
        double sqrtTerm=Math.pow(trA,2)-4*Math.pow(this.matrix[0][0],2);
        if(sqrtTerm<0){
            System.out.println("No eigen values possible");
            return null;
        }
        double ev1=((double)(trA+Math.pow(sqrtTerm,0.5)))/2;
        double ev2=((double)(trA-Math.pow(sqrtTerm,0.5)))/2;
        double[] res=new double[2];
        res[0]=ev1;
        res[1]=ev2;
        return res;

    }
}
