import java.util.ArrayList;
import java.util.Arrays;

public class DiagonalMatrix extends SquareMatrix{
    private String id;
    private int rows;
    //private int columns;
    private double[][] matrix;
    private ArrayList<String> labels=new ArrayList<>();

    public DiagonalMatrix(int rows, double[][] matrix) {
        super(rows, matrix);
        this.rows=rows;
        this.matrix=matrix;
        labels.addAll(super.getLabels());
        labels.add("Diagonal Matrix");
        labels.add("Symmetric Matrix");
        if(this.det()==0){
            labels.add("Singular Matrix");
        }
        labels.add("Upper Triangular Matrix");
        labels.add("Lower Triangular Matrix");
    }

    
    public Matrix addMatrices(Matrix matrix) {
        double[][] matr = Arrays.stream(matrix.getMatrix()).map(double[]::clone).toArray(double[][]::new);
        Matrix newMAtrix=new Matrix(this.rows,this.rows,matr);
        for(int i=0;i<this.rows;i++){
            newMAtrix.getMatrix()[i][i]=matrix.getMatrix()[i][i]+this.matrix[i][i];
        }

        return newMAtrix;
    }

    public Matrix subMatrices(Matrix matrix) {
        double[][] matr = Arrays.stream(matrix.getMatrix()).map(double[]::clone).toArray(double[][]::new);
        Matrix newMAtrix=new Matrix(this.rows,this.rows,matr);
        for(int i=0;i<this.rows;i++){
            newMAtrix.getMatrix()[i][i]=-matrix.getMatrix()[i][i]+this.matrix[i][i];
        }

        return newMAtrix;
    }
    public int getColumns(){
        return this.rows;
    }

    


    


    


    


    
    public Matrix transpose() {
        return this;
    }

    
    public double rowWiseMean() {

        for(int rows=0;rows<this.rows;rows++){
            System.out.println("Mean of row "+rows+1+" : ");

            System.out.println(this.matrix[rows][rows]/this.rows);
        }
        return -1;
    }

    
    public double colWiseMean() {
        for(int rows=0;rows<this.rows;rows++){
            System.out.println("Mean of column "+rows+1+" : ");

            System.out.println(this.matrix[rows][rows]/this.rows);
        }
        return -1;
    }

    public double allMean() {
        double mean=0;
       for(int i=0;i<this.rows;i++){
           mean+=this.getMatrix()[i][i];
       }
        System.out.println(mean/Math.pow(this.rows,2));
       return -1;
    }

    
    public double det() {
        int sum=1;
        for(int i=0;i<this.rows;i++){
            sum*=this.matrix[i][i];
        }

        return sum;
    }

    
    public Matrix AAT() {
        double[][] matr = Arrays.stream(this.matrix).map(double[]::clone).toArray(double[][]::new);
        Matrix mat=new Matrix(this.rows,this.rows,matr);
        for(int i=0;i<this.rows;i++){
            mat.getMatrix()[i][i]+=mat.getMatrix()[i][i];
        }
        return mat;
    }

    
    public Matrix eigenVectors(Matrix matrix) {
        return null;
    }

    
    public double[] eigenValues() {
        double trA=getTrace();
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

    public double getTrace(){
        double sum=0;
        for(int i=0;i<this.rows;i++){
            sum+=this.matrix[i][i];
        }
        return sum;
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
