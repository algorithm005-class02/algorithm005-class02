public class LeetCode_641_0341 {
    class MyCircularDeque {
        private int[] arr;
        private int tail = -1;
        private int head = -1;
        private int count = 0;
        private int maxLength = 0;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            arr = new int[k];
            maxLength = k;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is
         * successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            count++;
            head = (head - 1 + maxLength) % maxLength;
            arr[head] = value;
            if (count == 1) {
                tail = head;
            }
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is
         * successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            count++;
            tail = (tail + 1) % maxLength;
            arr[tail] = value;
            if (count == 1) {
                head = tail;
            }
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is
         * successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            count--;
            if (count == 0) {
                head = -1;
                tail = -1;
            } else {
                head = (head + 1) % maxLength;
            }
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is
         * successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            count--;
            if (count == 0) {
                head = -1;
                tail = -1;
            } else {
                tail = (tail - 1 + maxLength) % maxLength;
            }
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (count == 0) {
                return -1;
            }
            return arr[head];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (count == 0) {
                return -1;
            }
            return arr[tail];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return count == 0 ? true : false;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return count == maxLength ? true : false;
        }
    }
}
