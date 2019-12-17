class MyCircularDeque {
    private int[] deque;
    private int length = 0;
    private int size = 0;
    private boolean isFull = false;
    private boolean isEmpty = true;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        deque = new int[k];
        length = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull)
            return false;
        int[] temp = new int[deque.length];
        temp[0] = value;
        System.arraycopy(deque, 0, temp, 1, size);
        deque = temp.clone();
        size++;
        if (size == length) {
            isFull = true;
        }
        isEmpty = false;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull)
            return false;
        deque[size] = value;
        size++;
        if (size == length) {
            isFull = true;
        }
        isEmpty = false;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty)
            return false;
        System.arraycopy(deque, 1, deque, 0, size - 1);
        size--;
        if (size == 0) {
            isEmpty = true;
        }
        isFull = false;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty)
            return false;
        System.arraycopy(deque, 0, deque, 0, size - 1);
        size--;
        if (size == 0) {
            isEmpty = true;
        }
        isFull = false;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty)
            return -1;
        return deque[0];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty)
            return -1;
        return deque[size - 1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return isEmpty;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return isFull;
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