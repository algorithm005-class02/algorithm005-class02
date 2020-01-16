class DoubleListNode {
    public int val;
    public DoubleListNode pre;
    public DoubleListNode next;
}

public class MyCircularDeque {
    private DoubleListNode head = null;
    private DoubleListNode tail = null;
    private Integer maxSize = 0;
    private Integer size = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        if (k >= 0) {
            this.maxSize = k;
            this.size = 0;
        }
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (head == null) {
            head = new DoubleListNode();
            head.val = value;
            if (tail == null) tail = head;
        } else {
            head.pre = new DoubleListNode();
            head.pre.val = value;
            head.pre.next = head;
            head = head.pre;
        }
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (tail == null) {
            tail = new DoubleListNode();
            tail.val = value;
            if (head == null) head = tail;
        } else {
            tail.next = new DoubleListNode();
            tail.next.val = value;
            tail.next.pre = tail;
            tail = tail.next;
        }
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (head == null) {
            return false;
        }
        head = head.next;
        
        if (head == null) {
            tail = null;
        } else {
            head.pre = null;
        }
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (tail == null) {
            return false;
        }
        tail = tail.pre;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (head == null) return -1;  
        return head.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (tail == null) return -1;
        return tail.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size==0 ? true : false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size>=maxSize ? true : false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */