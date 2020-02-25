import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU Cache
 * https://leetcode.com/problems/lru-cache/
 */
public class Leetcode_146_lruCache {
    /**
     * 方法1：直接使用LinkedHashMap
     */

    class LRUCache extends LinkedHashMap<Integer, Integer> {
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

    /**
     * 方法2：使用HashTable和自定义双向链表
     */
    static class LRUCache2 {

        private Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();
        private int size;
        private int capacity;
        private DLinkedNode head;
        private DLinkedNode tail;

        public LRUCache2(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }

            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;

                cache.put(key, newNode);
                addNode(newNode);
                size++;

                if (size > capacity) {
                    DLinkedNode tail = popTail();
                    cache.remove(tail.key);
                    size--;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
        }

        private void addNode(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;

        }

        private void removeNode(DLinkedNode node) {
            DLinkedNode prev = node.prev;
            DLinkedNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addNode(node);
        }

        private DLinkedNode popTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }
    }

    public static void main(String[] args) {
        LRUCache2 lruCache = new LRUCache2(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
    }
}
