
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static int ids = 0;
    static HashMap<String, Matrix> matrices = new HashMap<>();

    static Boolean checkAddSub(Matrix mat1, Matrix mat2) {
        if (!(mat1.getColumns() == mat2.getColumns() && mat1.getRows() == mat2.getRows())) {
            System.out.println("Operation Not possible");
            return false;
        } else {
            return true;
        }
    }

    static Boolean checkMult(Matrix mat1, Matrix mat2) {
        if (!(mat1.getColumns() == mat2.getRows() || mat1.getRows()==mat2.getColumns())) {
            System.out.println("Operation not possible");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ip1 = -1;
        while (ip1 != 16) {
            System.out.println("1. Take matrices as input and label them with appropriate matrix-types.\n" +
                    "2. Create matrices of requested matrix-types and label them with appropriate matrix-types.\n" +
                    "3. Change the elements of a matrix as long as the fixed matrix-type labels remain valid.\n" +
                    "4. Display all the matrix-type labels of a requested matrix.\n" +
                    "5. Perform addition, subtraction, multiplication & division.\n" +
                    "6. Perform element-wise operations.\n" +
                    "7. Transpose matrices.\n" +
                    "8. Inverse matrices.\n" +
                    "9. Compute means: row-wise mean, column-wise mean, mean of all the elements.\n" +
                    "10. Compute determinants.\n" +
                    "11. Use singleton matrices as scalars, if requested.\n" +
                    "12. Compute A+AT for a matrix A.\n" +
                    "13. Compute Eigen vectors and values.\n" +
                    "14. Solve sets of linear equations using matrices.\n" +
                    "15. Retrieve all the existing matrices (entered or created) having requested matrix-type labels.\n" + "16. Exit");
            ip1 = sc.nextInt();
            if (ip1 == 1) {
                System.out.print("Enter number of rows: ");
                int r = sc.nextInt();
                System.out.print("Enter number of columns: ");
                int c = sc.nextInt();
                double[][] matrix = new double[r][c];
                boolean zeroFlag = true;
                boolean onesFlag = true;

                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        matrix[i][j] = sc.nextDouble();
                        if (matrix[i][j] != 0) {
                            zeroFlag = false;
                        }
                        if (matrix[i][j] != 1) {
                            onesFlag = false;
                        }

                    }
                }
                if (zeroFlag == true) {
                    NullMatrix nm = new NullMatrix(r, c);
                    nm.setId(Integer.toString(ids));
                    matrices.put(nm.getID(), nm);
                    if(r==c){
                        nm.getLabels().add("Singular Matrix");
                    }
                    ids++;
                } else if (c == 1 && r != c) {
                    ColumnMatrix cm = new ColumnMatrix(r, matrix);
                    cm.setId(Integer.toString(ids));
                    matrices.put(cm.getID(), cm);
                    ids++;
                } else if (r == 1 && r != c) {
                    RowMatrix rm = new RowMatrix(c, matrix);
                    rm.setId(Integer.toString(ids));
                    matrices.put(rm.getID(), rm);
                    ids++;
                } else if (onesFlag == true) {
                    OnesMatrix om = new OnesMatrix(r, c, matrix);
                    om.setId(Integer.toString(ids));
                    matrices.put(om.getID(), om);
                    ids++;
                } else if (r != c) {
                    RectangularMatrix rectMatrix = new RectangularMatrix(r, c, matrix);
                    rectMatrix.setId(Integer.toString(ids));
                    matrices.put(rectMatrix.getID(), rectMatrix);
                    ids++;
                } else if (r == c) {
                    boolean symmetricFlag = true;
                    boolean SkewSymmetricFlag = true;
                    boolean identityFlag = true;
                    boolean diagonalFlag = true;
                    double scalar = matrix[0][0];
                    boolean scalarFlag = true;
                    boolean uppertriFlag = true;
                    boolean lowertriFlag = true;
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            if (matrix[i][j] != matrix[j][i]) {
                                symmetricFlag = false;
                            }
                            if (matrix[i][j] != -1 * matrix[j][i] || (i == j && matrix[i][j] != 0)) {
                                SkewSymmetricFlag = false;
                            }
                            if (!((matrix[i][j] == matrix[j][i] && matrix[i][j] == 0) || (i == j && matrix[i][j] == 1))) {
                                identityFlag = false;
                            }
                            if (!(matrix[i][j] == matrix[j][i] || (i!=j && matrix[i][j] == 0))) {
                                diagonalFlag = false;
                            }
                            if (!(diagonalFlag || (i==j && matrix[i][j] == scalar))) {
                                scalarFlag = false;
                            }

                        }
                        //super.AddALl
                    }
                    if (r > 1 && c > 1) {
                        for (int i = 1; i < r; i++) {
                            for (int j = 0; j < i; j++) {
                                if (matrix[i][j] != 0) {
                                    uppertriFlag = false;
                                }
                            }
                        }
                        for (int i = 0; i < r; i++) {
                            for (int j = i + 1; j < c; j++) {
                                if (matrix[i][j] != 0) {
                                    lowertriFlag = false;
                                }
                            }
                        }

                    }

                    if (r == 1) {

                        SingletonMatrix sgm = new SingletonMatrix(matrix);
                        sgm.setId(Integer.toString(ids));
                        matrices.put(sgm.getID(), sgm);
                        if(matrix[0][0]==0){
                            sgm.getLabels().add("Singular Matrix");
                        }
                        ids++;
                    } else if (identityFlag == true) {
                        IdentityMatrix idm = new IdentityMatrix(r, matrix);
                        idm.setId(Integer.toString(ids));
                        matrices.put(idm.getID(), idm);
                        ids++;
                    } else if (scalarFlag == true) {
                        ScalarMatrix scm = new ScalarMatrix(r, matrix);
                        scm.setId(Integer.toString(ids));
                        matrices.put(scm.getID(), scm);

                        ids++;
                    } else if (diagonalFlag == true) {
                        DiagonalMatrix dm = new DiagonalMatrix(r, matrix);
                        dm.setId(Integer.toString(ids));
                        matrices.put(dm.getID(), dm);
                        ids++;
                    } else if (symmetricFlag == true) {
                        SymmetricMatrix sm = new SymmetricMatrix(r, matrix);
                        sm.setId(Integer.toString(ids));
                        matrices.put(sm.getID(), sm);
                        ids++;
                    } else if (SkewSymmetricFlag == true) {
                        SkewSymmetricMatrix skm = new SkewSymmetricMatrix(r, matrix);
                        skm.setId(Integer.toString(ids));
                        matrices.put(skm.getID(), skm);
                        ids++;
                    } else if (uppertriFlag == true) {
                        SquareMatrix sqm = new SquareMatrix(r, matrix);
                        sqm.getLabels().add("Upper Triangular Matrix");
                        sqm.setId(Integer.toString(ids));
                        matrices.put(sqm.getID(), sqm);
                        ids++;
                    } else if (lowertriFlag == true) {
                        SquareMatrix sqm = new SquareMatrix(r, matrix);
                        sqm.getLabels().add("Lower Triangular Matrix");
                        sqm.setId(Integer.toString(ids));
                        matrices.put(sqm.getID(), sqm);
                        ids++;
                    } else {
                        SquareMatrix sqm = new SquareMatrix(r, matrix);
                        //sqm.getLabels().add("Lower Triangular Matrix");
                        sqm.setId(Integer.toString(ids));
                        matrices.put(sqm.getID(), sqm);
                        ids++;
                        //System.out.println("In sqm");
                    }
                }


            } else if (ip1 == 5) {
                System.out.println("Choose:\n" + "1. Addition\n" + "2. Subtraction\n" + "3. Multiplication\n" + "4. Division\n");
                int op = sc.nextInt();
                if (op == 1) {
                    System.out.println("Choose two matrices from");
                    for (String i : matrices.keySet()) {
                        System.out.println();
                        System.out.print(i + " ");


                    }
                    String ip2 = sc.next();
                    String ip3 = sc.next();
                    Matrix mat1 = matrices.get(ip2);
                    Matrix mat2 = matrices.get(ip3);
                    Boolean val = checkAddSub(mat1, mat2);
                    if (val == true) {
                        //if (mat1.getLabels().contains("Diagonal Matrix") || mat1.getLabels().contains("Identity Matrix") || mat1.getLabels().contains("Null Matrix") || mat1.getLabels().contains("Scalar Matrix")) {

                            Matrix res = mat1.addMatrices(mat2);
                            res.display();

                       // }
//                        else {
//
//                            Matrix res = mat2.addMatrices(mat1);
//                            res.display();
//
//
//                        }
                    }

                } else if (op == 2) {
                    System.out.println("Choose two matrices from");
                    for (String i : matrices.keySet()) {
                        System.out.println();
                        System.out.print(i + " ");


                    }
                    String ip2 = sc.next();
                    String ip3 = sc.next();
                    Matrix mat1 = matrices.get(ip2);
                    Matrix mat2 = matrices.get(ip3);
                    Boolean val = checkAddSub(mat1, mat2);
                    if (val == true) {
                        //if (mat1.getLabels().contains("Diagonal Matrix") || mat1.getLabels().contains("Identity Matrix") || mat1.getLabels().contains("Null Matrix") || mat1.getLabels().contains("Scalar Matrix")) {
                            Matrix res = mat1.subMatrices(mat2);
                            res.display();
                        }
//                        else {
//                            Matrix res = mat2.subMatrices(mat1);
//                            res.display();
//                        }
                    //}
                } else if (op == 3) {
                    System.out.println("Choose two matrices from");
                    for (String i : matrices.keySet()) {
                        System.out.println();
                        System.out.print(i + " ");


                    }
                    String ip2 = sc.next();
                    String ip3 = sc.next();
                    Matrix mat1 = matrices.get(ip2);
                    Matrix mat2 = matrices.get(ip3);
                    Boolean val = checkMult(mat1, mat2);
                    if (val == true) {
                        if (mat1.getRows() == mat2.getRows() && mat1.getColumns() == mat2.getColumns()) {
//                            if(mat1.getLabels().contains("Null Matrix") || mat1.getLabels().contains("Diagonal Matrix") || mat2.getLabels().contains("Null Matrix") || mat2.getLabels().contains("Diagonal Matrix")) {
//                                if ((mat1.getLabels().contains("Null Matrix")) || (mat1.getLabels().contains("Diagonal Matrix") && !(mat2.getLabels().contains("Null Matrix")) && !(mat2.getLabels().contains("Identity Matrix")) && !(mat2.getLabels().contains("Scalar Matrix"))) || (mat1.getLabels().contains("Scalar Matrix") && !(mat2.getLabels().contains("Identity Matrix"))) || (mat1.getLabels().contains("Identity Matrix") && !(mat2.getLabels().contains("Null Matrix")))) {
//                                    Matrix res = mat1.mulMatrices(mat2);
//                                    if (res != null) {
//                                        res.display();
//                                    }
//                                } else {
//                                    Matrix res = mat2.mulMatrices(mat1);
//                                    if (res != null) {
//                                        res.display();
//                                    }
//                                }
//                            }else{
                                Matrix res = mat1.mulMatrices(mat2);
                                if (res != null) {
                                    res.display();
                                }
                            //}
                        } else {
                            if (mat1.getColumns() == mat2.getRows()) {
                                Matrix res = mat1.mulMatrices(mat2);
                                if(res!=null) {
                                    res.display();
                                }
                            } else if (mat2.getColumns() == mat1.getRows()) {
                                Matrix res = mat2.mulMatrices(mat1);
                                if(res!=null) {
                                    res.display();
                                }
                            } else {
                                System.out.println("Multiplication is not possible");
                            }
                        }
                    }
                } else if (op == 4) {
                    System.out.println("Choose two matrices from");
                    for (String i : matrices.keySet()) {
                        System.out.println();
                        System.out.print(i + " ");


                    }
                    String ip2 = sc.next();
                    String ip3 = sc.next();
                    Matrix mat1 = matrices.get(ip2);
                    Matrix mat2 = matrices.get(ip3);
                    Boolean val = checkMult(mat1, mat2);
                    if (val == true) {
                        //if ((mat1.getLabels().contains("Null Matrix")) || (mat1.getLabels().contains("Identity Matrix") && !(mat2.getLabels().contains("Null Matrix")))) {
                            if (mat2.getLabels().contains("Square Matrix") && !mat2.getLabels().contains("Null Matrix")) {
                                Matrix res = mat1.divMatrices(mat2);

                                if(res!=null) {
                                    res.display();
                                }
                            } else {
                                System.out.println("Division not possible");
                            }
//                        } else {
//                            if (mat1.getLabels().contains("Square Matrix") && !mat1.getLabels().contains("Null Matrix")) {
//                                Matrix res = mat2.divMatrices(mat1);
//                                if(res!=null) {
//                                    res.display();
//                                }
//
//                            } else {
//                                System.out.println("Division not possible");
//                            }
//
//                        }
                    }
                }
            } else if (ip1 == 7) {
                System.out.println("Choose matrix from");
                for (String i : matrices.keySet()) {
                    System.out.println();
                    System.out.print(i + " ");


                }
                String ip2 = sc.next();

                Matrix mat1 = matrices.get(ip2);
                Matrix res = mat1.transpose();
                if(res!=null) {
                    res.display();
                }
            } else if (ip1 == 8) {
                System.out.println("Choose matrix from");
                for (String i : matrices.keySet()) {
                    System.out.println();
                    System.out.print(i + " ");


                }
                String ip2 = sc.next();

                Matrix mat1 = matrices.get(ip2);
                Matrix res = mat1.inverse();
                if(res!=null) {
                    res.display();
                }
            } else if (ip1 == 10) {
                System.out.println("Choose matrix from");
                for (String i : matrices.keySet()) {
                    System.out.println();
                    System.out.print(i + " ");


                }
                String ip2 = sc.next();

                Matrix mat1 = matrices.get(ip2);
                double res = mat1.det();
                if(res!=Integer.MIN_VALUE && res!=Double.MIN_VALUE) {
                    System.out.println(res);
                }else{
                    System.out.println("Determinant not possible");
                }
            } else if (ip1 == 12) {
                System.out.println("Choose matrix from");
                for (String i : matrices.keySet()) {
                    System.out.println();
                    System.out.print(i + " ");


                }
                String ip2 = sc.next();

                Matrix mat1 = matrices.get(ip2);
                Matrix res = mat1.AAT();
                if(res!=null) {
                    res.display();
                }
            } else if (ip1 == 4) {
                System.out.println("Choose matrix from");
                for (String i : matrices.keySet()) {
                    System.out.println();
                    System.out.print(i + " ");


                }
                System.out.println();
                String ip2 = sc.next();
                Matrix mat1 = matrices.get(ip2);
                for (String i : mat1.getLabels()) {
                    System.out.println(i);
                }
            } else if (ip1 == 14) {
                System.out.println("Choose a square matrix from");
                for (String i : matrices.keySet()) {
                    System.out.print(i + " ");


                }
                System.out.println();
                String ip2 = sc.next();
                System.out.println();
                System.out.println("Choose a column matrix from");
                for (String i : matrices.keySet()) {

                    System.out.print(i + " ");


                }
                String ip3 = sc.next();
                Matrix mat1 = matrices.get(ip2);
                Matrix mat2 = matrices.get(ip3);
                Matrix res = mat1.solve(mat2);
                if(res!=null) {
                    res.display();
                }else{
                    System.out.println("No solutions");
                }
            } else if (ip1 == 11) {
                System.out.println("Use singleton matrix in matrix operations. Do you allow using singleton matrices as a scalar value?(y/n)");
                String ch = sc.next();
                if (ch.equals("y")) {
                    System.out.println("Then choose a matrix from");
                    for (String i : matrices.keySet()) {
                        System.out.print(i + " ");
                    }
                    String ip2 = sc.next();
                    System.out.println();
                    System.out.println("Choose a singleton matrix now");
                    for (String i : matrices.keySet()) {
                        System.out.print(i + " ");
                    }
                    String ip3 = sc.next();
                    System.out.println("Choose 1 for multiplication and 2 for division");
                    int op=sc.nextInt();
                    if(op==1) {

                        Matrix mat1 = matrices.get(ip2);
                        Matrix mat2 = matrices.get(ip3);
                        double num = mat2.getMatrix()[0][0];
                        Matrix res = mat1.multiplyByNum(num);
                        if(res!=null) {
                            res.display();
                        }
                    }else if(op==2){

                        Matrix mat1 = matrices.get(ip2);
                        Matrix mat2 = matrices.get(ip3);
                        double num = mat2.getMatrix()[0][0];
                        Matrix res = mat1.multiplyByNum(((double)1)/num);
                        if(res!=null) {
                            res.display();
                        }
                    }
                }
            } else if (ip1 == 15) {
                System.out.println("Choose from");
                System.out.println("1. Rectangular Matrix\n" +
                        "2. Row Matrix\n" +
                        "3. Column Matrix\n" +
                        "4. Square Matrix\n" +
                        "5. Symmetric Matrix\n" +
                        "6. Skew Symmetric Matrix\n" +
                        "7. Upper Triangular Matrix\n" +
                        "8. Lower Triangular Matrix\n" +
                        "9. Singular Matrix\n" +
                        "10. Diagonal Matrix\n" +
                        "11. Scalar Matrix\n" +
                        "12. Identity Matrix\n" +
                        "13. Singleton Matrix\n" +
                        "14. Ones Matrix\n" +
                        "15. Null Matrix");
                sc.nextLine();
                System.out.println("Enter the name of the matrix-type");
                String op = sc.nextLine();

                for (String i : matrices.keySet()) {
                    if (matrices.get(i).getLabels().contains(op) == true) {
                        System.out.println("ID: " + i);
                        System.out.println();
                        matrices.get(i).display();
                    }
                }
            } else if (ip1 == 13) {
                System.out.println("1. Eigenvalues\n" + "2. Eigenvectors\n");
                int op = sc.nextInt();
                if (op == 1) {
                    System.out.println("Choose from");
                    for (String i : matrices.keySet()) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    String ip2 = sc.next();
                    Matrix mat1 = matrices.get(ip2);
                    double[] res = mat1.eigenValues();
                    for (double i : res) {
                        System.out.println(i);
                    }
                } else {
                    System.out.println("Choose from");
                    for (String i : matrices.keySet()) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    String ip2 = sc.next();
                    Matrix mat1 = matrices.get(ip2);
                    Matrix[] res = mat1.eigenVectors();
                    for (Matrix j : res) {
                        j.display();
                        System.out.println();
                    }
                }
            } else if (ip1 == 9) {
                System.out.println("Choose a matrix from");
                for (String i : matrices.keySet()) {
                    System.out.print(i + " ");
                }
                System.out.println();
                String ip2 = sc.next();
                Matrix mat1 = matrices.get(ip2);
                System.out.println();
                System.out.println("Choose from");
                System.out.println("1. Row wise mean\n" + "2. Column Wise Mean\n" + "3. Mean of all elements\n");
                System.out.println();
                int op = sc.nextInt();
                if (op == 1) {
                    mat1.rowWiseMean();
                } else if (op == 2) {
                    mat1.colWiseMean();
                } else {
                    mat1.allMean();
                }
            } else if (ip1 == 6) {
                System.out.println("Choose two matrices from");
                for (String i : matrices.keySet()) {
                    System.out.println();
                    System.out.print(i + " ");


                }
                String ip2 = sc.next();
                String ip3 = sc.next();
                Matrix mat1 = matrices.get(ip2);
                Matrix mat2 = matrices.get(ip3);
                if(mat1.getColumns()==mat2.getColumns() && mat1.getRows()==mat2.getRows()) {
                    System.out.println("Choose:\n" + "1. Addition\n" + "2. Subtraction\n" + "3. Multiplication\n" + "4. Division\n");
                    int op = sc.nextInt();
                    if (op == 1) {
                        if(mat1.elementWiseOperation(mat2, "add")!=null){
                            mat1.elementWiseOperation(mat2, "add").display();
                        }else{
                            System.out.println("Not possible");
                        }
                    } else if (op == 2) {
                        if(mat1.elementWiseOperation(mat2, "sub")!=null){
                            mat1.elementWiseOperation(mat2, "sub").display();
                        }else{
                            System.out.println("Not possible");
                        }
                    } else if (op == 3) {
                        if(mat1.elementWiseOperation(mat2, "mul")!=null){
                            mat1.elementWiseOperation(mat2, "mul").display();
                        }else{
                            System.out.println("Not possible");
                        }
                    } else if (op == 4) {
                        if(mat1.elementWiseOperation(mat2, "div")!=null){
                            mat1.elementWiseOperation(mat2, "div").display();
                        }else{
                            System.out.println("Not possible");
                        }
                    } else {
                        System.out.println("Wrong operation");
                    }
                }else{
                    System.out.println("Not eligible for element wise operations");
                }
            } else if (ip1 == 2) {
                System.out.println("Choose from");
                System.out.println("1. Rectangular Matrix\n" +
                        "2. Row Matrix\n" +
                        "3. Column Matrix\n" +
                        "4. Square Matrix\n" +
                        "5. Symmetric Matrix\n" +
                        "6. Skew Symmetric Matrix\n" +
                        "7. Upper Triangular Matrix\n" +
                        "8. Lower Triangular Matrix\n" +
                        "9. Singular Matrix\n" +
                        "10. Diagonal Matrix\n" +
                        "11. Scalar Matrix\n" +
                        "12. Identity Matrix\n" +
                        "13. Singleton Matrix\n" +
                        "14. Ones Matrix\n" +
                        "15. Null Matrix");

                System.out.println("Enter the option of the matrix-type");
                int op = sc.nextInt();
                if (op == 1) {
                    int ele = 5;
                    double[][] matrix = new double[2][3];
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 3; j++) {
                            matrix[i][j] = ele;
                            ele++;
                        }


                    }

                    RectangularMatrix rectMatrix = new RectangularMatrix(2, 3, matrix);
                    rectMatrix.setId(Integer.toString(ids));
                    matrices.put(rectMatrix.getID(), rectMatrix);
                    ids++;
                } else if (op == 3) {
                    double[][] matrix = new double[2][1];
                    matrix[0][0] = 1;
                    matrix[1][0] = 5;
                    ColumnMatrix cm = new ColumnMatrix(2, matrix);
                    cm.setId(Integer.toString(ids));
                    matrices.put(cm.getID(), cm);
                    ids++;
                } else if (op == 4) {
                    int ele = 1;
                    double[][] matrix = new double[2][2];
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                            matrix[i][j] = ele;
                            ele++;
                        }
                    }
                    SquareMatrix sqm = new SquareMatrix(2, matrix);
                    //sqm.getLabels().add("Lower Triangular Matrix");
                    sqm.setId(Integer.toString(ids));
                    matrices.put(sqm.getID(), sqm);
                    ids++;
                } else if (op == 2) {
                    double[][] matrix = new double[1][2];
                    matrix[0][0] = 1;
                    matrix[0][1] = 5;
                    int r = 1;
                    int c = 2;
                    RowMatrix rm = new RowMatrix(c, matrix);
                    rm.setId(Integer.toString(ids));
                    matrices.put(rm.getID(), rm);
                    ids++;
                } else if (op == 5) {
                    int r = 3;
                    int c = 3;
                    double[][] matrix = {{1, 1, -1}, {1, 2, 0}, {-1, 0, 5}};
                    SymmetricMatrix sm = new SymmetricMatrix(r, matrix);
                    sm.setId(Integer.toString(ids));
                    matrices.put(sm.getID(), sm);
                    ids++;
                } else if (op == 6) {
                    int r = 3;
                    int c = 3;
                    double[][] matrix = {{0, 1, -2}, {-1, 0, 3}, {2, -3, 0}};
                    SkewSymmetricMatrix skm = new SkewSymmetricMatrix(r, matrix);
                    skm.setId(Integer.toString(ids));
                    matrices.put(skm.getID(), skm);
                    ids++;
                } else if (op == 7) {
                    int r = 3;
                    int c = 3;
                    double[][] matrix = {{1, 2, 3}, {0, 5, 6}, {0, 0, 9}};
                    SquareMatrix sqm = new SquareMatrix(r, matrix);
                    sqm.getLabels().add("Upper Triangular Matrix");
                    sqm.setId(Integer.toString(ids));
                    matrices.put(sqm.getID(), sqm);
                    ids++;


                } else if (op == 8) {
                    int r = 3;
                    int c = 3;
                    double[][] matrix = {{1, 0, 0}, {4, 2, 0}, {6, 5, 1}};
                    SquareMatrix sqm = new SquareMatrix(r, matrix);
                    sqm.getLabels().add("Lower Triangular Matrix");
                    sqm.setId(Integer.toString(ids));
                    matrices.put(sqm.getID(), sqm);
                    ids++;

                } else if (op == 9) {
                    int r = 2;
                    int c = 2;
                    double[][] matrix = {{1, 2}, {1, 2}};
                    SquareMatrix sqm = new SquareMatrix(2, matrix);
                    //sqm.getLabels().add("Lower Triangular Matrix");
                    sqm.setId(Integer.toString(ids));
                    matrices.put(sqm.getID(), sqm);
                    ids++;
                } else if (op == 10) {
                    int r = 3;
                    int c = 3;
                    double[][] matrix = {{1, 0, 0}, {0, 2, 0}, {0, 0, 3}};
                    DiagonalMatrix dm = new DiagonalMatrix(r, matrix);
                    dm.setId(Integer.toString(ids));
                    matrices.put(dm.getID(), dm);
                    ids++;

                } else if (op == 11) {
                    int r = 3;
                    int c = 3;
                    double[][] matrix = {{2, 0, 0}, {0, 2, 0}, {0, 0, 2}};
                    ScalarMatrix scm = new ScalarMatrix(r, matrix);
                    scm.setId(Integer.toString(ids));
                    matrices.put(scm.getID(), scm);
                    ids++;

                } else if (op == 12) {
                    int r = 3;
                    int c = 3;
                    double[][] matrix = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
                    IdentityMatrix idm = new IdentityMatrix(r, matrix);
                    idm.setId(Integer.toString(ids));
                    matrices.put(idm.getID(), idm);
                    ids++;
                } else if (op == 13) {
                    int r = 1;
                    int c = 1;
                    double[][] matrix = {{5}};
                    SingletonMatrix sgm = new SingletonMatrix(matrix);
                    sgm.setId(Integer.toString(ids));
                    matrices.put(sgm.getID(), sgm);
                    ids++;
                } else if (op == 14) {
                    int r = 2;
                    int c = 2;
                    double[][] matrix = {{1, 1}, {1, 1}};
                    OnesMatrix om = new OnesMatrix(r, c, matrix);
                    om.setId(Integer.toString(ids));
                    matrices.put(om.getID(), om);
                    ids++;
                } else if (op == 15) {
                    int r = 2;
                    int c = 2;
                    double[][] matrix = new double[r][c];
                    NullMatrix nm = new NullMatrix(r, c);
                    nm.setId(Integer.toString(ids));
                    matrices.put(nm.getID(), nm);
                    ids++;
                }
            }else if(ip1==3){
                System.out.println("Choose matrix from");
                for (String i : matrices.keySet()) {
                    System.out.println();
                    System.out.print(i + " ");


                }
                String ip2 = sc.next();
                Matrix mat1 = matrices.get(ip2);
                System.out.println("Enter Matrix of same dimensions");
                double[][] matrix=new double[mat1.getRows()][mat1.getColumns()];
                int r=mat1.getRows();
                int c=mat1.getColumns();
                boolean zeroFlag = true;
                boolean onesFlag = true;

                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        matrix[i][j] = sc.nextDouble();
                        if (matrix[i][j] != 0) {
                            zeroFlag = false;
                        }
                        if (matrix[i][j] != 1) {
                            onesFlag = false;
                        }

                    }
                }
                if (zeroFlag == true) {
                    NullMatrix nm = new NullMatrix(r, c);
                    nm.setId(Integer.toString(ids));
                    matrices.put(nm.getID(), nm);
                    if(r==c){
                        nm.getLabels().add("Singular Matrix");
                    }
                    ids++;
                } else if (c == 1 && r != c) {
                    ColumnMatrix cm = new ColumnMatrix(r, matrix);
                    cm.setId(Integer.toString(ids));
                    matrices.put(cm.getID(), cm);
                    ids++;
                } else if (r == 1 && r != c) {
                    RowMatrix rm = new RowMatrix(c, matrix);
                    rm.setId(Integer.toString(ids));
                    matrices.put(rm.getID(), rm);
                    ids++;
                } else if (onesFlag == true) {
                    OnesMatrix om = new OnesMatrix(r, c, matrix);
                    om.setId(Integer.toString(ids));
                    matrices.put(om.getID(), om);
                    ids++;
                } else if (r != c) {
                    RectangularMatrix rectMatrix = new RectangularMatrix(r, c, matrix);
                    rectMatrix.setId(Integer.toString(ids));
                    matrices.put(rectMatrix.getID(), rectMatrix);
                    ids++;
                } else if (r == c) {
                    boolean symmetricFlag = true;
                    boolean SkewSymmetricFlag = true;
                    boolean identityFlag = true;
                    boolean diagonalFlag = true;
                    double scalar = matrix[0][0];
                    boolean scalarFlag = true;
                    boolean uppertriFlag = true;
                    boolean lowertriFlag = true;
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            if (matrix[i][j] != matrix[j][i]) {
                                symmetricFlag = false;
                            }
                            if (matrix[i][j] != -1 * matrix[j][i] || (i == j && matrix[i][j] != 0)) {
                                SkewSymmetricFlag = false;
                            }
                            if (!((matrix[i][j] == matrix[j][i] && matrix[i][j] == 0) || (i == j && matrix[i][j] == 1))) {
                                identityFlag = false;
                            }
                            if (!(matrix[i][j] == matrix[j][i] || (i!=j && matrix[i][j] == 0))) {
                                diagonalFlag = false;
                            }
                            if (!(diagonalFlag || (i==j && matrix[i][j] == scalar))) {
                                scalarFlag = false;
                            }

                        }
                        //super.AddALl
                    }
                    if (r > 1 && c > 1) {
                        for (int i = 1; i < r; i++) {
                            for (int j = 0; j < i; j++) {
                                if (matrix[i][j] != 0) {
                                    uppertriFlag = false;
                                }
                            }
                        }
                        for (int i = 0; i < r; i++) {
                            for (int j = i + 1; j < c; j++) {
                                if (matrix[i][j] != 0) {
                                    lowertriFlag = false;
                                }
                            }
                        }

                    }

                    if (r == 1) {

                        SingletonMatrix sgm = new SingletonMatrix(matrix);
                        sgm.setId(Integer.toString(ids));
                        matrices.put(sgm.getID(), sgm);
                        if(matrix[0][0]==0){
                            sgm.getLabels().add("Singular Matrix");
                        }
                        ids++;
                    } else if (identityFlag == true) {
                        IdentityMatrix idm = new IdentityMatrix(r, matrix);
                        idm.setId(Integer.toString(ids));
                        matrices.put(idm.getID(), idm);
                        ids++;
                    } else if (scalarFlag == true) {
                        ScalarMatrix scm = new ScalarMatrix(r, matrix);
                        scm.setId(Integer.toString(ids));
                        matrices.put(scm.getID(), scm);

                        ids++;
                    } else if (diagonalFlag == true) {
                        DiagonalMatrix dm = new DiagonalMatrix(r, matrix);
                        dm.setId(Integer.toString(ids));
                        matrices.put(dm.getID(), dm);
                        ids++;
                    } else if (symmetricFlag == true) {
                        SymmetricMatrix sm = new SymmetricMatrix(r, matrix);
                        sm.setId(Integer.toString(ids));
                        matrices.put(sm.getID(), sm);
                        ids++;
                    } else if (SkewSymmetricFlag == true) {
                        SkewSymmetricMatrix skm = new SkewSymmetricMatrix(r, matrix);
                        skm.setId(Integer.toString(ids));
                        matrices.put(skm.getID(), skm);
                        ids++;
                    } else if (uppertriFlag == true) {
                        SquareMatrix sqm = new SquareMatrix(r, matrix);
                        sqm.getLabels().add("Upper Triangular Matrix");
                        sqm.setId(Integer.toString(ids));
                        matrices.put(sqm.getID(), sqm);
                        ids++;
                    } else if (lowertriFlag == true) {
                        SquareMatrix sqm = new SquareMatrix(r, matrix);
                        sqm.getLabels().add("Lower Triangular Matrix");
                        sqm.setId(Integer.toString(ids));
                        matrices.put(sqm.getID(), sqm);
                        ids++;
                    } else {
                        SquareMatrix sqm = new SquareMatrix(r, matrix);
                        //sqm.getLabels().add("Lower Triangular Matrix");
                        sqm.setId(Integer.toString(ids));
                        matrices.put(sqm.getID(), sqm);
                        ids++;
                        //System.out.println("In sqm");
                    }
                }
                ids--;
                if(!(matrices.get(Integer.toString(ids)).getLabels().containsAll(mat1.getLabels()))){
                    matrices.remove(Integer.toString(ids));
                    System.out.println("Cannot edit as matrix-type has been changed");

                }else{
                    matrices.put(mat1.getID(),matrices.get(Integer.toString(ids)));
                    matrices.remove(Integer.toString(ids));

                }
                //ids++;
            }
//        int [][]mat=new int[3][3];
//        for(int i=0;i<3;i++){
//            mat[i][i]=i+1;
//        }
//        int [][]mat2=new int[3][3];
//        for(int i=0;i<3;i++){
//            mat2[i][i]=i+2;
//        }
//        Matrix m=new Matrix(3,3,mat2);
//        DiagonalMatrix dm=new DiagonalMatrix(3,mat);
//        dm.display();
//        Matrix newMat=dm.addMatrices(m);
//        newMat.display();
//        m.display();
//        System.out.println(newMat.getMatrix()[0][0]);
//        System.out.println(dm.det());
//        System.out.println(dm.rowWiseMean());

        }
    }
}
