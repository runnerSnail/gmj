// 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

// 示例 1:

// 输入: 123
// 输出: 321
//  示例 2:

// 输入: -123
// 输出: -321
// 示例 3:

// 输入: 120
// 输出: 21
class Solution8 {
    public int reverse(int x) {
        Long result = 0l;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return  Integer.parseInt(String.valueOf(result));
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        System.out.println(solution8.reverse(123));
        System.out.println(solution8.reverse(-123));
        System.out.println(solution8.reverse(120));
    }
}