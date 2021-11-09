import java.util.ArrayList;
import java.util.Arrays;

public class SymmetricMatrix extends SquareMatrix {
    private String id;


    public String getID() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    private int rows;
    //private int columns;
    private double[][] matrix;
    private ArrayList<String> labels=new ArrayList<>();


    public SymmetricMatrix(int rows, double[][] matrix) {
        super(rows, matrix);
        labels.addAll(super.getLabels());
        labels.add("Symmetric Matrix");
        this.rows=rows;
        this.matrix=matrix;

    }

    public Matrix AAT() {
        double[][] matr1 = Arrays.stream(this.matrix).map(double[]::clone).toArray(double[][]::new);
        double[][] matr = Arrays.stream(this.matrix).map(double[]::clone).toArray(double[][]::new);
        SymmetricMatrix mat=new SymmetricMatrix(this.rows,matr1);
        SymmetricMatrix mat2=new SymmetricMatrix(this.rows,matr);

        Matrix res=mat.addMatrices(mat2);
        return res;
    }


    public Matrix transpose(){
        return this;
    }

    public ArrayList<String> getLabels(){
        return this.labels;
    }
}
