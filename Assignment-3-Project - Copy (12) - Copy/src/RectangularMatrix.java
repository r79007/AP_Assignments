import java.util.ArrayList;

public class RectangularMatrix extends Matrix{

    private String id;
    private int rows;
    private int columns;
    private double[][] matrix;
    private ArrayList<String> labels=new ArrayList<>();





    public String getID() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int getRows() {
        return this.rows;
    }

    @Override
    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public void setColumns(int columns) {
        this.columns = columns;
    }

    @Override
    public double[][] getMatrix() {
        return this.matrix;
    }

    @Override
    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public RectangularMatrix(int rows, int columns, double[][] matrix) {
        super(rows, columns, matrix);
        labels.addAll(super.getLabels());
        labels.add("Rectangular Matrix");
        this.rows=rows;
        this.columns=columns;
        this.matrix=matrix;
    }
    public double det() {
        System.out.println("Not possible calculate determinant of a rectangular matrix");
        return Integer.MIN_VALUE;
    }
    public Matrix divMatrices(Matrix matrix) {
        //Matrix newMatrix=new Matrix(this.rows,this.columns,this.matrix);
        Matrix mat1=matrix.inverse();
        if(mat1==null){
            System.out.println("Division is not possible");
            return null;
        }
        if(this.columns==mat1.getRows()) {
            Matrix mat2 = this.mulMatrices(mat1);
            return mat2;
        }else{
            System.out.println("Division is not possible");
            return null;
        }


        //System.out.println("Cannot divide rectangular matrices.");


    }
    public Matrix inverse(){
        System.out.println("Cannot find inverse");
        return null;
    }

    public Matrix AAT(){
//        double[][] matr = Arrays.stream(this.matrix).map(int[]::clone).toArray(double[][]::new);
//        Matrix m=new Matrix(1,1,matr);
        System.out.println("A+A^T is not possible");
        return null;
    }



//    public void divMatrices(){
//        System.out.println("Dividing rectangular matrices is not possible");
//    }

//    public Matrix transpose(){
//        Matrix mat=new Matrix(this.columns,this.rows,new double[this.columns][this.rows]);
//        int temp=this.rows;
//        this.rows=this.columns;
//        this.columns=temp;
//        double [][]newMatrix=new double[this.rows][this.columns];
//        mat.setMatrix(newMatrix);
//        for(int i=0;i<this.rows;i++){
//            for(int j=0;j<this.columns;j++){
//                mat.getMatrix()[i][j]=this.getMatrix()[j][i];
//            }
//        }
//        return mat;
//    }

    public ArrayList<String> getLabels(){
        return this.labels;
    }



}
