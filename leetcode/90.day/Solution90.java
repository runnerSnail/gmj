import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        backTrace(0, nums, res, new LinkedList<Integer>());
        return res;
    }

    // 1 2 2
    private void backTrace(int i, int[] nums, List<List<Integer>> res, Deque<Integer> already) {
        for (int j = i; j < nums.length; j++) {
            int idx = Arrays.binarySearch(nums, nums[j]);
            if(idx>=0 && idx<j && !already.contains(nums[j])){
                continue;
            }
            already.addLast(nums[j]);
            res.add(new ArrayList<>(already));
            backTrace(j + 1, nums, res, already);
            already.remove(nums[j]);
        }
    }

    public static void main(String[] args) {
        Solution90 solution90 = new Solution90();
        System.out.println(solution90.subsetsWithDup(new int[] { 1, 2, 2 }).toString());
    }
}
