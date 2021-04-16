public class Solution72 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i < word1.length()+1; i++) {
            dp[i][0] = 1 + dp[i - 1][0];
        }
        for (int j = 1; j < word2.length()+1; j++) {
            dp[0][j] = 1 + dp[0][j - 1];
        }
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        Solution72 solution72 = new Solution72();
        System.out.println(solution72.minDistance("", "a"));
    }
}
