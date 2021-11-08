import java.util.ArrayList;

public class NullMatrix extends Matrix{

    private String id;
    private int rows;
    private int columns;
    private int[][] matrix;
    private ArrayList<String> labels=new ArrayList<>();

    public NullMatrix(int rows, int columns) {
        super(rows, columns, new double[rows][columns]);
        this.rows=columns;
        this.columns=columns;

        labels.addAll(super.getLabels());
        labels.add("Null Matrix");
        if(rows==columns){
            labels.add("Square Matrix");
            labels.add("Diagonal Matrix");
            labels.add("Symmetric Matrix");
            labels.add("Skew Symmetric Matrix");
            labels.add("Singular Matrix");
            labels.add("Upper Triangular Matrix");
            labels.add("Lower Triangular Matrix");
        }
    }

    public Matrix addMatrices(Matrix matrix) {

        return matrix;
    }




    public Matrix mulMatrices(Matrix matrix) {

        double[][] mat=new double[this.rows][matrix.getColumns()];
        Matrix res=new Matrix(this.rows,this.columns,mat);
        return res;
    }

    
    public Matrix divMatrices(Matrix matrix) {
        if(!(matrix.getRows()==this.rows && matrix.getColumns()==this.columns)){
            System.out.println("Division not possible");
            return null;
        }else{
            return this.mulMatrices(matrix);
        }

    }

    
    public Matrix inverse() {
        System.out.println("Inverse not possible");
        return null;
    }

    
    public Matrix transpose() {
        return this;
    }

    
    public double rowWiseMean() {
        System.out.println(0);
        return -1;
    }

    
    public double colWiseMean() {
        System.out.println(0);
        return 0;
    }

    
    public double allMean() {
        System.out.println(0);
        return -1;
    }

    
    public double det() {
        if(this.rows!=this.columns){
            return Integer.MIN_VALUE;
        }
        return 0;
    }

    
    public Matrix AAT() {
        if(this.rows!=this.columns) {
            System.out.println("A+A^T not possible");
            return null;
        }
        return this;
    }

    
    public Matrix[] eigenVectors() {
        return null;
    }

    
    public double[] eigenValues() {
        if(this.rows==this.columns){
            double[] res=new double[2];
            res[0]=0;
            res[1]=0;
            return res;
        }else{
            System.out.println("Eigen values not possible");
            return null;
        }

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
