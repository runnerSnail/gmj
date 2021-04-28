import java.util.List;

// 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
// 输出：11
// 解释：如下面简图所示：
//    2
//   3 4
//  6 5 7
// 4 1 8 3
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.get(0).size() == 0) {
            return 0;
        }
        int rows = triangle.size();
        int[][] dp = new int[rows][rows];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                int cur = triangle.get(i).get(j);
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + cur;
                } else if (i == j) {
                    dp[i][j] = dp[i - 1][j - 1] + cur;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + cur;
                }
            }
        }
        int miniTotal = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            miniTotal = Math.min(dp[rows - 1][i], miniTotal);
        }
        return miniTotal;
    }

    public static void main(String[] args) {

    }
}
