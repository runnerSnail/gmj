public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        Solution104 solution104 = new Solution104();
        System.out.println(solution104.maxDepth(new TreeNode(1,new TreeNode(2),new TreeNode(4,new TreeNode(3),null))));
    }
}
