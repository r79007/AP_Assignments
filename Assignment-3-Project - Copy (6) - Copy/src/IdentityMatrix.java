import java.util.ArrayList;

public class IdentityMatrix extends DiagonalMatrix{
    private String id;
    private int rows;
    private int columns;
    private double[][] matrix;
    private ArrayList<String> labels;

    public IdentityMatrix(int rows, double[][] matrix) {
        super(rows,matrix);
        this.rows=rows;
        this.columns=rows;
        labels=new ArrayList<>();
        labels.addAll(super.getLabels());
        labels.add("Identity Matrix");
        labels.add("Symmetric Matrix");
        labels.add("Scalar Matrix");
        //labels.add("Square Matrix");
    }




    public Matrix divMatrices(Matrix matrix) {
        // Matrix newMatrix=new Matrix(this.rows,this.columns,this.matrix);
        Matrix mat1=matrix.inverse();
        //Matrix mat2=mat1.mulMatrices(matrix);

        return mat1;

    }


    


    
    public Matrix mulMatrices(Matrix matrix) {
        System.out.println("In identity matrix");
        return matrix;
    }

    


    
    public Matrix inverse() {
        return this;
    }

    
    public Matrix transpose() {
        return this;
    }

    
    public double rowWiseMean(Matrix matrix) {

        for(int rows=0;rows<this.rows;rows++){
            System.out.println("Mean of row "+rows+1+" : ");

            System.out.println(((double)1)/this.rows);
        }
        return -1;
    }




    
    public double colWiseMean(Matrix matrix) {
        for(int rows=0;rows<this.rows;rows++){
            System.out.println("Mean of column "+rows+1+" : ");

            System.out.println(((double)1)/this.rows);
        }
        return -1;
    }


    
    public double allMean(Matrix matrix) {
        System.out.println(((double)1*this.rows)/Math.pow(this.rows,2));
        return -1;
    }

    
    public int det(Matrix matrix) {
        return 0;
    }

    
    public Matrix AAT(Matrix matrix) {
        return null;
    }

    
    public Matrix eigenVectors(Matrix matrix) {
        return null;
    }

    
    public double[] eigenValues() {
        double[] res=new double[2];
        res[0]=1;
        res[1]=1;
        return res;
    }

    
    public void setId(String id) {
        this.id=id;
    }

    
    public String getID() {
        return this.id;
    }

    public ArrayList<String> getLabels(){
        return this.labels;
    }
}
