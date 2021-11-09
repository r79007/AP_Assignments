import java.util.ArrayList;

public class RowMatrix extends RectangularMatrix{
    private String id;
    private int columns;
    private ArrayList<String> labels=new ArrayList<>();
    private double[][] matrix;


    public double[][] getMatrix() {
        return this.matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    
    public int getColumns() {
        return this.columns;
    }

    
    public void setColumns(int columns) {
        this.columns = columns;
    }

    public RowMatrix(int columns, double[][] matrix) {

        super(1, columns, matrix);
        this.columns=columns;
        this.matrix=matrix;
        labels.addAll(super.getLabels());

        labels.add("Row Matrix");
    }

    public int getRows(){
        return 1;
    }



    
    public Matrix divMatrices(Matrix m) {
        System.out.println("Division not possible");
        return null;

    }

    
    public Matrix inverse() {
        System.out.println("Inverse not possible");
        return null;
    }

    


    

    
    public double det() {
        System.out.println("Determinant is not possible");
        return -1;
    }

    
    public RowMatrix AAT() {
        System.out.println("A+A^T is not possible.");
        return null;
    }

    
//    public int eigenVectors(Matrix matrix) {
//        return 0;
//    }
//
//
//    public int eigenValues(Matrix matrix) {
//        return 0;
//    }

    
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
