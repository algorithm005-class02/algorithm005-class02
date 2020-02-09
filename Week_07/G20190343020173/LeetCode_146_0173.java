package org.crayzer.leetcode.editor.en.list;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_146_LRUCache {
    class Node {
        public int key, val;
        public Node prev, next;
        public Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            this.size = 0;
        }

        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node removeLast() {
            if (tail.prev == head) return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public int size() {
            return this.size;
        }
    }

    class LRUCache {

        private DoubleList cache;
        private int cap;
        private Map<Integer, Node> map;

        public LRUCache(int capacity) {
            this.cache = new DoubleList();
            this.cap = capacity;
            this.map = new HashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            int val = map.get(key).val;
            put(key, val);
            return val;
        }

        public void put(int key, int value) {
            Node x = new Node(key, value);
            if (map.containsKey(key)) {
                cache.remove(map.get(key));
                cache.addFirst(x);
                map.put(key, x);
            } else {
                if (cache.size() == cap) {
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
                cache.addFirst(x);
                map.put(key, x);
            }
        }
    }
}
