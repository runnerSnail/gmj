import java.util.HashMap;

class LRUCache {
    class DLinkedNode {
        int key;
        int val;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {

        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            val = _value;
        }
    }

    private HashMap<Integer, DLinkedNode> hashMap = new HashMap<>();
    DLinkedNode head, tail;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = hashMap.get(key);
        if(node!=null){
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLinkedNode node = hashMap.get(key);
        if (node != null) {
            hashMap.get(key).val = value;
            moveToHead(node);
        } else {
            DLinkedNode current = new DLinkedNode(key, value);
            hashMap.put(key, current);
            addHead(current);
            ++size;
            if (size > capacity) {
                DLinkedNode res = removeTail();
                hashMap.remove(res.key);
                size--;
            }
        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addHead(node);
    }

    private void addHead(LRUCache.DLinkedNode node) {
        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
    }

    private void removeNode(LRUCache.DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {

    }
}