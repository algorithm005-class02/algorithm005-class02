class LRUCache {

    private HashMap<Integer, Node> map;

    private DoubleList cache;

    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cache = new DoubleList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        }

        int val = this.map.get(key).val;
        this.put(key, val);

        return val;
    }

    public void put(int key, int value) {
        Node n = new Node(key, value);

        if (this.map.containsKey(key)) {
            this.cache.remove(this.map.get(key));
        } else {
            if (this.cache.size() == this.capacity) {
                Node last = this.cache.removeLast();
                this.map.remove(last.key);
            }
        }

        this.cache.addFirst(n);
        this.map.put(key, n);
    }

}

class Node {
    public int key, val;
    public Node prev, next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoubleList {

    private Node head, tail;

    private int size;

    public DoubleList() {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        this.head.next = this.tail;
        this.tail.prev = this.head;

        this.size = 0;
    }

    public void addFirst(Node n) {
        n.next = this.head.next;
        n.prev = this.head;

        this.head.next.prev = n;
        this.head.next = n;

        this.size++;
    }

    public void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;

        this.size--;
    }

    public Node removeLast() {
        if (this.head == this.tail.prev) {
            return null;
        }

        Node last = this.tail.prev;
        this.remove(last);

        return last;
    }

    public int size() {
        return this.size;
    }

}