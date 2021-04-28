public class Solution115 {

    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[tLen + 1][sLen + 1];
        dp[0][0] = 1;

        for (int j = 1; j < sLen + 1; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < tLen + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < tLen+1; i++) {
            for (int j = 1; j < sLen+1; j++) {
                if (t.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[tLen][sLen];
    }

    public static void main(String[] args) {
        Solution115 solution115 = new Solution115();
        System.out.println(solution115.numDistinct("rabbbit", "rabbit"));
    }
}
