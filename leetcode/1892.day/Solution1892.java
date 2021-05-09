import java.util.HashSet;
import java.util.Set;

class Solution1892 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                repeat = nums[i];
                break;
            }
        }
        return repeat;
    }

    public static void main(String[] args) {

    }
}