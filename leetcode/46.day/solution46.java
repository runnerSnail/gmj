import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // List<Integer> output = new ArrayList<>();
        Deque<Integer> output = new ArrayDeque<>(nums.length);
        // for (int num : nums) {
        //     output.add(num);
        // }
        boolean[] used = new boolean[nums.length];

        backtrack(nums, output, result, 0,used);
        return result;
    }

    public void backtrack(int[] nums, Deque<Integer> output, List<List<Integer>> result, int first,boolean[] used) {
        
        if(first == nums.length){
            result.add(new ArrayList<Integer>(output));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Collections.swap(output, first, i);
            if(used[i]) continue;
            output.addLast(nums[i]);
            used[i] = true;
            backtrack(nums, output, result, first + 1,used);
            used[i] = false;
            output.removeLast();
        }
    }

    public static void main(String[] args) {
        
        solution46 solution46 = new solution46();
        int[] nums = {1,2,3};
        List<List<Integer>> result = solution46.permute(nums);
        for (List<Integer> list : result) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int num : list) {
                stringBuilder.append(num);
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
