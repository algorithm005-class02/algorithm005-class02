总结：1.刷题还是应该从最基础的题刷起，因为很多复杂的题的思路都是通过不同的简单题的思路组合才能解的
   2.本期主要的内容属数组，链表，跳表，数组的添加，删除涉及到数组元素的移动，所以时间复杂度为O(n),链表删除和添加时间复杂度为O(1)，
   3.刷题速度比较慢，基础比较薄弱，需要多加练习，总结经验
  
class MyCircularDeque {

    private int[] queue;

    private int head;

    private int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        queue = new int[k];
        head = 0;
        size = 0 ;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        head = (head + queue.length - 1) % queue.length;
        queue[head] = value;
        size ++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        queue[(head + size) % queue.length] = value;
        size ++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % queue.length;
        size --;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        size --;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return size != 0 ? queue[head] : -1;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return size != 0 ? queue[(head + size - 1) % queue.length] : -1;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == queue.length;
    }
}