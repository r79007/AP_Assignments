import java.util.ArrayList;

public class SingletonMatrix extends SquareMatrix{
    private String id;


    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int getRows() {
        return 1;
    }



    @Override
    public int getColumns() {
        return 1;
    }



    @Override
    public double[][] getMatrix() {
        return matrix;
    }

    @Override
    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public ArrayList<String> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<String> labels) {
        this.labels = labels;
    }

    private double[][] matrix;
    private ArrayList<String> labels;


    public SingletonMatrix(double[][] matrix) {
        super(1, matrix);
        labels=new ArrayList<>();
        labels.addAll(super.getLabels());
        labels.add("Singleton Matrix");
    }


}
