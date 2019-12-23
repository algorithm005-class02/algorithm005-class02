/*
 * @lc app=leetcode.cn id=239 lang=javascript
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var maxSlidingWindow = function(nums, k) {
    // 存储最大值的队列 由大到小
    let queue = new MyCircularDeque( nums.length );
    let result = [];
    let wIndex = 0;
    for (let i = 0; i < nums.length; i++) {
        let val = nums[i];
        while ( queue.length > 0 && val > queue.getRear() ) {
            queue.deleteLast(); // 较小的值从队尾删除
        }
        queue.insertLast( val );
        result[wIndex] = queue.getFront();

        if ( i >= k - 1 ) {
            // 下一轮滑出窗口的值
            let outVal = nums[i - k + 1];
            if( outVal === queue.getFront() ) queue.deleteFront();
            wIndex++;
        }
    }
    return result;
};

var MyCircularDeque = function(k) {
    this.size = k;
    this.head = null;
    this.tail = null;
    this.length = 0;
};

var LinkedList = function(val) {
    this.val = val;
    this.next = null;
    this.prev = null
}

/**
 * Adds an item at the front of Deque. Return true if the operation is successful. 
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertFront = function(value) {
    if( this.isFull() ) return false;
    const newNode = new LinkedList(value);
    if( this.isEmpty() ){
        this.tail = newNode;
        this.head = newNode;
    }else{
        newNode.next = this.head;
        this.head.prev = newNode;
        this.head = newNode;
    }
    this.length++;
    return true;
};

/**
 * Adds an item at the rear of Deque. Return true if the operation is successful. 
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertLast = function(value) {
    if( this.isFull() ) return false;
    const newNode = new LinkedList(value);
    if( this.isEmpty() ){
        this.head = newNode;
        this.tail = newNode;
    }else{
        newNode.prev = this.tail;
        this.tail.next = newNode;
        this.tail = newNode;
    }
    this.length++;
    return true;
};

/**
 * Deletes an item from the front of Deque. Return true if the operation is successful.
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteFront = function() {
    if( this.isEmpty() ) return false;
    this.head = this.head.next;
    this.length--;
    return true;
};

/**
 * Deletes an item from the rear of Deque. Return true if the operation is successful.
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteLast = function() {
    if( this.isEmpty() ) return false;
    this.tail = this.tail.prev;
    this.length--;
    return true;
};

/**
 * Get the front item from the deque.
 * @return {number}
 */
MyCircularDeque.prototype.getFront = function() {
    if( this.isEmpty() ) return -1;
    return this.head.val;
};

/**
 * Get the last item from the deque.
 * @return {number}
 */
MyCircularDeque.prototype.getRear = function() {
    if( this.isEmpty() ) return -1;
    return this.tail.val;
};

/**
 * Checks whether the circular deque is empty or not.
 * @return {boolean}
 */
MyCircularDeque.prototype.isEmpty = function() {
    return this.length === 0;
};

/**
 * Checks whether the circular deque is full or not.
 * @return {boolean}
 */
MyCircularDeque.prototype.isFull = function() {
    return this.length === this.size;
};
// @lc code=end

