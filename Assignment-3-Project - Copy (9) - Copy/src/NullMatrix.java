import java.util.ArrayList;
import java.util.Arrays;

public class NullMatrix extends Matrix{

    private String id;
    private int rows;
    private int columns;
    //private int[][] matrix;
    private ArrayList<String> labels=new ArrayList<>();

    public NullMatrix(int rows, int columns) {
        super(rows, columns, null);
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

    public double[][] getMatrix(){
        double[][] newMat=new double[this.rows][this.rows];
        for(int i=0;i<this.rows;i++) {
            for (int j = 0; j < this.columns; j++) {
                newMat[i][j] = 0;
            }
        }
        return newMat;
    }

    public Matrix addMatrices(Matrix matrix) {

        return matrix;
    }
    public Matrix subMatrices(Matrix matrix) {
        Matrix mat=new Matrix(this.rows,this.columns,new double[this.rows][this.columns]);
        for(int i=0;i<matrix.getRows();i++){
            for(int j=0;j<matrix.getColumns();j++){
                mat.getMatrix()[i][j]=this.getMatrix()[i][j]-matrix.getMatrix()[i][j];
            }
        }
        return mat;
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


    public Matrix transpose(){
        Matrix mat=new Matrix(this.columns,this.rows,new double[this.columns][this.rows]);
        int temp=this.rows;
        this.rows=this.columns;
        this.columns=temp;
        double [][]newMatrix=new double[this.rows][this.columns];
        mat.setMatrix(newMatrix);
        for(int i=0;i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                mat.getMatrix()[i][j]=this.getMatrix()[j][i];
            }
        }
        return mat;
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


    public Matrix[] eigenVectors(){
        double[] evs=this.eigenValues();
        Matrix[] eVectors=new Matrix[2];

        double ev=evs[0];
        double[][] evect1=new double[2][1];
        evect1[0][0]=-1*this.getMatrix()[0][1];
        evect1[1][0]=this.getMatrix()[0][0]-ev;

        double ev2=evs[1];
        double[][] evect2=new double[2][1];
        evect2[1][0]=-1*this.getMatrix()[1][0];
        evect2[0][0]=this.getMatrix()[1][1]-ev2;

        eVectors[0]=new Matrix(2,1,evect1);
        eVectors[1]=new Matrix(2,1,evect2);
        return eVectors;

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
    public Matrix elementWiseOperation(Matrix mat,String op){
        if(this.columns!=mat.getColumns() || this.rows!=mat.getColumns()){
            System.out.println("Not possible");
            return null;
        }
        if(op.equals("mul")) {

            double[][] newMat = new double[this.rows][this.columns];

            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    newMat[i][j] = this.getMatrix()[i][j] * mat.getMatrix()[i][j];

                }
            }

            Matrix res = new Matrix(this.rows, this.columns, newMat);

            return res;
        }else if(op.equals("add")){
            double[][] newMat = new double[this.rows][this.columns];

            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    newMat[i][j] = this.getMatrix()[i][j] + mat.getMatrix()[i][j];

                }
            }

            Matrix res = new Matrix(this.rows, this.columns, newMat);

            return res;
        }else if(op.equals("sub")){
            double[][] newMat = new double[this.rows][this.columns];

            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    newMat[i][j] = this.getMatrix()[i][j] - mat.getMatrix()[i][j];

                }
            }

            Matrix res = new Matrix(this.rows, this.columns, newMat);

            return res;
        }else if(op.equals("div")){
            double[][] newMat = new double[this.rows][this.columns];

            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    newMat[i][j] = this.getMatrix()[i][j]/mat.getMatrix()[i][j];

                }
            }

            Matrix res = new Matrix(this.rows, this.columns, newMat);

            return res;
        }else{
            System.out.println("Wrong operation");
            return null;
        }

    }

    public Matrix multiplyByNum(double num){
        double[][] matr1 = Arrays.stream(this.getMatrix()).map(double[]::clone).toArray(double[][]::new);

        for(int i=0;i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                matr1[i][j]=num*matr1[i][j];

            }

        }
        Matrix mat=new Matrix(this.rows,this.columns,matr1);
        return mat;
    }
    public Matrix solve(Matrix matrix2){
        Matrix invMat=this.inverse();
        if(invMat!=null) {
            Matrix res = invMat.mulMatrices(matrix2);
            return res;
        }else{
            System.out.println("No Solution");
            return null;
        }

    }
    public void display(){
        for(int i=0;i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                System.out.print(this.getMatrix()[i][j]+" ");

            }
            System.out.println();
        }
    }


}
