import java.util.ArrayList;
import java.util.Arrays;

public class DiagonalMatrix extends SquareMatrix{
    private String id;
    private int rows;
    //private int columns;
    //private double[][] matrix;
    private double[] elements;
    private ArrayList<String> labels=new ArrayList<>();

    public DiagonalMatrix(int rows, double[][] matrix) {
        super(rows, null);
        this.rows=rows;
        //this.getMatrix()=matrix;
        labels.addAll(super.getLabels());
        labels.add("Diagonal Matrix");
        labels.add("Symmetric Matrix");

        elements=new double[rows];
        if(matrix!=null) {
            for (int i = 0; i < rows; i++) {
                elements[i] = matrix[i][i];
            }
        }

        if(matrix!=null) {
            if (this.det() == 0) {
                labels.add("Singular Matrix");
            }
        }
        labels.add("Upper Triangular Matrix");
        labels.add("Lower Triangular Matrix");

    }

    public void setRows(int rows) {
        this.rows = rows;
    }



    public double[][] getMatrix(){
        double[][] newMat=new double[this.rows][this.rows];
        for(int i=0;i<this.rows;i++){
            newMat[i][i]=elements[i];
        }
        return newMat;
    }
    public Matrix addMatrices(Matrix matrix) {

        double[][] matr = Arrays.stream(matrix.getMatrix()).map(double[]::clone).toArray(double[][]::new);
        Matrix newMAtrix=new Matrix(this.rows,this.rows,matr);
        for(int i=0;i<this.rows;i++){
            newMAtrix.getMatrix()[i][i]=matrix.getMatrix()[i][i]+elements[i];
        }

        return newMAtrix;
    }



    public Matrix subMatrices(Matrix matrix) {
        double[][] matr = Arrays.stream(matrix.getMatrix()).map(double[]::clone).toArray(double[][]::new);
        Matrix newMAtrix=new Matrix(this.rows,this.rows,matr);
        for(int i=0;i<this.rows;i++){
            newMAtrix.getMatrix()[i][i]=-matrix.getMatrix()[i][i]+elements[i];
        }

        return newMAtrix;
    }
    public int getColumns(){
        return this.rows;
    }

    public Matrix mulMatrices(Matrix matrix) {
        Matrix mat=new Matrix(this.rows, matrix.getColumns(), new double[this.rows][matrix.getColumns()]);
        for(int i=0;i<this.rows;i++){
            for(int j=0;j<mat.getColumns();j++){
                for(int k=0;k<this.getColumns();k++) {
                    mat.getMatrix()[i][j] += this.getMatrix()[i][k]*matrix.getMatrix()[k][j];
                }
            }
        }
        return mat;
    }

    public Matrix divMatrices(Matrix matrix) {
        // Matrix newMatrix=new Matrix(this.rows,this.getColumns(),this.matrix);
        Matrix mat1=matrix.inverse();
        if(mat1==null){
            System.out.println("Division is not possible");
            return null;
        }
        Matrix mat2=mat1.mulMatrices(matrix);

        return mat2;

    }


    public Matrix transpose() {
        return this;
    }

    
    public double rowWiseMean() {

        for(int rows=0;rows<this.rows;rows++){
            System.out.println("Mean of row "+rows+1+" : ");

            System.out.println(this.elements[rows]/this.rows);
        }
        return -1;
    }

    
    public double colWiseMean() {
        for(int rows=0;rows<this.rows;rows++){
            System.out.println("Mean of column "+rows+1+" : ");

            System.out.println(elements[rows]/this.rows);
        }
        return -1;
    }

    public double allMean() {
        double mean=0;
       for(int i=0;i<this.rows;i++){
           mean+=elements[i];
       }
        System.out.println(mean/Math.pow(this.rows,2));
       return -1;
    }

    
    public double det() {
        int sum=1;
        for(int i=0;i<this.rows;i++){
            sum*=elements[i];
        }

        return sum;
    }

    
    public Matrix AAT() {
        double[][] matr = Arrays.stream(this.getMatrix()).map(double[]::clone).toArray(double[][]::new);
        Matrix mat=new Matrix(this.rows,this.rows,matr);
        for(int i=0;i<this.rows;i++){
            mat.getMatrix()[i][i]+=mat.getMatrix()[i][i];
        }
        return mat;
    }

    
//    public Matrix eigenVectors(Matrix matrix) {
//        return null;
//    }

    
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
            sum+=elements[i];
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

    public Matrix multiplyByNum(double num){
        double[][] matr1 = Arrays.stream(this.getMatrix()).map(double[]::clone).toArray(double[][]::new);

        for(int i=0;i<this.rows;i++){
            for(int j=0;j<this.getColumns();j++){
                matr1[i][j]=num*matr1[i][j];

            }

        }
        Matrix mat=new Matrix(this.rows,this.getColumns(),matr1);
        return mat;
    }
    public void display(){
        for(int i=0;i<this.rows;i++){
            for(int j=0;j<this.getColumns();j++){
                System.out.print(this.getMatrix()[i][j]+" ");

            }
            System.out.println();
        }
    }
    public Matrix elementWiseOperation(Matrix mat,String op){
        if(this.getColumns()!=mat.getColumns() || this.rows!=mat.getRows()){
            System.out.println("Not possible");
            return null;
        }
        if(op.equals("mul")) {

            double[][] newMat = new double[this.rows][this.getColumns()];

            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.getColumns(); j++) {
                    newMat[i][j] = this.getMatrix()[i][j] * mat.getMatrix()[i][j];

                }
            }

            Matrix res = new Matrix(this.rows, this.getColumns(), newMat);

            return res;
        }else if(op.equals("add")){
            double[][] newMat = new double[this.rows][this.getColumns()];

            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.getColumns(); j++) {
                    newMat[i][j] = this.getMatrix()[i][j] + mat.getMatrix()[i][j];

                }
            }

            Matrix res = new Matrix(this.rows, this.getColumns(), newMat);

            return res;
        }else if(op.equals("sub")){
            double[][] newMat = new double[this.rows][this.getColumns()];

            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.getColumns(); j++) {
                    newMat[i][j] = this.getMatrix()[i][j] - mat.getMatrix()[i][j];

                }
            }

            Matrix res = new Matrix(this.rows, this.getColumns(), newMat);

            return res;
        }else if(op.equals("div")){
            double[][] newMat = new double[this.rows][this.getColumns()];

            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.getColumns(); j++) {
                    newMat[i][j] = this.getMatrix()[i][j]/mat.getMatrix()[i][j];

                }
            }

            Matrix res = new Matrix(this.rows, this.getColumns(), newMat);

            return res;
        }else{
            System.out.println("Wrong operation");
            return null;
        }

    }
    
    public Matrix inverse(){
        double[][] matr1 = Arrays.stream(this.getMatrix()).map(double[]::clone).toArray(double[][]::new);
        
        for(int i=0;i<this.rows;i++){
            matr1[i][i]=((double)1)/elements[i];
        }
        
        Matrix res=new Matrix(this.rows,this.rows,matr1);
        
        return res;
    }

    

}
