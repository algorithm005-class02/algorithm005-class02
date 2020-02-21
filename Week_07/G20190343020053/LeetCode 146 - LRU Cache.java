class LRUCache {
    private int count;
    private int capacity;
    private Map<Integer, LRUNode> route;
    private LRUNode head;
    private LRUNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.route = new HashMap<>();
        this.head = new LRUNode();
        this.tail = new LRUNode();
        head.next = tail;
        head.pre = tail;
        tail.pre = head;
        tail.next = head;
        count = 0;
    }
    
    public int get(int key) {
        if (!route.containsKey(key)) {
            return -1;
        }
        LRUNode res = route.get(key);
        removeItem(res);
        insert(res);
        return res.value;
    }
    
    public void put(int key, int value) {
        if (route.containsKey(key)) {
            removeItem(route.get(key));
        }
        if (count == capacity) {
            route.remove(tail.pre.key);
            removeItem(tail.pre);
        }
        LRUNode cur = new LRUNode();
        cur.key = key;
        cur.value = value;
        insert(cur);
        route.put(key, cur);
    }
    
    private void insert(LRUNode item) {
        item.next = head.next;
        head.next.pre = item;
        item.pre = head;
        head.next = item;
        count++;
    }
    
    private void removeItem(LRUNode item) {
        LRUNode pre = item.pre;
        LRUNode next = item.next;
        pre.next = next;
        next.pre = pre;
        count--;
    }
    
    private class LRUNode {
        public int key;
        public int value;
        public LRUNode next = null;
        public LRUNode pre = null;
        
        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (this == o) {
                return true;
            }
            if (!(o instanceof LRUNode)) {
                return false;
            }
            LRUNode obj = (LRUNode) o;
            return (obj.key == this.key) && (obj.value == this.value);
        }
        @Override
        public int hashCode() {
            return Objects.hash(this.key, this.value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */