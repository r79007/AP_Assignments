import java.util.ArrayList;
import java.util.Arrays;

public class SkewSymmetricMatrix extends SquareMatrix{
    private String id;
    private int rows;
    private double[][] matrix;
    private ArrayList<String> labels;


    public SkewSymmetricMatrix(int rows, double[][] matrix) {
        super(rows, matrix);
        this.rows=rows;
        this.matrix=matrix;
        labels=new ArrayList<>();
        labels.addAll(super.getLabels());
        labels.add("Skew Symmetric Matrix");

    }

    public Matrix AAT() {
        Matrix res=new Matrix(this.rows,this.rows,new double[this.rows][this.rows]);
        return res;
    }


    public Matrix transpose(){
        double[][] matr1 = Arrays.stream(this.matrix).map(double[]::clone).toArray(double[][]::new);
        Matrix mat=new Matrix(this.rows,this.rows,matr1);
        Matrix mat2=mat.multiplyByNum(-1);
        return mat2;
    }

    public ArrayList<String> getLabels(){
        return this.labels;
    }

    public String getID(){
        return this.id;
    }

    public void setId(String id) {
        this.id=id;
    }

    public double[] eigenValues() {

        double trA=0;
        double sqrtTerm=Math.pow(trA,2)-4*this.det();
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
