package leetcode;

import java.util.Hashtable;

class LeetCode_146_LRU_0011 {

    private Hashtable<Integer, DoubleLinkedNode> cache = new Hashtable<Integer, DoubleLinkedNode>();
    private int size;
    private int capacity;
    private DoubleLinkedNode head, tail;

    public LeetCode_146_LRU_0011(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            DoubleLinkedNode newNode = new DoubleLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            if (size > capacity) {
                DoubleLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addNode(DoubleLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleLinkedNode node) {
        DoubleLinkedNode prev = node.prev;
        DoubleLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DoubleLinkedNode popTail() {
        DoubleLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    class DoubleLinkedNode {
        int key;
        int value;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
    }

}