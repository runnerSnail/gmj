public class Solution75 {
    public void sortColors(int[] nums) {
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                int temp = nums[ptr];
                nums[ptr] = temp;
            }
        }
    }

    public static void main(String[] args) {

    }
}
