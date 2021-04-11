import java.util.ArrayList;
import java.util.List;

public class Solution60 {
    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n + 1];
        StringBuilder path = new StringBuilder();
        backTrace(n, k, used, path, 0, calculateFactorial(n));
        return path.toString();
    }

    public void backTrace(int n, int k, boolean[] used, StringBuilder path, int index, int[] factorial) {
        if (n == index) {
            return;
        }
        int cal = factorial[n - 0 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i])
                continue;
            if (cal < k) {
                k -= cal;
                continue;
            }
            path.append(i);
            used[i]=true;
            backTrace(n, k, used, path, index + 1, factorial);
            return;
        }
    }

    public int[] calculateFactorial(int n) {
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        Solution60 solution60 = new Solution60();
        System.out.println(solution60.getPermutation(3, 3));
    }
}
