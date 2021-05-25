public class Sword3322 {

    public boolean verifyPostorder(int[] postorder) {
        return recv(0, postorder.length - 1, postorder);
    }

    private boolean recv(int i, int j, int[] postorder) {
        if (i >= j)
            return true;
        int p = i;
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while (postorder[j] < postorder[p]) {
            p++;
        }
        return j == p && recv(i, m - 1, postorder) && recv(m, j - 1, postorder);
    }

    public static void main(String[] args) {
        Sword3322 sword3322 = new Sword3322();

        System.out.println(sword3322.verifyPostorder(new int[] { 1, 6, 3, 2, 5 }));

        System.out.println(sword3322.verifyPostorder(new int[] { 1, 3, 2, 6, 5 }));
    }
}
