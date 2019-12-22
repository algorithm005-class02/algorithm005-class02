class MyCircularDeque {
    int size = 0;
    int maxSize = 0;
    Node head = null;
    Node tail = null;
    
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        maxSize = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == maxSize) {
            return false;
        }
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            head.pre = node;
            node.next = head;
            head = node;
        }
    
        if (tail == null) {
            tail = node;
        }
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == maxSize) {
            return false;
        }
        Node node = new Node(value);
        if (tail == null) {
            tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        if (head == null) {
            head = node;
        }
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size < 1) {
            return false;
        }
        size--;
        if (size == 0) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.pre = null;
        }
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size < 1) {
            return false;
        }
        size--;
        if (size == 0) {
            head = null;
            tail = null;
        } else {
            tail = tail.pre;
            tail.next = null;
        }
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return head.value;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return tail.value;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == maxSize;
    }
    
    class Node {
        public int value;
        public Node pre;
        public Node next;
        
        public Node(int value) {
            this.value = value;
            pre = null;
            next = null;
        }
    }
}