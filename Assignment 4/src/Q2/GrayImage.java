package Q2;

public class GrayImage extends Image{
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

    public double[][] getMatrix() {
        return this.matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    private int rows;
    private int columns;
    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void display(){
        for(int i=0;i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                System.out.print(this.matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public GrayImage(int rows, int columns, double[][] matrix) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = matrix;
    }

    private double matrix[][];


}
