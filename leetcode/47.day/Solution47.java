import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];

        backtrack(nums, output, result, 0, used);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> output, List<List<Integer>> result, int first, boolean[] used) {

        if (first == nums.length) {
            result.add(new ArrayList<Integer>(output));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            output.add(nums[i]);
            used[i] = true;
            backtrack(nums, output, result, first + 1, used);
            used[i] = false;
            output.remove(output.size() - 1);
        }

    }

    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        int[] nums = { 0, 0, 1 };
        List<List<Integer>> result = solution47.permuteUnique(nums);

        for (List<Integer> list : result) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int num : list) {
                stringBuilder.append(num);
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
