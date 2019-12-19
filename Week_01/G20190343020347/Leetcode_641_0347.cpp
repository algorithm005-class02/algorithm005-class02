class MyCircularDeque {
	int front;
	int end;
	int size;
	int *deque;
public:
	/** Initialize your data structure here. Set the size of the deque to be k. */
	MyCircularDeque(int k) {
		deque = new int[k + 1];
		size = k + 1;
		front = end = 0;
	}

	/** Adds an item at the front of Deque. Return true if the operation is successful. */
	bool insertFront(int value) {
		if (isFull()) {
			return false;
		}
		else {
			deque[front] = value;
			front = (front - 1 + size) % size;	//front-1
			return true;
		}
	}

	/** Adds an item at the rear of Deque. Return true if the operation is successful. */
	bool insertLast(int value) {
		if (isFull()) {
			return false;
		}
		else {
			end = (end + 1) % size;
			deque[end] = value;
			return true;
		}
	}

	/** Deletes an item from the front of Deque. Return true if the operation is successful. */
	bool deleteFront() {
		if (isEmpty()) {
			return false;
		}
		else {
			front = (front + 1) % size;
			return true;
		}
	}

	/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
	bool deleteLast() {
		if (isEmpty()) {
			return false;
		}
		else {
			end = (end - 1 + size) % size;
			return true;
		}
	}

	/** Get the front item from the deque. */
	int getFront() {
		if (isEmpty())
			return -1;
		else
			return deque[(front + 1) % size];
	}

	/** Get the last item from the deque. */
	int getRear() {
		if (isEmpty())
			return -1;
		else
			return deque[end];
	}

	/** Checks whether the circular deque is empty or not. */
	bool isEmpty() {
		if (front == end)
			return true;
		else
			return false;
	}

	/** Checks whether the circular deque is full or not. */
	bool isFull() {
		if ((end + 1) % size == front)
			return true;
		else
			return false;
	}
};