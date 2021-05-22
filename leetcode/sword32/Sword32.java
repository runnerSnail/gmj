import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sword32 {
    public int[] levelOrder(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {
            {
                add(root);
            }
        };
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ret.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        
        int[] ans = new int[ret.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ret.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
