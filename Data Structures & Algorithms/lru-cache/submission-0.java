class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;

    // Dummy head and tail
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        insertAtFront(node); // move the node to MRU

        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            remove(node);
            insertAtFront(node);

            return;
        }

        // remove the tail node first if the capacity is reached
        if (map.size() == capacity) {
            Node lru = tail.prev;
            
            remove(lru);
            map.remove(lru.key);
        }

        Node mru = new Node(key, value);

        // Insert the new node as the MRU at top
        insertAtFront(mru);
        map.put(key, mru);
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;    
    }

    private void insertAtFront(Node node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }
}
