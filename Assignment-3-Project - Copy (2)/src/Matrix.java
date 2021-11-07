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
        this.setColumns(columns);
        this.setRows(rows);
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
        Matrix mat=new Matrix(this.rows,this.columns,new double[this.rows][matrix.columns]);
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
    static void getCofactor(double mat[][], double temp[][],
                            int p, int q, int n)
    {
        int i = 0, j = 0;

        // Looping for each element of
        // the matrix
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                // Copying into temporary matrix
                // only those element which are
                // not in given row and column
                if (row != p && col != q)
                {
                    temp[i][j++] = mat[row][col];
                    // Row is filled, so increase
                    // row index and reset col
                    // index
                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    /* Recursive function for finding determinant
    of matrix. n is current dimension of mat[][]. */
    static double determinantOfMatrix(double mat[][], int n)
    {
        int D = 0; // Initialize result

        // Base case : if matrix contains single
        // element
        if (n == 1)
            return mat[0][0];

        // To store cofactors
        double temp[][] = new double[n][n];

        // To store sign multiplier
        int sign = 1;

        // Iterate for each element of first row
        for (int f = 0; f < n; f++)
        {
            // Getting Cofactor of mat[0][f]
            getCofactor(mat, temp, 0, f, n);
            D += sign * mat[0][f]
                    * determinantOfMatrix(temp, n - 1);

            // terms are to be added with
            // alternate sign
            sign = -sign;
        }

        return D;
    }

     void adjoint(double A[][],double [][]adj)
    {
        int N=this.rows;
        if (N == 1)
        {
            adj[0][0] = 1;
            return;
        }

        // temp is used to store cofactors of A[][]
        int sign = 1;
        double [][]temp = new double[N][N];

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                // Get cofactor of A[i][j]
                getCofactor(A, temp, i, j, N);

                // sign of adj[j][i] positive if sum of row
                // and column indexes is even.
                sign = ((i + j) % 2 == 0)? 1: -1;

                // Interchanging rows and columns to get the
                // transpose of the cofactor matrix
                adj[j][i] = (sign)*(determinantOfMatrix(temp, N-1));
            }
        }
    }

    // Function to calculate and store inverse, returns false if
// matrix is singular
     public Matrix inverse()
    {
        // Find determinant of A[][]
        double[][] A = Arrays.stream(this.matrix).map(double[]::clone).toArray(double[][]::new);
        double [][]inverse = new double[this.rows][this.columns];
        double det = determinantOfMatrix(A, this.rows);
        if (det == 0)
        {
            System.out.print("Singular matrix, can't find its inverse");
            return null;
        }

        // Find adjoint
        double [][]adj = new double[this.rows][this.columns];
        adjoint(A, adj);

        // Find Inverse using formula "inverse(A) = adj(A)/det(A)"
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                inverse[i][j] = adj[i][j] / (double) det;
            }
        }
        Matrix res=new Matrix(this.rows,this.columns,inverse);

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
        return 0;
    }


    public double det() {
        return determinantOfMatrix(this.matrix,this.matrix.length);
    }


    public Matrix AAT() {
        double[][] matr1 = Arrays.stream(this.matrix).map(double[]::clone).toArray(double[][]::new);
        double[][] matr = Arrays.stream(this.matrix).map(double[]::clone).toArray(double[][]::new);
        Matrix mat=new Matrix(this.rows,this.columns,matr1);
        Matrix mat2=new Matrix(this.rows,this.columns,matr);
        Matrix mat22=mat2.transpose();
        Matrix res=mat.addMatrices(mat22);
        return res;
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

    public void display(){
        for(int i=0;i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                System.out.print(this.getMatrix()[i][j]+" ");

            }
            System.out.println();
        }
    }
    public Matrix multiplyByNum(int num){
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
        return invMat.mulMatrices(matrix2);
    }

}
