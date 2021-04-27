public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return generateTree(nums, 0, nums.length - 1);
    }

    private TreeNode generateTree(int[] nums, int left, int right) {
        int middle = (left + right) / 2;
        if (left > right)
            return null;
        TreeNode node = new TreeNode();
        node.val = nums[middle];
        node.left = generateTree(nums, left, middle - 1);
        node.right = generateTree(nums, middle + 1, right);
        return node;
    }

    public static void main(String[] args) {

    }
}
