import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 输入：nums = [1,2,3]
// 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        backTrace(0, nums, res, new LinkedList<Integer>());
        return res;
    }

    public void backTrace(int start, int[] nums, List<List<Integer>> res, Deque<Integer> already) {

        for (int i = start; i < nums.length; i++) {
            already.addLast(nums[i]);
            res.add(new ArrayList<>(already));
            backTrace(i+1, nums, res, already);
            already.remove(nums[i]);
        }

    }

    public static void main(String[] args) {

    }
}
