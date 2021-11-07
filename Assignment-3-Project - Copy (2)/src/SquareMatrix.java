import java.util.ArrayList;

public class SquareMatrix extends Matrix{
    private String id;
    private int rows;
    private double[][] matrix;
    private ArrayList<String> labels;

    public String getID() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    //private int columns;



    public SquareMatrix(int rows, double[][] matrix) {
        super(rows, rows, matrix);
        this.matrix=matrix;
        this.rows=rows;
        labels=new ArrayList<>();
        labels.addAll(super.getLabels());
        labels.add("Square Matrix");

    }

    public int getColumns(){
        return this.rows;
    }

    public ArrayList<String> getLabels(){
        return this.labels;
    }

}
