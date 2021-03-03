public class Solution10 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int ans = 0;
        int rest = x;
        while (rest != 0) {
            int remainder = rest % 10;
            ans = ans * 10 + remainder;
            rest = rest / 10;
        }
        return x==ans;
    }

    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        System.out.println(solution10.isPalindrome(121));
    }
}
