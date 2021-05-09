import java.util.HashMap;

public class Solution138 {
    HashMap<Node, Node> hashMap = new HashMap<>();

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        if (hashMap.containsKey(head)) {
            return hashMap.get(head);
        }

        Node node = new Node(head.val, null, null);
        hashMap.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        
        return node;
    }

    public static void main(String[] args) {

    }
}
