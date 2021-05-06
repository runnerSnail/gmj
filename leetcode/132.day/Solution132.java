import java.util.Arrays;

public class Solution132 {
    boolean[][] dp;
    char[] charArray;

    public int minCut(String s) {
        if (s.length() == 0)
            return 0;
        dp = new boolean[s.length()][s.length()];
        charArray = s.toCharArray();

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    dp[j][i] = true;
                } else if (i - j <= 2) {
                    dp[j][i] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[j][i] = s.charAt(i) == s.charAt(j) && dp[j + 1][i - 1];
                }
            }
        }

        int[] fn = new int[dp.length];
        Arrays.fill(fn, Integer.MAX_VALUE);
        for (int i = 0; i < fn.length; i++) {

            if (dp[0][i]) {
                fn[i] = 0;
            } else {
                fn[i] = fn[i - 1] + 1;
                for (int j = 0; j < i; j++) {
                    if (dp[j+1][i]) {
                        fn[i] = Math.min(fn[i], fn[j]+1);
                    }
                }
            }

        }

        return fn[dp.length - 1];
    }

    public static void main(String[] args) {
        Solution132 solution132 = new Solution132();
        System.out.println(solution132.minCut("cdd"));
    }
}
