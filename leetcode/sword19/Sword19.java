public class Sword19 {

    // 动态方程
    // 动态转移方程
    // dp[i][j] 不是* dp[i-1][j-1]
    // 是* dp[i-2][j] dp[i][j-1]
    public boolean isMatch(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();
        boolean[][] dp = new boolean[pLen + 1][sLen + 1];
        dp[0][0] = true;

        for (int i = 2; i < dp.length; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 2][0];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (p.charAt(i - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '.');
                } else {
                    if (i >= 2) {
                        dp[i][j] = dp[i - 2][j]
                                || (dp[i][j - 1] && (s.charAt(j - 1) == p.charAt(i - 2) || p.charAt(i - 2) == '.'));
                    }
                }
            }

        }
        return dp[pLen][sLen];
    }

    public static void main(String[] args) {
        Sword19 sword19 = new Sword19();
        System.out.println(sword19.isMatch("mississippi", "mis*is*p*.")); // false
        System.out.println(sword19.isMatch("aab", "c*a*b")); // true
    }
}
