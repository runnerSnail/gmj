import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

//  

// 示例:
// 给定如下二叉树，以及目标和 target = 22，

//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// 返回:

// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]

public class Sword34 {

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        LinkedList<Integer> path = new LinkedList<>();
        if (root == null)
            return ret;
        dfs(root, target, path);
        return ret;
    }

    private void dfs(TreeNode node, int target, LinkedList<Integer> path) {
        if (node.left == null && node.right == null) {
            // System.out.println("--->"+target);
            if (node.val == target) {
                path.add(node.val);
                ret.add(new ArrayList<>(path));
                path.removeLast();
                return;
            } else {
                return;
            }
        }

        path.add(node.val);

        if (node.left != null) {
            dfs(node.left, target - node.val, path);
        }

        if (node.right != null) {
            dfs(node.right, target - node.val, path);
        }
        path.removeLast();
    }

    public static void main(String[] args) {

    }

}
