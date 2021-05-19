public class Sword27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.right;
        root.right = mirrorTree(root.left);
        root.left = mirrorTree(temp);
        return root;
    }
}
