public class Sword26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recv(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean recv(TreeNode a, TreeNode b) {
        if (b == null)
            return true;

        if (a == null || a.val != b.val)
            return false;

        return recv(a.left, b.left) && recv(a.right, b.right);
    }

    public static void main(String[] args) {

    }
}
