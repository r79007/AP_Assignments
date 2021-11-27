package Q2;

import java.util.ArrayList;

public class ColorImage extends Image{
    private int rows;
    private int columns;
    private ColorPixel matrix[][];
    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public ColorPixel[][] getMatrix() {
        return this.matrix;
    }

    public void setMatrix(ColorPixel[][] matrix) {
        this.matrix = matrix;
    }

    public void display(){
        for(int i=0;i<this.rows;i++){
            ArrayList<ColorPixel> arrl=new ArrayList<>();
            for(int j=0;j<this.columns;j++){


                ColorPixel cp=this.matrix[i][j];
                arrl.add(cp);
//                System.out.println("r: "+cp.getR());
//                System.out.println("g: "+cp.getG());
//                System.out.println("b: "+cp.getB());
            }
            for(int i1=0;i1<this.columns;i1++){
                System.out.print("r: "+arrl.get(i1).getR()+"| ");

            }
            System.out.println();
            for(int i2=0;i2<this.columns;i2++){
                System.out.print("g: "+arrl.get(i2).getG()+"| ");

            }
            System.out.println();
            for(int i3=0;i3<this.columns;i3++) {
                System.out.print("b: "+arrl.get(i3).getB() + "| ");

            }
            System.out.println();
            System.out.println("------------");
        }
    }

    public ColorImage(int rows, int columns, ColorPixel[][] matrix) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = matrix;
    }
}
