public class Solution97 {
    // 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
    // 输出：true
    // no thought to consider state transition equation  
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();

        if (m + n != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0]=true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j]) && s3.charAt(i+j-1) == s1.charAt(i-1);
                }

                if (j > 0) {
                    dp[i][j] = (dp[i][j] || dp[i][j-1]) && s3.charAt(i+j-1) == s2.charAt(j-1);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

    }
}
