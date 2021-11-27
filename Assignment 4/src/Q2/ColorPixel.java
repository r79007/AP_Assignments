package Q2;

public class ColorPixel {
    private double r;
    private double g;
    private double b;

    public double getR() {
        return this.r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getG() {
        return this.g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getB() {
        return this.b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public ColorPixel(double r, double g, double b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
}
