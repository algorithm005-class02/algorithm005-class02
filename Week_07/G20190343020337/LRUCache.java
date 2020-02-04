package algorithm.leetcode.布隆过滤器和LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 1. HashMap+双向链表实现
 * 2. LinkedHashMap实现
 * 
 * 
 * https://www.jianshu.com/p/64f6de3ffcc1 HashMap的loadFactor为什么是0.75？
 * @author david
 *
 */
public class LRUCache extends LinkedHashMap<Integer, Integer>{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }
}

