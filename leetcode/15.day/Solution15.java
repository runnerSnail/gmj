/**
 * Solution15
 */
public class Solution15 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        String start = strs[0];
        String result = "";
        for (int i = 0; i < start.length(); i++) {
            result += start.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(result)) {
                    return result.substring(0, i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        String[] data1 = { "flower", "flow", "flight" };
        String[] data2 = { "dog", "racecar", "car" };
        String[] data3 = { "ab", "a" };
        System.out.println("ab".substring(0,1));
        System.out.println(solution15.longestCommonPrefix(data1));
        System.out.println(solution15.longestCommonPrefix(data2));
        System.out.println(solution15.longestCommonPrefix(data3));
    }
}