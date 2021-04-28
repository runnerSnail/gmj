import java.util.ArrayList;
import java.util.List;

public class Solution114 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preDFS(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    private void preDFS(TreeNode root, List<TreeNode> list) {
        list.add(root);
        if (root.left != null) {
            preDFS(root.left, list);
        }
        if (root.right != null) {
            preDFS(root.right, list);
        }
    }

    public static void main(String[] args) {
        System.out.println(5/2);
    }
}
