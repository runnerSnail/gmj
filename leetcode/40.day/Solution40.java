import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < candidates.length - 1; i++) {
            for (int j = 0; j < candidates.length - 1; j++) {
                int temp = candidates[j];
                if (candidates[j] > candidates[j + 1]) {
                    candidates[j] = candidates[j + 1];
                    candidates[j + 1] = temp;
                }
            }
        }
        // System.out.println(Arrays.toString(candidates));
        backTrace(candidates, target, 0, list, new ArrayList<>());
        return list;
    }

    public void backTrace(int[] candidates, int target, int start, List<List<Integer>> list,
            ArrayList<Integer> selected) {
        // end condition
        if (target < 0)
            return;
        if (target == 0) {
            list.add((ArrayList) selected.clone());
            return;
        }
        // choice route
        for (int i = start; i < candidates.length; i++) {
            if(i>start && candidates[i-1]==candidates[i]){
                continue;
            }
            selected.add(candidates[i]);
            backTrace(candidates, target - candidates[i], i + 1, list, selected);
            // backTrace
            selected.remove(selected.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        // [
        // [1, 7],
        // [1, 2, 5],
        // [2, 6],
        // [1, 1, 6]
        // ]
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        System.out.println(solution40.combinationSum2(candidates, 8).toString());
    }
}
