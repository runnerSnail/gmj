import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backTrace(1, n, k, res, new LinkedList<Integer>());
        return res;
    }

    public void backTrace(int start, int n, int k, List<List<Integer>> res, Deque<Integer> already) {
        if (k == already.size()) {
            res.add(new ArrayList<>(already));
            return;
        }
        for (int i = start; i <= n; i++) {
            already.addLast(i);
            backTrace(i + 1, n, k, res, already);
            already.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        System.out.println(solution77.combine(4, 2).toString());
    }
}
