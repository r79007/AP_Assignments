import java.util.ArrayList;

public class RowMatrix extends RectangularMatrix{
    private String id;
    private int rows;
    private ArrayList<String> labels=new ArrayList<>();
    private double[][] matrix;


    public double[][] getMatrix() {
        return this.matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    
    public int getRows() {
        return rows;
    }

    
    public void setRows(int rows) {
        this.rows = rows;
    }

    public RowMatrix(int rows, double[][] matrix) {

        super(rows, 0, matrix);
        this.rows=rows;
        this.matrix=matrix;
        labels.addAll(super.getLabels());

        labels.add("Row Matrix");
    }





    
    public Matrix divMatrices(Matrix m) {
        System.out.println("Division not possible");
        return null;

    }

    
    public Matrix inverse() {
        System.out.println("Inverse not possible");
        return null;
    }

    


    
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

    
    public RowMatrix AAT() {
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
