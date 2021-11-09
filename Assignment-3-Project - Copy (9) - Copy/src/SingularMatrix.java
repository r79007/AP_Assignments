import java.util.ArrayList;

public class SingularMatrix extends SquareMatrix{
    private String id;
    private int rows;
    private double[][] matrix;
    private ArrayList<String> labels;


    public SingularMatrix(int rows, double[][] matrix) {
        super(rows, matrix);
        this.rows=rows;
        this.matrix=matrix;
        labels=new ArrayList<>();
        labels.addAll(super.getLabels());
        labels.add("Singular Matrix");
    }
    public double det() {
        return 0;
    }
    public Matrix inverse(){
        System.out.println("Cannot find inverse");
        return null;
    }

    public ArrayList<String> getLabels(){
        return this.labels;
    }
//    public Matrix divMatrices(Matrix matrix) {
//        // Matrix newMatrix=new Matrix(this.rows,this.columns,this.matrix);
//        Matrix mat1=matrix.inverse();
//        if(mat1==null){
//            System.out.println("Division is not possible");
//            return null;
//        }
//        Matrix mat2=mat1.mulMatrices(matrix);
//
//        return mat2;
//
//    }

}
