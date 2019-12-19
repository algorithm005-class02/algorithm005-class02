/**
 * MyCircularDeque
 */
public class MyCircularDeque {

  int[] myqueue;
  int front;// 队头指针
  int rear;// 队尾指针
  int size;// 队列当前的大小
  int capacity;// 队列的容量

  /** Initialize your data structure here. Set the size of the deque to be k. */
  public MyCircularDeque(int k) {
    this.myqueue = new int[k];
    this.front = 0;
    this.rear = 0;
    this.size = 0;
    this.capacity = k;
  }

  /**
   * Adds an item at the front of Deque. Return true if the operation is
   * successful.
   */
  public boolean insertFront(int value) {
    if (rear == front && size == capacity)
      return false;// 如果队列满，插入失败
    else {
      front = (front + capacity - 1) % capacity;
      myqueue[front] = value;
      size++;
      return true;
    }
  }

  /**
   * Adds an item at the rear of Deque. Return true if the operation is
   * successful.
   */
  public boolean insertLast(int value) {
    if (rear == front && size == capacity)
      return false;// 如果队列满，插入失败
    else {
      myqueue[rear] = value;
      rear = (rear + 1 + capacity) % capacity;
      size++;
      return true;
    }
  }

  /**
   * 删除队列第一个
   */
  public boolean deleteFront() {
    if (rear == front && size == 0)
      return false;
    else {
      front = (front + 1) % capacity;
      size--;
      return true;
    }
  }

  /**
   * 删除队列最后一个
   */
  public boolean deleteLast() {
    if (rear == front && size == 0)
      return false;
    else {
      rear = (rear - 1 + capacity) % capacity;
      size--;
      return true;
    }
  }

  /**
   * 从双端队列头部获得一个元素
   */
  public int getFront() {
    if ((rear == front) && size == 0)
      return -1;
    else {
      int frontE = myqueue[front];
      return frontE;
    }
  }

  /**
   * 获得双端队列的最后一个元素
   */
  public int getRear() {
    if ((rear == front) && size == 0)
      return -1;
    else {
      int rearE = myqueue[(rear - 1 + capacity) % capacity];
      return rearE;
    }
  }

  /** Checks whether the circular deque is empty or not. */
  public boolean isEmpty() {
    return size == 0 && (front == rear);
  }

  /** Checks whether the circular deque is full or not. */
  public boolean isFull() {
    return size == capacity && front == rear;
  }

}