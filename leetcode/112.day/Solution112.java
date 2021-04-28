public class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 递归终止条件
        if (root == null)
            return false;
        if(root.left==null && root.right==null){
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
    }
    public static void main(String[] args) {
        Solution112 solution112 = new Solution112();
        System.out.println(solution112.hasPathSum(new TreeNode(1, new TreeNode(2),null), 1));
    }
}
