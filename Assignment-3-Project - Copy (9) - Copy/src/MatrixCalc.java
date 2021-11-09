public interface MatrixCalc{
    Matrix addMatrices(Matrix matrix);
    Matrix subMatrices(Matrix matrix);
    Matrix mulMatrices(Matrix matrix);
    Matrix divMatrices(Matrix matrix);
    Matrix inverse();
    Matrix transpose();
    double rowWiseMean();
    double colWiseMean();
    double allMean();
    int det();
    Matrix AAT();
    Matrix eigenVectors(Matrix matrix);
    int eigenValues(Matrix matrix);
    void setId(String id);
    String getID();
}
