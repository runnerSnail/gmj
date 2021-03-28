import java.util.Arrays;

// 输入：nums = [5,7,7,8,8,10], target = 8
// 输出：[3,4]
public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int position = -1;
        int[] restlt = { -1, -1 };

        while (start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                position = middle;
                break;
            }
            if (nums[middle] >= target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        
        if (position != -1) {
            start = position;
            end = position;
            while (start >= 0) {
                if (nums[start] == target)
                    start--;
                else break;
            }

            while (end < nums.length) {
                if (nums[end] == target)
                    end++;
                else break;
            }

            restlt[0] = start + 1;
            restlt[1] = end - 1;
        }

        return restlt;
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        System.out.println(Arrays.toString(solution34.searchRange(nums, 8)));
        int[] nums1 = { 5, 7, 7, 8, 8, 10 };
        System.out.println(Arrays.toString(solution34.searchRange(nums1, 6)));
        int[] nums2 = { };
        System.out.println(Arrays.toString(solution34.searchRange(nums1, 0)));
    }
}
