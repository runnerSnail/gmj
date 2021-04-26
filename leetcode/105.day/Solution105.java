import java.util.HashMap;
import java.util.Map;

public class Solution105 {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0)
            return new TreeNode();

        int preorderLen = preorder.length;
        int inorderLen = inorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorderLen - 1, 0, inorderLen - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int inorderLeft, int inorderRight) {
        if (preLeft > preRight) {
            return null;
        }
        int pIndex = indexMap.get(preorder[preLeft]);
        TreeNode root = new TreeNode();
        root.val = preorder[preLeft];
        root.left = buildTree(preorder, preLeft+1, pIndex - inorderLeft + preLeft, inorderLeft, pIndex - 1);
        root.right = buildTree(preorder, pIndex - inorderLeft + preLeft + 1, preRight,
               pIndex+1, inorderRight);
        return root;
    }

    public static void main(String[] args) {
        Solution105 solution105 = new Solution105();
        System.out.println(solution105.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
}
