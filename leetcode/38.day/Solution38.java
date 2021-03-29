public class Solution38 {
    // 5
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        if (n > 1) {
            String numberString = countAndSay(n - 1);
            char[] numberChar = numberString.toCharArray();
            String result = "";
            int len = 0;
            int last = 0;
            while (len <= numberChar.length) {
                if (len == numberChar.length || numberChar[len] != numberChar[last]) {
                    result = result + (len - last) + numberChar[last];
                    last = len;
                }
                len++;
            }
            return result;
        }
        return "";
    }

    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        System.out.println(solution38.countAndSay(1));
        System.out.println(solution38.countAndSay(2));
        System.out.println(solution38.countAndSay(3));
    }
}
