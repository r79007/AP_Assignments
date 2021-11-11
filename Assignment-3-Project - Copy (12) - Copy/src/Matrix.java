import java.util.ArrayList;
import java.util.Arrays;

public class Matrix {
    private String id;
    private int rows;
    private int columns;
    private double[][] matrix;

    public double[][] getMatrix() {
        return this.matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public int getRows() {
        return this.rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    private ArrayList<String> labels;

    public Matrix(int rows, int columns,double [][] matrix){
        labels=new ArrayList<>();
        labels.add("Matrix");
        this.rows=rows;
        this.columns=columns;
        this.matrix=matrix;

    }


    public ArrayList<String> getLabels() {
        return labels;
    }


    public Matrix addMatrices(Matrix matrix) {
        Matrix mat=new Matrix(this.rows,this.columns,new double[this.rows][this.columns]);
        for(int i=0;i<matrix.rows;i++){
            for(int j=0;j<matrix.columns;j++){
                mat.getMatrix()[i][j]=this.matrix[i][j]+matrix.getMatrix()[i][j];
            }
        }
        return mat;
    }

    
    public Matrix subMatrices(Matrix matrix) {
        Matrix mat=new Matrix(this.rows,this.columns,new double[this.rows][this.columns]);
        for(int i=0;i<matrix.rows;i++){
            for(int j=0;j<matrix.columns;j++){
                mat.getMatrix()[i][j]=this.matrix[i][j]-matrix.getMatrix()[i][j];
            }
        }
        return mat;
    }


    public Matrix mulMatrices(Matrix matrix) {
        Matrix mat=new Matrix(this.rows, matrix.columns, new double[this.rows][matrix.columns]);
        for(int i=0;i<this.rows;i++){
            for(int j=0;j<mat.columns;j++){
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
        Matrix mat2=this.mulMatrices(mat1);

        return mat2;

    }





    public Matrix transpose(){
        Matrix mat=new Matrix(this.columns,this.rows,new double[this.columns][this.rows]);
//        int temp=this.rows;
//        this.rows=this.columns;
//        this.columns=temp;
        //double [][]newMatrix=new double[this.rows][this.columns];
        //mat.setMatrix(newMatrix);
        for(int i=0;i<this.columns;i++){
            for(int j=0;j<this.rows;j++){
                mat.getMatrix()[i][j]=this.getMatrix()[j][i];
            }
        }
        return mat;
    }
    double[][] Cofactor(double mat[][], int currRow, int currColumn){

        double [][]cf = new double[this.rows][this.rows];
        int j=0;
        int i=0;
        for (int row = 0; row < this.rows; row++){
            for (int col = 0; col < this.rows; col++){
                if (row != currRow && col != currColumn){
                    cf[i][j] = mat[row][col];
                    j++;
                    if (j==this.rows-1){
                        j=0;
                        i++;
                    }
                }
            }
        }
        return cf;
    }

    public double detm(double[][] mat, int ro){
        if(ro==1){
            return mat[0][0];
        }
        else if(ro==2){
            return (mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]);
        }else if(ro==3){
            double a,b,c,d,e,f,g,h,i;
            a = mat[0][0];
            b = mat[0][1];
            c = mat[0][2];
            d = mat[1][0];
            e = mat[1][1];
            f = mat[1][2];
            g = mat[2][0];
            h = mat[2][1];
            i = mat[2][2];

            return (a*(e*i - f*h)) - (b*(d*i - f*g)) + (c*(d*h - e*g));
        }else{
            return Double.MIN_VALUE;
        }
    }

     double[][] adjoint(double mat[][]) {
        double [][]adj = new double[this.rows][this.columns];
        if (this.rows == 1){
            adj[0][0] = 1;
            return adj;
        }
        int sign=1;
        for (int i=0; i<this.rows;i++){
            for (int j=0;j<this.rows; j++){
                double[][] cf= Cofactor(mat, i, j);
                if((i+j)%2==0){
                    sign=1;
                }else{
                    sign=-1;
                }
                adj[j][i]=(sign)*(detm(cf, this.rows-1));
            }
        }
        return adj;
    }


     public Matrix inverse(){
        double[][] A = Arrays.stream(this.matrix).map(double[]::clone).toArray(double[][]::new);
        double detr = detm(A, this.rows);
        if (detr == 0) {
            System.out.print("Inverse not possible");
            return null;
        }
        double [][]adj=adjoint(A);
        Matrix adjo=new Matrix(this.rows,this.rows,adj);
        Matrix res=adjo.multiplyByNum(((double)1)/detr);
        return res;
    }


    public double rowWiseMean() {

        for(int rows=0;rows<this.rows;rows++){
            System.out.print("Mean of row "+rows+1+" : ");
            double sum=0;
            for(int i=0;i<this.columns;i++){
                sum+=this.matrix[rows][i];
            }
            System.out.println(sum/this.columns);
        }
        return -1;
    }


    public double colWiseMean() {
        for(int rows=0;rows<this.columns;rows++){
            System.out.println("Mean of column "+rows+1+" : ");
            double sum=0;
            for(int i=0;i<this.rows;i++){
                sum+=this.matrix[i][rows];

            }
            System.out.println(sum/this.rows);
        }
        return -1;
    }


    public double allMean() {
        double sum=0;
        for(int i=0;i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                sum+=this.matrix[i][j];

            }

        }

        System.out.println(sum/(this.rows*this.columns));
        return -1;
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
                    newMat[i][j] = this.matrix[i][j] * mat.getMatrix()[i][j];

                }
            }

            Matrix res = new Matrix(this.rows, this.columns, newMat);

            return res;
        }else if(op.equals("add")){
            double[][] newMat = new double[this.rows][this.columns];

            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    newMat[i][j] = this.matrix[i][j] + mat.getMatrix()[i][j];

                }
            }

            Matrix res = new Matrix(this.rows, this.columns, newMat);

            return res;
        }else if(op.equals("sub")){
            double[][] newMat = new double[this.rows][this.columns];

            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    newMat[i][j] = this.matrix[i][j] - mat.getMatrix()[i][j];

                }
            }

            Matrix res = new Matrix(this.rows, this.columns, newMat);

            return res;
        }else if(op.equals("div")){
            double[][] newMat = new double[this.rows][this.columns];

            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    newMat[i][j] = this.matrix[i][j]/mat.getMatrix()[i][j];

                }
            }

            Matrix res = new Matrix(this.rows, this.columns, newMat);

            return res;
        }else{
            System.out.println("Wrong operation");
            return null;
        }

    }


    public double det() {
        return detm(this.matrix,this.rows);
    }


    public Matrix AAT() {
        double[][] matr1 = Arrays.stream(this.matrix).map(double[]::clone).toArray(double[][]::new);
        double[][] matr = Arrays.stream(this.matrix).map(double[]::clone).toArray(double[][]::new);
        Matrix mat=new Matrix(this.rows,this.columns,matr1);
        Matrix mat2=new Matrix(this.rows,this.columns,matr);
        Matrix mat22=mat2.transpose();
        if(mat.getColumns()==mat22.getColumns() && mat.getRows()==mat22.getRows()) {
            Matrix res = mat.addMatrices(mat22);
            return res;
        }else{
            System.out.println("Cannot add A and AT");
            return null;
        }

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

    public Matrix[] eigenVectors(){
        double[] evs=this.eigenValues();
        Matrix[] eVectors=new Matrix[2];
            double a,b;
            double ev=evs[0];
            double[][] evect1=new double[2][1];
            a=evect1[0][0]=-1*this.matrix[0][1];
            b=evect1[1][0]=this.matrix[0][0]-ev;
            double mag=Math.pow(a*a+b*b,0.5);
            if(mag==0){
                double c,d;
                c=evect1[1][0]=-1*this.matrix[1][0];
                d=evect1[0][0]=this.matrix[1][1]-ev;
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
        e=evect2[0][0]=-1*this.matrix[0][1];
        f=evect2[1][0]=this.matrix[0][0]-ev2;
        double mag3=Math.pow(e*e+f*f,0.5);
        if(mag3==0){
            double g,h;
            g=evect2[1][0]=-1*this.matrix[1][0];
            h=evect2[0][0]=this.matrix[1][1]-ev2;
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

    public void display(){
        for(int i=0;i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                System.out.print(this.getMatrix()[i][j]+" ");

            }
            System.out.println();
        }
    }
    public Matrix multiplyByNum(double num){
        double[][] matr1 = Arrays.stream(this.matrix).map(double[]::clone).toArray(double[][]::new);

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

}
