import java.util.HashMap;
import java.util.Map;

// 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

// 例如，给出

// 前序遍历 preorder = [3,9,20,15,7]
// 中序遍历 inorder = [9,3,15,20,7]
// 返回如下的二叉树：

//     3
//    / \
//   9  20
//     /  \
//    15   7

public class Sword07 {
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        
        if (pStart > pEnd) {
            return null;
        }

        // oEnd-oIndex = pend - pStart
        int oIndex = indexMap.get(preorder[pStart]);
        TreeNode node = new TreeNode(preorder[pStart]);
        node.left = buildTree(preorder, pStart + 1, oIndex - pStart - iStart, inorder, iStart, oIndex - 1);
        node.right = buildTree(preorder, oIndex - pStart - iStart + 1, pEnd, inorder, oIndex + 1, iEnd);
        return null;
    }

    public static void main(String[] args) {

    }
}
