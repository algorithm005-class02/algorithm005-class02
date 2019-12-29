class MyCircularDeque {

    //双端最大容量
    private int maxSize;
    //双端队列元素使用数组存放
    private int[] dequeArray;
    //队首指针
    private int front;
    //队尾指针
    private int rear;
    //双端队列元素个数
    private int nItems;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.maxSize = k;
        this.dequeArray = new int[maxSize];
        this.front = 0;
        this.rear = 0;
        this.nItems = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (rear == front && nItems == maxSize) {
            return false;
        } else {
            front = (front + maxSize - 1) % maxSize;
            dequeArray[front] = value;
            nItems++;
            return true;
        }
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (rear == front && nItems == maxSize) {
            return false;
        } else {
            dequeArray[rear] = value;
            rear = (rear + maxSize + 1) % maxSize;
            nItems ++;
            return true;
        }
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (rear == front && nItems == 0) {
            return false;
        } else {
            front = (front + 1) % maxSize;
            nItems --;
            return true;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (rear == front && nItems == 0) {
            return false;
        } else {
            rear = (rear - 1 + maxSize) % maxSize;
            nItems --;
            return true;
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (rear == front && nItems == 0) {
            return -1;
        } else {
            int frontEle = dequeArray[front];
            return frontEle;
        }
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (rear == front && nItems == 0) {
            return -1;
        } else {
            int rearEle = dequeArray[(rear - 1 + maxSize) % maxSize];
            return rearEle;
        }
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if (rear == front && nItems == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if (rear == front && nItems == maxSize) {
            return true;
        } else {
            return false;
        }
    }
}