import java.util.Arrays;

public class Sword17 {

    public int[] printNumbers(int n) {
        int len = (int) Math.pow(10, n) - 1;
        int[] ret = new int[len];
        for (int i = 1; i <= len; i++) {
            ret[i-1] = i;
        }
        return ret;
    }

    public static void main(String[] args) {
        Sword17 sword17 = new Sword17();
        System.out.println(Arrays.toString(sword17.printNumbers(1)));
    }
}
