/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class MyCircularDeque {
    int[] elementData;
    int head;
    int tail;
    int size;
    int capacity;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.head = 0;//头指针
        this.tail = 0;//尾指针
        this.size = 0;//随着增删不断改变的当前容量大小
        this.capacity = k;//双端队列的容量
        this.elementData = new int[k];//底层实现装载元素的数组

    }
    /**
     * Adds an item at the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertFront(int value) {
        if (head == tail && size == capacity)
            return false;
        else {
            head = (head + capacity - 1) % capacity;//由于head初始时为0，在最左侧，所以需要先找到双端队列
            //最右侧头端点：head的位置
            elementData[head] = value;//将当前插入的值赋值在head位置处
            size++;//元素个数++；
            return true;
        }

    }
    /**
     * Adds an item at the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertLast(int value) {
        if (head == tail && size == capacity)
            return false;
        else {
            elementData[tail] = value;//由于tail初始时为0，在最左侧，即为双端队列
            //最左侧头端点：tail的位置；将value值插入进来后。
            tail = (tail + 1 + capacity) % capacity;//更新尾指针的指向指向前一个位置
            size++;
            return true;
        }
    }
    /**
     * Deletes an item from the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteFront() {
        if (head == tail && size == 0)
            return false;
        else {
            head = (head + 1 + capacity) % capacity;//删除了右侧的头元素，则需要将头指针向右
            //移动一个；
            size--;
            return true;
        }
    }
    /**
     * Deletes an item from the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteLast() {
        if (head == tail && size == 0)
            return false;
        else {
            tail = (tail - 1 + capacity) % capacity;//删除了最左侧的头元素，则需要将尾指针向左
            //移动一个；
            size--;
            return true;
        }
        // return true;
    }
    /** Get the front item from the deque. */
    public int getFront() {
        if (head == tail && size == 0)
            return -1;
        else {
            int head_num = elementData[head];//索引当前头指针的指向的位置
            return head_num;
        }
        // return true;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (head == tail && size == 0)
            return -1;
        else {
            int tail_num = elementData[(tail - 1 + capacity) % capacity];//因为尾部插入元素时
            //更新了尾部指针，指向了前一个位置，则取尾部元素时，需要先将尾部指针后退一个，取其元素
            return tail_num;
        }
        // return true;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return (head == tail) && size == 0;//size==0时为空
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (head == tail) && size == capacity;//size==capacity时，为满的
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k); boolean param_1 =
 * obj.insertFront(value); boolean param_2 = obj.insertLast(value); boolean
 * param_3 = obj.deleteFront(); boolean param_4 = obj.deleteLast(); int param_5
 * = obj.getFront(); int param_6 = obj.getRear(); boolean param_7 =
 * obj.isEmpty(); boolean param_8 = obj.isFull();
 */
// @lc code=end
/* 
思路历程：
    基于数组实现的双端队列，两端都可以进行元素的加入和移出；通过实践得知：
    双端队列的右侧是头指针head;左侧是尾指针tail。
    头部插入元素的时候，需要先找到head指针指向的位置；
    尾部插入元素的时候，插入后，需要更新尾部的指针向右一个；
    删除头部元素的时候，需要更新头部指针，将头部指针向右挪一个
    删除尾部元素的时候，需要更新尾部指针，将尾部指针往左挪一个，
    取尾部元素的时候，因为尾部插入的时候，将尾部指针往右移动了一个，所以先需要将尾部指针向左侧移动一个
    取头部元素的时候，直接索引head即可
    判断是否为空或者是满的，即看size是否为0或者是capacity。
*/