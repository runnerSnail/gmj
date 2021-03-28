// 输入：nums = [0,1,2,2,3,0,4,2], val = 2
// 输出：5, nums = [0,1,4,0,3]

public class Solution33 {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;
        int middle = Integer.MAX_VALUE;
        while (start<end) {
            middle = (start + end) / 2;
            if(nums[middle]==val) return middle;
            // {5,1,3}
            if (nums[middle]>nums[start]) {
                // + start-middle
                if (val >= nums[start] && val<nums[middle]) {
                    end = middle-1;
                }else{
                    start = middle+1;
                }
            }else{
                // + middle-end
                if(val>=nums[middle+1] && nums[end]>=val){
                    start = middle+1;
                }
                else
                end = middle-1;
            }
        }
        return nums[start] == val?start:-1;
    }
    public static void main(String[] args) {
        // -1
        // 4
        // -1
        // 0
        Solution33 solution33 = new Solution33();
        int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(solution33.removeElement(nums1, 3)==-1);
        int[] nums2 = {4,5,6,7,0,1,2};
        System.out.println(solution33.removeElement(nums2, 0)==4);
        int[] nums3 = {1};
        System.out.println(solution33.removeElement(nums3, 0)==-1);
        int[] nums5 = {1,3};
        System.out.println(solution33.removeElement(nums5, 3)==1);
        int[] nums4 = {5,1,3};
        System.out.println(solution33.removeElement(nums4, 5)==0);
        int[] nums6 = {5,1,3};

        System.out.println(solution33.removeElement(nums6, 3)==2);
    }
}
