import java.util.ArrayList;
import java.util.List;

public class Solution99 {
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorderTree(root, nums);
        int[] swaps = findSwapper(nums);
        recoverTree(root, 2, swaps[0], swaps[1]);
    }

    private void recoverTree(TreeNode node, int count, int x, int y) {
        if (node != null) {
            if (node.val == x || node.val == y) {
                node.val = node.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recoverTree(node.right, count, x, y);
            recoverTree(node.left, count, x, y);
        }
    }

    private int[] findSwapper(List<Integer> nums) {
        int x = -1;
        int y = -1;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                }else{
                    break;
                }
            }
        }
        return new int[] { x, y };
    }

    private void inorderTree(TreeNode node, List<Integer> nums) {
        if (node == null)
            return;
        inorderTree(node.left, nums);
        nums.add(node.val);
        inorderTree(node.right, nums);
    }

    public static void main(String[] args) {

    }
}
