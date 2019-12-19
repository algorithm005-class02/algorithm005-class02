/*
 * @lc app=leetcode.cn id=641 lang=javascript
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
/**
 * Initialize your data structure here. Set the size of the deque to be k.
 * @param {number} k
 */
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

/** 
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = new MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */
// @lc code=end


// function test( methods, vals ){
//     const obj = new MyCircularDeque(vals[0]);
//     for( let i = 1; i < methods.length; i++){
//         console.log(methods[i])
//         obj[methods[i]].apply(obj,vals[i]);
//         //.apply(obj,methods[i]);
//     }
// }

// test(["MyCircularDeque","insertFront","getFront","insertFront","getFront","deleteLast","insertFront","insertFront","getRear","getFront","getRear","getRear","insertLast","deleteFront","getFront","insertLast","getRear","insertLast","deleteFront","insertFront","isFull","getRear","deleteLast","insertLast","getRear","getFront","getFront","insertLast","insertFront","deleteFront","getRear","insertLast","deleteFront","insertFront","insertFront","getRear","getFront","insertFront","insertLast","getRear","getFront","insertFront","insertFront","insertLast","insertLast","getRear","isEmpty","deleteFront","getRear","getRear","getRear","insertLast","getFront","getFront","deleteLast","deleteLast","insertLast","getRear","getRear","insertLast","insertLast","insertFront","getFront","getRear","getFront","insertFront","insertFront","deleteFront","isEmpty","getFront","deleteFront","isFull","getFront","getRear","insertLast","getFront","insertLast","getRear","insertLast","insertFront","getRear","getFront","getFront","deleteLast","deleteLast","insertLast","getRear","getRear","getFront","deleteLast","isFull","insertLast","insertLast","insertFront","getFront","insertFront","isFull","getRear","insertFront","deleteLast","insertLast","insertLast"],
// [[52],[80],[],[27],[],[],[60],[81],[],[],[],[],[46],[],[],[98],[],[11],[],[51],[],[],[],[28],[],[],[],[28],[69],[],[],[11],[],[25],[74],[],[],[48],[7],[],[],[65],[59],[23],[32],[],[],[],[],[],[],[84],[],[],[],[],[64],[],[],[17],[34],[46],[],[],[],[6],[20],[],[],[],[],[],[],[],[34],[],[66],[],[54],[34],[],[],[],[],[],[43],[],[],[],[],[],[21],[93],[79],[],[8],[],[],[78],[],[7],[67]])