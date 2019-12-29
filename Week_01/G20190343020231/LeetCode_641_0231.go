package main

// 1. 基于链表，题目没说需要查询，因此比较适合。
//type MyCircularDeque struct {
//	head  *Node
//	tail  *Node
//	len   int
//	count int
//}
//
//type Node struct {
//	Next *Node
//	Pre  *Node
//	Val  int
//}
//
///** Initialize your data structure here. Set the size of the deque to be k. */
//func Constructor(k int) MyCircularDeque {
//	head := Node{
//		Next: nil,
//		Pre:  nil,
//		Val:  0,
//	}
//	tail := Node{
//		Next: nil,
//		Pre:  nil,
//		Val:  0,
//	}
//	head.Next = &tail
//	tail.Pre = &head
//	deque := MyCircularDeque{
//		head:  &head,
//		tail:  &tail,
//		len:   k,
//		count: 0,
//	}
//
//	return deque
//}
//
///** Adds an item at the front of Deque. Return true if the operation is successful. */
//func (this *MyCircularDeque) InsertFront(value int) bool {
//	if this.IsFull() {
//		return false
//	}
//	temp := this.head.Next
//	tempNode := Node{
//		Next: temp,
//		Pre:  this.head,
//		Val:  value,
//	}
//	this.head.Next = &tempNode
//	temp.Pre = &tempNode
//	this.count++
//	return true
//}
//
///** Adds an item at the rear of Deque. Return true if the operation is successful. */
//func (this *MyCircularDeque) InsertLast(value int) bool {
//	if this.IsFull() {
//		return false
//	}
//	temp := this.tail.Pre
//	tempNode := Node{
//		Next: this.tail,
//		Pre:  temp,
//		Val:  value,
//	}
//	this.tail.Pre = &tempNode
//	temp.Next = &tempNode
//	this.count++
//	return true
//}
//
///** Deletes an item from the front of Deque. Return true if the operation is successful. */
//func (this *MyCircularDeque) DeleteFront() bool {
//	if this.IsEmpty() {
//		return false
//	}
//	deleteTemp := this.head.Next
//	this.head.Next = deleteTemp.Next
//	deleteTemp.Next.Pre = this.head
//	deleteTemp.Next, deleteTemp.Pre = nil, nil
//	this.count--
//	return true
//}
//
///** Deletes an item from the rear of Deque. Return true if the operation is successful. */
//func (this *MyCircularDeque) DeleteLast() bool {
//	if this.IsEmpty() {
//		return false
//	}
//	deleteTemp := this.tail.Pre
//	deleteTemp.Pre.Next = this.tail
//	this.tail.Pre = deleteTemp.Pre
//	deleteTemp.Next, deleteTemp.Pre = nil, nil
//	this.count--
//	return true
//}
//
///** Get the front item from the deque. */
//func (this *MyCircularDeque) GetFront() int {
//	return this.head.Next.Val
//}
//
///** Get the last item from the deque. */
//func (this *MyCircularDeque) GetRear() int {
//	return this.tail.Pre.Val
//}
//
///** Checks whether the circular deque is empty or not. */
//func (this *MyCircularDeque) IsEmpty() bool {
//	return this.head.Next == this.tail
//}
//
///** Checks whether the circular deque is full or not. */
//func (this *MyCircularDeque) IsFull() bool {
//	return this.len == this.count
//}

// 2. 基于数组，使用两个循环游标标记start和end
type MyCircularDeque struct {
	data []int
	front int
	last  int
}

func Constructor(k int) MyCircularDeque {
	return MyCircularDeque{
		data:  make([]int, k+1, k+1),
		front: 0,	// 起始元素位置
		last:  0,	// 最后一个元素的下一个位置
	}
}

func (this *MyCircularDeque) InsertFront(value int) bool {
	if this.IsFull() {
		return false
	}
	this.front = (len(this.data) + this.front - 1) % len(this.data)
	this.data[this.front] = value
	return true
}

func (this *MyCircularDeque) InsertLast(value int) bool {
	if this.IsFull() {
		return false
	}
	this.data[this.last] = value
	this.last = (this.last + 1) % len(this.data)
	return true
}

func (this *MyCircularDeque) DeleteFront() bool {
	if this.IsEmpty() {
		return false
	}
	this.front = (this.front + 1) % len(this.data)
	return true
}

func (this *MyCircularDeque) DeleteLast() bool {
	if this.IsEmpty() {
		return false
	}
	this.last = (len(this.data) + this.last - 1) % len(this.data) // 循环左移一位
	return true
}

func (this *MyCircularDeque) GetFront() int {
	if this.IsEmpty() {
		return -1
	}
	return this.data[this.front]
}

func (this *MyCircularDeque) GetRear() int {
	if this.IsEmpty() {
		return -1
	}

	return this.data[(len(this.data)+this.last-1)%len(this.data)]
}

func (this *MyCircularDeque) IsEmpty() bool {
	return this.last == this.front
}

func (this *MyCircularDeque) IsFull() bool {
	return (this.last+1)%len(this.data) == this.front
}
