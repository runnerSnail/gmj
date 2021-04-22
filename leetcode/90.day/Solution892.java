import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution892 {
    List<Integer> cur = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return res;
    }

    private void dfs(boolean choosePre, int i, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        dfs(false, i + 1, nums);
        if (!choosePre && i > 0 && nums[i - 1] == nums[i]) {
            return;
        }
        cur.add(nums[i]);
        dfs(true, i + 1, nums);
        cur.remove(cur.size() - 1);
    }

    public static void main(String[] args) {
        Solution892 solution90 = new Solution892();
        System.out.println(solution90.subsetsWithDup(new int[] { 1, 2, 2 }).toString());
    }
}
