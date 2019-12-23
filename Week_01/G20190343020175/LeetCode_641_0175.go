package main

// MyCircularDeque a circuar deque
type MyCircularDeque struct {
	buffer []int
	front  int
	rear   int
	length int
}

// Constructor Initialize your data structure here. Set the size of the deque to be k.
func Constructor(k int) MyCircularDeque {
	newCapacity := k + 1
	return MyCircularDeque{buffer: make([]int, newCapacity), front: 0, rear: 0, length: newCapacity}
}

// InsertFront Adds an item at the front of Deque. Return true if the operation is successful.
func (dq *MyCircularDeque) InsertFront(value int) bool {
	if dq.rear == (dq.front+1)%dq.length {
		return false
	}

	dq.front = (dq.front + 1) % dq.length
	dq.buffer[dq.front] = value

	return true
}

// InsertLast Adds an item at the rear of Deque. Return true if the operation is successful.
func (dq *MyCircularDeque) InsertLast(value int) bool {
	if dq.front == (dq.rear-1+dq.length)%dq.length {
		return false
	}

	dq.buffer[dq.rear] = value
	dq.rear = (dq.rear - 1 + dq.length) % dq.length

	return true
}

// DeleteFront Deletes an item from the front of Deque. Return true if the operation is successful.
func (dq *MyCircularDeque) DeleteFront() bool {
	if dq.front == dq.rear {
		return false
	}

	dq.front = (dq.front - 1 + dq.length) % dq.length

	return true
}

// DeleteLast Deletes an item from the rear of Deque. Return true if the operation is successful.
func (dq *MyCircularDeque) DeleteLast() bool {
	if dq.front == dq.rear {
		return false
	}

	dq.rear = (dq.rear + 1) % dq.length

	return true
}

// GetFront Get the front item from the deque.
func (dq *MyCircularDeque) GetFront() int {
	if dq.front == dq.rear {
		return -1
	}
	return dq.buffer[dq.front]
}

// GetRear Get the last item from the deque.
func (dq *MyCircularDeque) GetRear() int {
	if dq.front == dq.rear {
		return -1
	}
	return dq.buffer[(dq.rear+1)%dq.length]
}

// IsEmpty Checks whether the circular deque is empty or not.
func (dq *MyCircularDeque) IsEmpty() bool {
	return dq.front == dq.rear
}

// IsFull Checks whether the circular deque is full or not.
func (dq *MyCircularDeque) IsFull() bool {
	return (dq.front+1)%dq.length == dq.rear
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * obj := Constructor(k);
 * param_1 := obj.InsertFront(value);
 * param_2 := obj.InsertLast(value);
 * param_3 := obj.DeleteFront();
 * param_4 := obj.DeleteLast();
 * param_5 := obj.GetFront();
 * param_6 := obj.GetRear();
 * param_7 := obj.IsEmpty();
 * param_8 := obj.IsFull();
 */

/*
func main() {
	circularDeque := Constructor(3)
	fmt.Println(circularDeque.InsertLast(1), circularDeque)
	fmt.Println(circularDeque.InsertLast(2), circularDeque)
	fmt.Println(circularDeque.InsertFront(3), circularDeque)
	fmt.Println(circularDeque.InsertFront(4), circularDeque)
	fmt.Println(circularDeque.GetRear(), circularDeque)
	fmt.Println(circularDeque.IsFull(), circularDeque)
	fmt.Println(circularDeque.DeleteLast(), circularDeque)
	fmt.Println(circularDeque.InsertFront(4), circularDeque)
	fmt.Println(circularDeque.GetFront(), circularDeque)
}
*/
