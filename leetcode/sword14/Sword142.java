public class Sword142 {
    
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i < n; i++) {
            int curSum = 0;
            for (int j = 1; j < 2; j++) {
                curSum = Math.max(j*(i-j), dp[j]*(i-j));
            }
            dp[i] = curSum % 1000000007;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        
    }
}
