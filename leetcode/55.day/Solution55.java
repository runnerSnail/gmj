public class Solution55 {
    public boolean canJump(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, nums[i] + i);
                if (rightMost >= nums.length-1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        System.out.println(solution55.canJump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(solution55.canJump(new int[] { 3, 2, 1, 0, 4 }));
    }
}
