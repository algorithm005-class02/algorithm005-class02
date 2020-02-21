package leetcode
import "container/list"
/*
 * @lc app=leetcode.cn id=146 lang=golang
 *
 * [146] LRU缓存机制
 *
 * https://leetcode-cn.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (44.76%)
 * Likes:    396
 * Dislikes: 0
 * Total Accepted:    31.4K
 * Total Submissions: 69.5K
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) -
 * 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * 
 * 进阶:
 * 
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 
 * 示例:
 * 
 * LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * 
 * 
 */

// @lc code=start
type Node struct {
    Key int
    Val int
}

type LRUCache struct {
    capacity int
    cache map[int]*list.Element
    lru *list.List
}


func Constructor(capacity int) LRUCache {
    return LRUCache{
        capacity: capacity,
        cache: make(map[int]*list.Element, capacity),
        lru: list.New(),
    }
}


func (this *LRUCache) Get(key int) int {
    if ele, ok := this.cache[key]; ok {
        this.lru.MoveToBack(ele)
        return ele.Value.(Node).Val
    }
    return -1
}


func (this *LRUCache) Put(key int, value int)  {
    if ele, ok := this.cache[key]; ok {
        this.lru.Remove(ele)
    } else if len(this.cache) >= this.capacity {
        front := this.lru.Front()
        this.lru.Remove(front)
        delete(this.cache, front.Value.(Node).Key)
    }

    node := Node{Key: key, Val: value}
    ele := this.lru.PushBack(node)
    this.cache[key] = ele
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */
// @lc code=end

