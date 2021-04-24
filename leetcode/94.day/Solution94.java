import java.util.ArrayList;
import java.util.List;

public class Solution94 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return res;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node.left != null)
            dfs(node.left);
        res.add(node.val);
        if (node.right != null)
            dfs(node.right);
    }

    public static void main(String[] args) {
        Solution94 solution94 = new Solution94();
        System.out.println(solution94.inorderTraversal(null));
    }
}
