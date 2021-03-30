public class Solution41 {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while(nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[nums[i]-1]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if((i+1)!=nums[i])return i+1;
        }
        return nums.length + 1;
    }
    
    public static void main(String[] args) {
        Solution41 solution41 = new Solution41();
        int[] nums = {1, 2, 3, 4};
        System.out.println(solution41.firstMissingPositive(nums));
    }    
}
