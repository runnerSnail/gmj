import java.util.HashMap;
import java.util.Map;

public class Solution87 {
    int[][][] memo;
    String s1;
    String s2;

    public boolean isScramble(String s1, String s2) {
        int length = s1.length();
        memo = new int[length][length][length + 1];
        this.s1 = s1;
        this.s2 = s2;
        return dfs(0, 0, length);
    }

    private boolean dfs(int i1, int i2, int k) {
        if (memo[i1][i2][k] != 0)
            return memo[i1][i2][k] == 1;

        if (s1.substring(i1, i1 + k).equals(s2.subSequence(i2, i2 + k))) {
            memo[i1][i2][k] = 1;
            return true;
        }
        if (!checkIfSimilar(i1, i2, k)) {
            memo[i1][i2][k] = -1;
            return false;
        }
        // spl it it spl
        for (int i = 1; i < k; i++) {
            if (dfs(i1, i2, i) && dfs(i1 + i, i2 + i, k - i)) {
                memo[i1][i2][k] = 1;
                return true;
            }
            
            if (dfs(i1, i2 + k - i, i) && dfs(i1 + i, i2, k - i)) {
                memo[i1][i2][k] = 1;
                return true;
            }
        }
        memo[i1][i2][k] = -1;
        return false;
    }

    private boolean checkIfSimilar(int i1, int i2, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = i1; i < i1 + k; i++) {
            char c = s1.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }
        for (int i = i2; i < i2 + k; ++i) {
            char c = s2.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) - 1);
        }

        for (Map.Entry<Character,Integer> truplEntry : freq.entrySet()) {
            if(truplEntry.getValue()!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution87 solution87 = new Solution87();
        System.out.println(solution87.isScramble("abc","acb"));
    }
}