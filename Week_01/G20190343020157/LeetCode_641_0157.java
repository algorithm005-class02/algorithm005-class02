class MyCircularDeque {

    //执行用时7ms，内存消耗 38.8MB

    private int capacity; //最大容量，由构造函数设置
    private int size;  //当前容量大小
    private Node first;  //头指针
    private Node tail;  //尾指针

    private static class Node{
        int value;
        Node prev;
        Node next;
    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
        first = new Node();
        tail = new Node();
        first.next = tail;
        tail.prev = first;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(size >= capacity) return false;
        Node newNode = new Node();
        newNode.value = value;
        newNode.prev = first;
        newNode.next = first.next;
        first.next = newNode;
        newNode.next.prev = newNode;
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size >= capacity) return false;
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev = newNode;
        newNode.prev.next = newNode;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size == 0)return false;
        Node target = first.next;
        first.next = target.next;
        target.next.prev = first;
        target.prev = null;
        target.next = null;
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size == 0)return false;
        Node target = tail.prev;
        target.prev.next = tail;
        tail.prev = target.prev;
        target.prev = null;
        target.next = null;
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(size == 0)return -1;
        Node target = first.next;
        return target.value;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(size == 0)return -1;
        Node target = tail.prev;
        return target.value;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if (size == capacity)return true;
        else return false;
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