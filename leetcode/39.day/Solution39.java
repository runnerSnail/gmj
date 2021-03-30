import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 输入：candidates = [2,3,6,7], target = 7,
// 所求解集为：
// [
//   [7],
//   [2,2,3]
// ]
public class Solution39 {
    public HashSet<String> hashSet = new HashSet();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backTrace(candidates, target, 0, list, new ArrayList<Integer>());
        return list;
    }
    public void backTrace(int[] candidates, int target, int start, List<List<Integer>> list,
            ArrayList<Integer> selectedList) {
        // end condition
        if (target < 0)
            return;

        if (target == 0) {
            list.add((ArrayList<Integer>) selectedList.clone());
            return;
        }

        // choice route
        for (int i = start; i < candidates.length; i++) {
            selectedList.add(candidates[i]);
            backTrace(candidates, target - candidates[i], i, list, selectedList);
            // backTrace
            selectedList.remove(selectedList.size() - 1);
        }
        return;
    }
    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        int[] candidates = { 2, 3, 6, 7 };
        System.out.println(solution39.combinationSum(candidates, 7).toString());
    }
}
