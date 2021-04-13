public class Solution65 {
    public int[] plusOne(int[] digits) {
        int last = 0;
        for (int i = digits.length - 1; i >= 0; --i) {
            int num;
            if (i == digits.length - 1) {
                num = digits[i] + 1;
            } else {
                num = digits[i] + last;
            }
            digits[i] = num % 10;
            last = num / 10;
            if (last == 0)
                return digits;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
