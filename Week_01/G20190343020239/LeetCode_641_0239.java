class MyCircularDeque {

    private class Node {
        int data;
        Node next;
        Node pre;

        public void setData(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node end;
    private int length;
    private int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        size = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (length == size) {
            return false;
        }
        Node node = new Node();
        node.setData(value);
        if (null == head) {
            head = node;
            end = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }
        length++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (length == size) {
            return false;
        }
        Node node = new Node();
        node.setData(value);
        if (null == end) {
            end = node;
            head = node;
        } else {
            end.next = node;
            node.pre = end;
            end = node;
        }
        length++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (null == head) {
            return false;
        }
        if (null == head.next) {
            head = null;
            end = null;
        } else {
            head = head.next;
            head.pre.next = null;
            head.pre = null;
        }
        length--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (null == end) {
            return false;
        }
        if (null == end.pre) {
            end = null;
            head = null;
        } else {
            end = end.pre;
            end.next.pre = null;
            end.next = null;
        }
        length--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (null == head) {
            return -1;
        }
        return head.data;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (null == end) {
            return -1;
        }
        return end.data;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return 0 == length;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return length == size;
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