import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution113 {
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        findPathSum(root, targetSum, new LinkedList<>());
        return ret;
    }

    public void findPathSum(TreeNode root, int targetSum, Deque<Integer> paths) {
        if(root==null) return;
        if (root.left == null && root.right == null && targetSum == root.val) {
            paths.addLast(root.val);
            ret.add(new ArrayList<>(paths));
            paths.removeLast();
            return;
        }
        paths.addLast(root.val);
        findPathSum(root.left, targetSum - root.val, paths);
        findPathSum(root.right, targetSum - root.val, paths);
        paths.removeLast();
    }

    public static void main(String[] args) {

    }
}
