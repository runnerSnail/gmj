import java.util.ArrayList;
import java.util.HashMap;

public class Solution133 {
    HashMap<Node, Node> hashMap = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return node;
        }

        if (hashMap.containsKey(node)) {
            return hashMap.get(node);
        }

        Node curNode = new Node(node.val, new ArrayList<>());

        hashMap.put(node, curNode);

        for (Node neighbor : node.neighbors) {
            curNode.neighbors.add(cloneGraph(neighbor));
        }
        return curNode;
    }

    public static void main(String[] args) {
        // Solution133 solution133 = new Solution133();
        // System.out.println();
    }
}
