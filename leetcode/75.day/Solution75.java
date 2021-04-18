public class Solution75 {
    public void sortColors(int[] nums) {
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[ptr];
                nums[ptr] = nums[i];
                nums[i] = temp;
                ptr++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[ptr];
                nums[ptr] = nums[i];
                nums[i] = temp;
                ptr++;
            }
        }

    }

    public static void main(String[] args) {

    }
}
