public class Solution129 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, "");
        return sum;
    }

    private void dfs(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            System.out.println(path + root.val);
            sum = Integer.parseInt(path + root.val) + sum;
            return;
        }
        if (root.left != null) {
            dfs(root.left, path + root.val);
        }
        if (root.right != null) {
            dfs(root.right, path + root.val);
        }
    }

    public static void main(String[] args) {
        Solution129 solution129 = new Solution129();

    }
}
