public class Solution44 {

    public boolean isMatch1(String s, String p) {
        int pEnd = p.length();
        int sEnd = s.length();
        if (sEnd == 0 || pEnd == 0) {
            if (pEnd == 0 && sEnd == 0)
                return true;

            if (sEnd == 0 && p.charAt(pEnd - 1) == '*') {
                return isMatch1("", p.substring(0, pEnd - 1));
            }
            return false;
        }

        if (p.charAt(pEnd - 1) == '?' || s.charAt(sEnd - 1) == p.charAt(pEnd - 1)) {
            return isMatch1(s.substring(0, sEnd - 1), p.substring(0, pEnd - 1));
        }
        if (p.charAt(pEnd - 1) == '*') {
            return isMatch1(s.substring(0, sEnd - 1), p.substring(0, pEnd))
                    || isMatch1(s.substring(0, sEnd), p.substring(0, pEnd - 1));
        }
        return false;
    }

    public boolean isMatch(String s, String p) {
        if(p.isEmpty() && s.isEmpty()){
            return true;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (i == 0 && j>0) {
                        dp[i][j] = dp[i][j-1] && p.charAt(j - 1) == '*';
                }
                if (j == 0 && i>0) {
                    dp[i][j] = false;
                }
            }
        }
        if(s.length()==0) return dp[0][p.length()];
        if(p.length()==0) return dp[s.length()][0];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j-1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1));
                }
                if(j>i) break;
            }
        }
        return dp[s.length()][p.length()] ;
    }

    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();
        System.out.println(solution44.isMatch("adceb", "*a*b") == true);
        System.out.println(solution44.isMatch("aa", "a") == false);
        System.out.println(solution44.isMatch("aa", "*") == true);
        System.out.println(solution44.isMatch("cb", "?a") == false);
        System.out.println(solution44.isMatch("acdcb", "a*c?b") == false);
        System.out.println(solution44.isMatch("aab", "c*a*b") == false);
        System.out.println(solution44.isMatch("abcabczzzde", "*abc???de*") == true);
        System.out.println(solution44.isMatch("", "") == true);
        System.out.println(solution44.isMatch("", "*") == true);
        System.out.println(solution44.isMatch("a", "") == false);
        System.out.println(solution44.isMatch("c", "*?*") == true);
    }

}
// aa a
// aa *
