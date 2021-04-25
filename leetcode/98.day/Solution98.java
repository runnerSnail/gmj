public class Solution98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    //   3
    // 1   4
    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null)
            return true;
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }


    public static void main(String[] args) {
        System.out.println("1233");
    }
}
