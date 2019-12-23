class MyCircularDeque {
    
    private static class MyCircularDequeNode{
        int val;
        MyCircularDequeNode prev;
        MyCircularDequeNode next;
        public MyCircularDequeNode(int val) {
            this.val = val;
        }
    }
    
    private MyCircularDequeNode head;
    private MyCircularDequeNode tail;
    private int size;
    private int volume = 0;
    
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        size = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (volume<size){
            if (this.head==null){
                this.head = new MyCircularDequeNode(value);
                this.tail =  this.head;
            }else {
                MyCircularDequeNode temp = this.head;
                this.head.prev = new MyCircularDequeNode(value);
                this.head = this.head.prev;
                this.head.next = temp;
            }
            volume++;
            return true;
        }else {
            return false;
        }
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (volume<size){
            if (this.tail==null){
                this.tail = new MyCircularDequeNode(value);
                this.head = this.tail;
            }else {
                MyCircularDequeNode temp = this.tail;
                this.tail.next = new MyCircularDequeNode(value);
                this.tail = this.tail.next;
                this.tail.prev = temp;
            }
            volume++;
            return true;
        }else {
            return false;
        }
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (this.head==null){
            return false;
        }else {
            MyCircularDequeNode temp = this.head.next;
            if (temp != null){
                this.head = temp;
                this.head.prev = null;
            }else {
                this.tail = null;
                this.head = null;
            }
            volume--;
            return true;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (this.tail==null){
            return false;
        }else {
            MyCircularDequeNode temp = this.tail.prev;
            if (temp != null){
                this.tail = temp;
                this.tail.next = null;
            }else {
                this.tail = null;
                this.head = null;
            }
            volume--;
            return true;
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (this.volume>0){
            return this.head.val;
        }else {
            return -1;
        }
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (this.volume>0){
            return this.tail.val;
        }else {
            return -1;
        }
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.volume == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.volume == size;
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
