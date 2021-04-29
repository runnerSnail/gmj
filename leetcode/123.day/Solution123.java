public class Solution123 {
    // 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

    // 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

    // 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 

    // 示例 1:

    // 输入：prices = [3,3,5,0,0,3,1,4]
    // 输出：6
    // 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
    // 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。

    // 动态规划 第几天买 第几天卖
    // 递推方程
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2 + 1][2];

        for (int k = 0; k < 3; k++) {
            dp[0][k][0] = 0;
            dp[0][k][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < prices.length + 1; i++) {
            for (int k = 2; k > 0; k--) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i-1]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i-1]);
            }
        }
        return dp[prices.length][2][0];
    }
    public static void main(String[] args) {

    }
}
