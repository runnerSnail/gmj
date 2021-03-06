// 29. 两数相除
// 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

// 返回被除数 dividend 除以除数 divisor 得到的商。

// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

// 示例 1:

// 输入: dividend = 10, divisor = 3
// 输出: 3
// 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
// 示例 2:

// 输入: dividend = 7, divisor = -3
// 输出: -2
// 解释: 7/-3 = truncate(-2.33333..) = -2

// 提示：

// 被除数和除数均为 32 位有符号整数。
// 除数不为 0。
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。

// 10 - 3 7 7-3 4 4-3 1
class Solution29 {
    public int divideSad(int dividend, int divisor) {
        boolean negative = (dividend >= 0 && divisor < 0) || (dividend <= 0 && divisor > 0);
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            result++;
        }
        return negative ? -result : result;
    }

    public int divide(int dividend, int divisor) {

        if (divisor == 0)
            return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long dividendAbs = Math.abs((long)dividend);
        long divisorAbs = Math.abs((long)divisor);
        boolean negative = (dividend ^ divisor) < 0;
        long result = 0;
        for (int i = 31; i >=0; i--) {
            if ((dividendAbs>>i) >= divisorAbs) {
                result += (long)1 << i;
                dividendAbs -= ((long)1 << i)*divisorAbs;
            }
        }

        return (int)(negative?-result:result);
    }

    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        // System.out.println(solution29.divide(10, 3));
        // System.out.println(solution29.divide(10, -3));
        // System.out.println(solution29.divide(7, -3));
        // System.out.println(solution29.divide(1, 1));
        // System.out.println(solution29.divide(6, 2));
        System.out.println(solution29.divide(-2147483648, 1));
    }
}