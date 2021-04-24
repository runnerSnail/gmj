import java.util.ArrayList;
import java.util.List;

public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> listNode = new ArrayList<>();
        if (n < 1)
            return listNode;
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> listNode = new ArrayList<>();

        if (start > end) {
            listNode.add(null);
            return listNode;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = dfs(start, i - 1);
            List<TreeNode> rightNodes = dfs(i + 1, end);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode root = new TreeNode();
                    root.val = i;
                    root.left = leftNode;
                    root.right = rightNode;
                    listNode.add(root);
                }
            }
        }

        return listNode;
    }

    public static void main(String[] args) {

    }
}
