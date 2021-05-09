import java.util.List;

// 输入: s = "leetcode", wordDict = ["leet", "code"]
// 输出: true leetcode leet code 0-i j-i 0-j
// 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet"

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {

    }
}
