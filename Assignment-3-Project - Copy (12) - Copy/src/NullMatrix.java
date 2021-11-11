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
        this.rows=rows;
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
        }else{
            labels.add("Rectangular Matrix");
        }

        if(this.rows==1 && this.columns==1){
            labels.add("Singleton Matrix");
        }else if(this.rows==1 && this.columns!=1){
            labels.add("Row Matrix");
        }else if(this.columns==1 && this.rows!=1){
            labels.add("Column Matrix");
        }
    }

    public double[][] getMatrix(){
        double[][] newMat=new double[this.rows][this.columns];
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
        Matrix mat1=matrix.inverse();
        if(mat1==null){
            System.out.println("Division is not possible");
            return null;
        }
        if(this.columns==mat1.getRows()) {
            Matrix mat2 = this.mulMatrices(mat1);
            return mat2;
        }else{
            System.out.println("Division is not possible");
            return null;
        }
    }

    
    public Matrix inverse() {
        System.out.println("Inverse not possible");
        return null;
    }


    public Matrix transpose(){
        Matrix mat=new Matrix(this.columns,this.rows,new double[this.columns][this.rows]);
//        int temp=this.rows;
//        this.rows=this.columns;
//        this.columns=temp;
        //double [][]newMatrix=new double[this.rows][this.columns];
        //mat.setMatrix(newMatrix);
//        for(int i=0;i<this.columns;i++){
//            for(int j=0;j<this.rows;j++){
//                mat.getMatrix()[i][j]=this.getMatrix()[j][i];
//            }
//        }
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
        double a,b;
        double ev=evs[0];
        double[][] evect1=new double[2][1];
        a=evect1[0][0]=-1*this.getMatrix()[0][1];
        b=evect1[1][0]=this.getMatrix()[0][0]-ev;
        double mag=Math.pow(a*a+b*b,0.5);
        if(mag==0){
            double c,d;
            c=evect1[1][0]=-1*this.getMatrix()[1][0];
            d=evect1[0][0]=this.getMatrix()[1][1]-ev;
            double mag2=Math.pow(c*c+d*d,0.5);
            if(mag2==0){
                evect1[1][0]=0;
                evect1[0][0]=1;
            }
        }
        double e,f;
        double ev2=evs[1];
        double[][] evect2=new double[2][1];
//        e=evect2[1][0]=-1*this.matrix[1][0];
//        f=evect2[0][0]=this.matrix[1][1]-ev2;
        e=evect2[0][0]=-1*this.getMatrix()[0][1];
        f=evect2[1][0]=this.getMatrix()[0][0]-ev2;
        double mag3=Math.pow(e*e+f*f,0.5);
        if(mag3==0){
            double g,h;
            g=evect2[1][0]=-1*this.getMatrix()[1][0];
            h=evect2[0][0]=this.getMatrix()[1][1]-ev2;
            double mag2=Math.pow(g*g+h*h,0.5);
            if(mag2==0){
                evect2[1][0]=1;
                evect2[0][0]=0;
            }
        }

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
        if(this.columns!=mat.getColumns() || this.rows!=mat.getRows()){
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
