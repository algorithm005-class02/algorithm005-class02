package leetcode

import "container/list"

/*
 * @lc app=leetcode.cn id=146 lang=golang
 *
 * [146] LRU缓存机制
 */

// @lc code=start
type LRUCache struct {
	capacity  int
	list      *list.List
	container map[int]*list.Element
}

type ListEle struct {
	Key   int
	Value int
}

func Constructor(capacity int) LRUCache {
	l := list.New()
	container := make(map[int]*list.Element, capacity)
	return LRUCache{
		capacity:  capacity,
		list:      l,
		container: container,
	}
}

func (this *LRUCache) Get(key int) int {
	if val, ok := this.container[key]; ok {
		this.list.MoveToBack(val)
		return val.Value.(*ListEle).Value
	}
	return -1
}

func (this *LRUCache) Put(key int, value int) {
	if val, ok := this.container[key]; ok {
		val.Value.(*ListEle).Value = value
		this.list.MoveToBack(val)
		return
	}
	if this.list.Len() >= this.capacity {
		lastEle := this.list.Front()
		this.list.Remove(lastEle)
		delete(this.container, lastEle.Value.(*ListEle).Key)
	}
	le := &ListEle{
		Key:   key,
		Value: value,
	}
	ele := this.list.PushBack(le)
	this.container[key] = ele
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */
// @lc code=end
