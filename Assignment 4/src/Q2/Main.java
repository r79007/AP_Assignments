package Q2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static int ids=0;
    private static HashMap<Integer,ColorImage> ci=new HashMap<>();
    private static HashMap<Integer,GrayImage> gi=new HashMap<>();

    public static HashMap<Integer, ColorImage> getCi() {
        return ci;
    }

    public static void setCi(HashMap<Integer, ColorImage> ci) {
        Main.ci = ci;
    }

    public static HashMap<Integer, GrayImage> getGi() {
        return gi;
    }

    public static void setGi(HashMap<Integer, GrayImage> gi) {
        Main.gi = gi;
    }

    public static <T extends Image> void negative(T img){
        if(img instanceof ColorImage){
            int r=((ColorImage) img).getRows();
            int c=((ColorImage) img).getColumns();

            ColorPixel arr[][]=new ColorPixel[((ColorImage) img).getRows()][((ColorImage) img).getColumns()];
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    ColorPixel cp=((ColorImage) img).getMatrix()[i][j];
                    double red=255-cp.getR();
                    double green=255-cp.getG();
                    double blue=255-cp.getB();

                    ColorPixel cp2=new ColorPixel(red,green,blue);

                    arr[i][j]=cp2;

                }
            }
            ColorImage cimg=new ColorImage(r,c,arr);
            cimg.display();
        }else if(img instanceof GrayImage){
            int r=((GrayImage) img).getRows();
            int c=((GrayImage) img).getColumns();
            double matrix[][] =new double[r][c];
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    double gray=255-((GrayImage) img).getMatrix()[i][j];
                    matrix[i][j]=gray;
                }
            }
            GrayImage gimg=new GrayImage(r,c,matrix);
            gimg.display();
        }
    }




    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int ip1=-1;
        while(ip1!=6){
            System.out.println("Choose option\n"+"1. Input Image\n"+"2. Display Image\n"+"3. Update Matrix\n"+"4. Show Negative Of A Matrix\n"+"5. Create Image\n"+"6. Exit\n");
            System.out.println("Enter option");
            ip1=sc.nextInt();
            if(ip1==1){
                System.out.println("Choose from\n"+"1. Color Image\n"+"2. Grayscale Image\n");
                int op=sc.nextInt();
                if(op==1){
                    System.out.print("Enter number of rows: ");
                    int r=sc.nextInt();
                    System.out.print("Enter number of columns: ");
                    int c=sc.nextInt();
                    ColorPixel arr[][]=new ColorPixel[r][c];
                    System.out.println("Input image matrix by inputting R,G,B for each cell");
                    double red=0,green=0,blue=0;

                    for(int i=0;i<r;i++){
                        for(int j=0;j<c;j++){
                            red = sc.nextDouble();
                        while(!(red>=0 && red<=255)) {

                             if(!(red>=0 && red<=255)){
                                 System.out.println("Invalid input for red, try again");
                                 red = sc.nextDouble();
                             }
                        }
                            green = sc.nextDouble();
                        while(!(green>=0 && green<=255)) {

                            if (!(green >= 0 && green <= 255)) {
                                System.out.println("Invalid input for green, try again");
                                green = sc.nextDouble();
                            }
                        }
                            blue = sc.nextDouble();
                        while(!(blue>=0 && blue<=255)) {
                            //blue = sc.nextDouble();
                            if(!(blue>=0 && blue<=255)){
                                System.out.println("Invalid input for blue, try again");
                                blue = sc.nextDouble();
                            }
                        }

                            ColorPixel cp=new ColorPixel(red,green,blue);

                            arr[i][j]=cp;

                        }
                    }
                    ColorImage cimg=new ColorImage(r,c,arr);
                    cimg.setId(ids);
                    ci.put(ids,cimg);
                    ids++;

                }else if(op==2){
                    System.out.print("Enter number of rows: ");
                    int r=sc.nextInt();
                    System.out.print("Enter number of columns: ");
                    int c=sc.nextInt();
                    System.out.println("Input image matrix by inputting gray value for each cell");
                    double matrix[][] =new double[r][c];
                    double gray=0;
                    for(int i=0;i<r;i++){
                        for(int j=0;j<c;j++){
                            gray=sc.nextDouble();
                            while(!(gray>=0 && gray<=255)) {
                                //blue = sc.nextDouble();
                                if(!(gray>=0 && gray<=255)){
                                    System.out.println("Invalid input for gray, try again");
                                    gray = sc.nextDouble();
                                }
                            }
                            matrix[i][j]=gray;
                        }
                    }
                    GrayImage gimg=new GrayImage(r,c,matrix);
                    gimg.setId(ids);
                    gi.put(ids,gimg);
                    ids++;
                }
            }else if(ip1==2){
                System.out.println("Enter id of image to be displayed");
                System.out.println("Color Images");
                for(Integer i: ci.keySet()){
                    System.out.println(i);
                }
                System.out.println("Gray scale images");
                for(Integer i: gi.keySet()){
                    System.out.println(i);
                }
                int matID=sc.nextInt();
                if(ci.containsKey(matID)){
                    ci.get(matID).display();
                }else if(gi.containsKey(matID)){
                    gi.get(matID).display();
                }else{
                    System.out.println("Wrong input id entered.");
                }
            }else if(ip1==3){
                System.out.println("Choose from\n"+"1. Color Image\n"+"2. Grayscale Image\n");
                int op=sc.nextInt();
                if(op==1){
                    System.out.println("Choose from these Color images");
                    for(Integer i: ci.keySet()){
                        System.out.println(i);
                    }

                    System.out.println();
                    int ID=sc.nextInt();
                    System.out.print("Enter number of rows: ");
                    int r=sc.nextInt();
                    System.out.print("Enter number of columns: ");
                    int c=sc.nextInt();
                    ColorPixel arr[][]=new ColorPixel[r][c];
                    System.out.println("Input image matrix by inputting R,G,B for each cell");
                    double red=0,green=0,blue=0;
                    for(int i=0;i<r;i++){
                        for(int j=0;j<c;j++){

                            red = sc.nextDouble();
                            while(!(red>=0 && red<=255)) {

                                if(!(red>=0 && red<=255)){
                                    System.out.println("Invalid input for red, try again");
                                    red = sc.nextDouble();
                                }
                            }
                            green = sc.nextDouble();
                            while(!(green>=0 && green<=255)) {

                                if (!(green >= 0 && green <= 255)) {
                                    System.out.println("Invalid input for green, try again");
                                    green = sc.nextDouble();
                                }
                            }
                            blue = sc.nextDouble();
                            while(!(blue>=0 && blue<=255)) {
                                //blue = sc.nextDouble();
                                if(!(blue>=0 && blue<=255)){
                                    System.out.println("Invalid input for blue, try again");
                                    blue = sc.nextDouble();
                                }
                            }

                            ColorPixel cp=new ColorPixel(red,green,blue);

                            arr[i][j]=cp;

                        }
                    }
                    ColorImage cimg=new ColorImage(r,c,arr);
                    cimg.setId(ID);
                    ci.put(ID,cimg);


                }else if(op==2){
                    System.out.println("Choose from these grayscale images");
                    for(Integer i: gi.keySet()){
                        System.out.println(i);
                    }
                    System.out.println();
                    int ID=sc.nextInt();
                    System.out.print("Enter number of rows: ");
                    int r=sc.nextInt();
                    System.out.print("Enter number of columns: ");
                    int c=sc.nextInt();
                    System.out.println("Input image matrix by inputting gray value for each cell");
                    double matrix[][] =new double[r][c];
                    double gray=0;
                    for(int i=0;i<r;i++){
                        for(int j=0;j<c;j++){
                            gray=sc.nextDouble();
                            while(!(gray>=0 && gray<=255)) {
                                //blue = sc.nextDouble();
                                if(!(gray>=0 && gray<=255)){
                                    System.out.println("Invalid input for gray, try again");
                                    gray = sc.nextDouble();
                                }
                            }
                            matrix[i][j]=gray;
                        }
                    }
                    GrayImage gimg=new GrayImage(r,c,matrix);
                    gimg.setId(ID);
                    gi.put(ID,gimg);

                }
            }else if(ip1==4){
                System.out.println("Choose from\n"+"1. Color Image\n"+"2. Grayscale Image\n");
                int op=sc.nextInt();
                if(op==1){
                    System.out.println("Choose from these Color images");
                    for(Integer i: ci.keySet()){
                        System.out.println(i);
                    }
                    int ID=sc.nextInt();
                    negative(ci.get(ID));
                }else if(op==2){
                    System.out.println("Choose from these grayscale images");
                    for(Integer i: gi.keySet()){
                        System.out.println(i);
                    }
                    int ID=sc.nextInt();
                    negative(gi.get(ID));
                }
            }else if(ip1==5){
                System.out.println("Choose from\n"+"1. Color Image\n"+"2. Grayscale Image\n");
                int op=sc.nextInt();
                if(op==1){
                    System.out.print("Enter number of rows: ");
                    int r=sc.nextInt();
                    System.out.print("Enter number of columns: ");
                    int c=sc.nextInt();
                    ColorPixel arr[][]=new ColorPixel[r][c];
                    //System.out.println("Input image matrix by inputting R,G,B for each cell");
                    double red=0,green=0,blue=0;

                    for(int i=0;i<r;i++){
                        for(int j=0;j<c;j++){
                            //red = sc.nextDouble();
                            while(!(red>=0 && red<=255)) {

                                if(!(red>=0 && red<=255)){
                                    System.out.println("Invalid input for red, try again");
                                    red = sc.nextDouble();
                                }
                            }
                            //green = sc.nextDouble();
                            while(!(green>=0 && green<=255)) {

                                if (!(green >= 0 && green <= 255)) {
                                    System.out.println("Invalid input for green, try again");
                                    green = sc.nextDouble();
                                }
                            }
                            //blue = sc.nextDouble();
                            while(!(blue>=0 && blue<=255)) {
                                //blue = sc.nextDouble();
                                if(!(blue>=0 && blue<=255)){
                                    System.out.println("Invalid input for blue, try again");
                                    blue = sc.nextDouble();
                                }
                            }

                            ColorPixel cp=new ColorPixel(red,green,blue);

                            arr[i][j]=cp;

                        }
                    }
                    ColorImage cimg=new ColorImage(r,c,arr);
                    cimg.setId(ids);
                    ci.put(ids,cimg);
                    ids++;

                }else if(op==2){
                    System.out.print("Enter number of rows: ");
                    int r=sc.nextInt();
                    System.out.print("Enter number of columns: ");
                    int c=sc.nextInt();
                    //System.out.println("Input image matrix by inputting gray value for each cell");
                    double matrix[][] =new double[r][c];
                    double gray=0;
                    for(int i=0;i<r;i++){
                        for(int j=0;j<c;j++){
                            //gray=sc.nextDouble();
                            while(!(gray>=0 && gray<=255)) {
                                //blue = sc.nextDouble();
                                if(!(gray>=0 && gray<=255)){
                                    System.out.println("Invalid input for gray, try again");
                                    gray = sc.nextDouble();
                                }
                            }
                            matrix[i][j]=gray;
                        }
                    }
                    GrayImage gimg=new GrayImage(r,c,matrix);
                    gimg.setId(ids);
                    gi.put(ids,gimg);
                    ids++;
                }
            }


        }
    }
    
}
