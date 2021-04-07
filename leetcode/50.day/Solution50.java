public class Solution50 {

    public double myPow(double x, int n) {
        return n >= 0 ? muliti(x, n) : 1.0 / muliti(x, -n);
    }

    public double muliti(double x, int n) {
        if (n == 0)
            return 1.0;
        double y = muliti(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {

    }
}
