import java.util.ArrayList;

public class OnesMatrix extends Matrix{
    private String id;
    private int rows;
    private int columns;
    //private double[][] matrix;
    private ArrayList<String> labels;

    public OnesMatrix(int rows, int columns, double[][] matrix) {
        super(rows, columns, matrix);
        this.rows=rows;
        this.columns=columns;
        labels=new ArrayList<>();
        labels.addAll(super.getLabels());
        labels.add("Ones Matrix");
        if(this.rows==this.columns){
            labels.add("Square Matrix");
            labels.add("Singular Matrix");
            labels.add("Symmetric Matrix");
        }



    }

    public double rowWiseMean() {
        System.out.println(1);
        return -1;
    }


    public double colWiseMean() {

        System.out.println(1);
        return -1;
    }




    public double allMean() {
        System.out.println(1);
        return -1;
    }

    public ArrayList<String> getLabels(){
        return this.labels;
    }

    public double det(){
        if(this.rows==this.columns){
            return 0;
        }else{
            System.out.println("Determinant not possible");
            return Integer.MIN_VALUE;
        }
    }
    public double[] eigenValues() {

        if(this.rows==this.columns) {

            double trA = 2;
            double sqrtTerm = 4;
            if (sqrtTerm < 0) {
                System.out.println("No eigen values possible");
                return null;
            }
            double ev1 = ((double) (trA + Math.pow(sqrtTerm, 0.5))) / 2;
            double ev2 = ((double) (trA - Math.pow(sqrtTerm, 0.5))) / 2;
            double[] res = new double[2];
            res[0] = ev1;
            res[1] = ev2;
            return res;
        }else{
            System.out.println("Eigen values not possible");
            return null;
        }

    }
}
