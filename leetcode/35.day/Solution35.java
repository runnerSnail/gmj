public class Solution35 {
    // 输入: [1,3,5,6], 5
    // 输出: 2
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        int[] nums1 = {1,3,5,6};
        System.out.println(solution35.searchInsert(nums1, 2)==1);
    }
}
