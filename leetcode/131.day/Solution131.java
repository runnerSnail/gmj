import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution131 {
    List<List<String>> ret = new ArrayList<>();
    boolean[][] dp;
    Deque<String> path = new LinkedList<>();
    char[] charArray;

    public List<List<String>> partition(String s) {
        if (s.length() == 0)
            return ret;
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
        DFS(s, 0);
        return ret;
    }

    private void DFS(String s, int i) {
        if (i == s.length()) {
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < charArray.length; j++) {
            if (dp[i][j]) {
                path.addLast(s.substring(i, j + 1));
                DFS(s, j + 1);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {

    }
}
