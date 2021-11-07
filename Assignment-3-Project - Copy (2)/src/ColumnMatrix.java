import java.util.ArrayList;

public class ColumnMatrix extends RectangularMatrix{
    private String id;
    private int cols;
    private ArrayList<String> labels=new ArrayList<>();
    private double[][] matrix;

    public ColumnMatrix(int columns, double[][] matrix) {
        super(0, columns, matrix);
        this.matrix=matrix;
        labels.addAll(super.getLabels());

        labels.add("Column Matrix");
    }

    public double[][] getMatrix() {
        return this.matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }


    public int getCols() {
        return this.cols;
    }


    public void setCols(int cols) {
        this.cols = cols;
    }






    public Matrix divMatrices(Matrix m) {
        System.out.println("Division not possible");
        return null;

    }


    public Matrix inverse() {
        System.out.println("Inverse not possible");
        return null;
    }


//    public Matrix transpose() {
//
//    }


    public int rowWiseMean(MatrixCalc matrix) {
        return 0;
    }


    public int colWiseMean(MatrixCalc matrix) {
        return 0;
    }


    public int allMean(MatrixCalc matrix) {
        return 0;
    }


    public double det() {
        System.out.println("Determinant is not possible");
        return -1;
    }


    public ColumnMatrix AAT() {
        System.out.println("A+A^T is not possible.");
        return null;
    }


    public int eigenVectors(MatrixCalc matrix) {
        return 0;
    }


    public int eigenValues(MatrixCalc matrix) {
        return 0;
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


