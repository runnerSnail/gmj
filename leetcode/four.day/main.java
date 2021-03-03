class Solution4 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 寻找最长子串
        int start = 0;
        int end = 1;
        int max = 1;
        String currentStr = s.substring(0, 1);
        while (end <= s.length()) {
            // System.out.println("开始");
            // System.out.println("start=" + start + "," + "end=" + end);
            // System.out.println(currentStr + ",currentStr");
            max = end - start > max ? end - start : max;
            if(end==s.length()) return max;
            char endChar = s.charAt(end);
            int charSite = currentStr.indexOf(endChar);
            if (charSite > -1) {
                start = charSite + 1 + start;
            }
            // System.out.println("endChar=" + endChar + ",charSite=" + charSite);
            end++;
            currentStr = s.substring(start, end);
            // System.out.println("结束");
        }
        return max;
    }

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        int result = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
        int result1 = solution.lengthOfLongestSubstring("bbbbb");
        System.out.println(result1);
        int result2 = solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(result2);
        int result3 = solution.lengthOfLongestSubstring("");
        System.out.println(result3);
        int result4 = solution.lengthOfLongestSubstring("dvdf");
        System.out.println(result4);
    }
}