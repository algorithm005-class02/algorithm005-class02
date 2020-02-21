<?php
class MyCircularDeque {

    private $size;

    private $deque;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     * @param Integer $k
     */
    function __construct($k) {
        $this->size = $k;
        $this->deque = [];
    }
  
    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     * @param Integer $value
     * @return Boolean
     */
    function insertFront($value) {
        if (count($this->deque) >= $this->size) {
            return false;
        }
        array_unshift($this->deque, $value);
        return true;
    }
  
    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     * @param Integer $value
     * @return Boolean
     */
    function insertLast($value) {
        if (count($this->deque) >= $this->size) {
            return false;
        }
        $this->deque[] = $value;
        return true;
    }
  
    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     * @return Boolean
     */
    function deleteFront() {
        if (count($this->deque) > 0) {
            array_shift($this->deque);
            return true;
        }
        return false;
    }
  
    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     * @return Boolean
     */
    function deleteLast() {
        if (count($this->deque) > 0) {
            array_pop($this->deque);
            return true;
        }
        return false;
    }
  
    /**
     * Get the front item from the deque.
     * @return Integer
     */
    function getFront() {
        if (count($this->deque) > 0) {
            return $this->deque[0];
        }
        return -1;
    }
  
    /**
     * Get the last item from the deque.
     * @return Integer
     */
    function getRear() {
        $count = count($this->deque);
        if ($count > 0) {
            return $this->deque[$count - 1];
        }
        return -1;
    }
  
    /**
     * Checks whether the circular deque is empty or not.
     * @return Boolean
     */
    function isEmpty() {
        return count($this->deque) === 0;
    }
  
    /**
     * Checks whether the circular deque is full or not.
     * @return Boolean
     */
    function isFull() {
        return count($this->deque) === $this->size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * $obj = MyCircularDeque($k);
 * $ret_1 = $obj->insertFront($value);
 * $ret_2 = $obj->insertLast($value);
 * $ret_3 = $obj->deleteFront();
 * $ret_4 = $obj->deleteLast();
 * $ret_5 = $obj->getFront();
 * $ret_6 = $obj->getRear();
 * $ret_7 = $obj->isEmpty();
 * $ret_8 = $obj->isFull();
 */