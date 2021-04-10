import java.util.Arrays;

public class Solution53 {
    // 1 dp
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] >= 0 ? (dp[i] + dp[i - 1]) : dp[i];
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    // 2. greed
    public int maxSubArrayByGreed(int[] nums) {
        int max = nums[0];
        int preSum = 0;
        for (int i : nums) {
            preSum = Math.max(preSum, preSum+i);
            max = Math.max(max, preSum);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
