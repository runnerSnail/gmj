public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int slow = 2;
        int fast = 2;
        if(nums.length<=2) return nums.length;
        while(fast<nums.length){
            if(nums[slow-2]!=nums[fast]){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
    public static void main(String[] args) {
        
    }
}
