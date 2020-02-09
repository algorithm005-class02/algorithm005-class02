package main

import (
	"container/list"
)

// LRUCache type define LRU cache
type LRUCache struct {
	cacheDBList *list.List
	cacheData   map[int]*list.Element
	cap         int
}

// LRUCacheElement type define the cache item
type LRUCacheElement struct {
	Key   int
	Value int
}

// Constructor create a LRU cache whit capacity
func Constructor(capacity int) LRUCache {
	lru := LRUCache{
		cacheDBList: list.New(),
		cacheData:   make(map[int]*list.Element),
		cap:         capacity}

	lru.cacheDBList.Init()

	return lru
}

// Get get a data from LRU cache
func (l *LRUCache) Get(key int) int {
	var e *list.Element
	var ok bool
	if e, ok = l.cacheData[key]; !ok {
		return -1
	}

	l.cacheDBList.MoveToFront(e)
	return e.Value.(LRUCacheElement).Value
}

// Put put a data to LRU cache
func (l *LRUCache) Put(key int, value int) {
	if e, ok := l.cacheData[key]; ok {
		e.Value = LRUCacheElement{Key: key, Value: value}
		l.cacheDBList.MoveToFront(e)
		return
	}

	e := l.cacheDBList.PushFront(LRUCacheElement{Key: key, Value: value})
	l.cacheData[key] = e

	if l.cap < l.cacheDBList.Len() {
		last := l.cacheDBList.Back()
		l.cacheDBList.Remove(last)
		delete(l.cacheData, last.Value.(LRUCacheElement).Key)
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */
