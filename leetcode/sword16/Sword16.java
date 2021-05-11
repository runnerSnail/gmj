public class Sword16 {
    
    public double myPow(double x, int n) {
        return n >= 0 ? multiply(x, n) : 1 / multiply(x, -n);
    }

    private double multiply(double x, int n) {
        if (n == 0)
            return 1.0;
        double y = multiply(x, n / 2);
        return n / 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {

    }
}
