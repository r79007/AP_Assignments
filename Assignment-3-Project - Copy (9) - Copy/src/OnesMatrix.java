import java.util.ArrayList;
import java.util.Arrays;

public class OnesMatrix extends Matrix{
    private String id;
    private int rows;
    private int columns;
    //private double[][] matrix;
    private ArrayList<String> labels;

    public OnesMatrix(int rows, int columns, double[][] matrix) {
        super(rows, columns, null);
        this.rows=rows;
        this.columns=columns;
        labels=new ArrayList<>();
        labels.addAll(super.getLabels());
        labels.add("Ones Matrix");
        if(this.rows==this.columns){
            labels.add("Square Matrix");
            labels.add("Singular Matrix");
            labels.add("Symmetric Matrix");
        }



    }

    public double[][] getMatrix(){
        double[][] newMat=new double[this.rows][this.rows];
        for(int i=0;i<this.rows;i++) {
            for (int j = 0; j < this.columns; j++) {
                newMat[i][j] = 1;
            }
        }
        return newMat;
    }

    public double rowWiseMean() {
        System.out.println(1);
        return -1;
    }


    public double colWiseMean() {

        System.out.println(1);
        return -1;
    }

    public Matrix addMatrices(Matrix matrix) {
        Matrix mat=new Matrix(this.rows,this.columns,new double[this.rows][this.columns]);
        for(int i=0;i<matrix.getRows();i++){
            for(int j=0;j<matrix.getColumns();j++){
                mat.getMatrix()[i][j]=this.getMatrix()[i][j]+matrix.getMatrix()[i][j];
            }
        }
        return mat;
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
        Matrix mat=new Matrix(this.rows, matrix.getColumns(), new double[this.rows][matrix.getColumns()]);
        for(int i=0;i<this.rows;i++){
            for(int j=0;j<mat.getColumns();j++){
                for(int k=0;k<this.columns;k++) {
                    mat.getMatrix()[i][j] += this.getMatrix()[i][k]*matrix.getMatrix()[k][j];
                }
            }
        }
        return mat;
    }
    public Matrix divMatrices(Matrix matrix) {
        // Matrix newMatrix=new Matrix(this.rows,this.columns,this.matrix);
        Matrix mat1=matrix.inverse();
        if(mat1==null){
            System.out.println("Division is not possible");
            return null;
        }
        Matrix mat2=mat1.mulMatrices(matrix);

        return mat2;

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



    public double allMean() {
        System.out.println(1);
        return -1;
    }

    public ArrayList<String> getLabels(){
        return this.labels;
    }

    public double det(){
        if(this.rows==this.columns){
            return 0;
        }else{
            System.out.println("Determinant not possible");
            return Integer.MIN_VALUE;
        }
    }
    public double[] eigenValues() {

        if(this.rows==this.columns) {

            double trA = 2;
            double sqrtTerm = 4;
            if (sqrtTerm < 0) {
                System.out.println("No eigen values possible");
                return null;
            }
            double ev1 = ((double) (trA + Math.pow(sqrtTerm, 0.5))) / 2;
            double ev2 = ((double) (trA - Math.pow(sqrtTerm, 0.5))) / 2;
            double[] res = new double[2];
            res[0] = ev1;
            res[1] = ev2;
            return res;
        }else{
            System.out.println("Eigen values not possible");
            return null;
        }

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

    public void display(){
        for(int i=0;i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                System.out.print(this.getMatrix()[i][j]+" ");

            }
            System.out.println();
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
        System.out.println("Cannot solve equations");
        return null;
    }
    public Matrix AAT() {
        return this.multiplyByNum(2);
    }
}
