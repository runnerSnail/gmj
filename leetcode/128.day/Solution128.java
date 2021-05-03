import java.util.HashSet;
import java.util.Set;

public class Solution128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longStack = 0;
        for (int num : num_set) {
            if(!num_set.contains(num-1)){
                int currentNum = num;
                int currenSreak = 1;
                while(num_set.contains(currentNum+1)){
                    currentNum+=1;
                    currenSreak+=1;
                }
                longStack = Math.max(longStack, currenSreak);
            }
        }

        return longStack;

    }

    public static void main(String[] args) {
        
    }
}
