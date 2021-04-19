public class Solution81 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[low] == nums[mid]){
                low++;
                continue;
            }
            if (nums[low] < nums[mid]) {
                // 前半部分有序
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }else{
                // 后半部分有序
                if (target >= nums[mid] && target < nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution81 solution81 = new Solution81();
        System.out.println(solution81.search(new int[]{1,0,1,1,1}, 0));
    }
}
