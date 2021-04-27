import java.util.HashMap;

// 中序遍历 inorder = [9,3,15,20,7]
// 后序遍历 postorder = [9,15,7,20,3]
public class Solution106 {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inorderLen = inorder.length;
        int postoerderLen = postorder.length;
        if (inorderLen == 0 && postoerderLen == 0) {
            return null;
        }

        for (int i = 0; i < inorderLen; i++) {
            hashMap.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postoerderLen - 1, 0, inorderLen - 1);
    }
    // leftrightp
    // leftpright
    // pIndex - inorderLeft = x - postorderLeft
    private TreeNode buildTree(int[] postorder, int postorderLeft, int postorderRight, int inorderLeft,
            int inorderRight) {
        if(postorderLeft>postorderRight){
            return null;
        }
        TreeNode currentNode = new TreeNode();
        int pIndex = hashMap.get(postorder[postorderRight]);
        currentNode.val = postorder[postorderRight];
        currentNode.left = buildTree(postorder,postorderLeft,pIndex-inorderLeft+postorderLeft-1,inorderLeft,pIndex-1);
        currentNode.right = buildTree(postorder,pIndex-inorderLeft+postorderLeft,postorderRight-1,pIndex+1,inorderRight);
        return currentNode;
    }

    public static void main(String[] args) {

    }
}
