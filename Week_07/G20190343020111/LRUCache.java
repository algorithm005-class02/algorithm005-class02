package com.solution;

import java.util.HashMap;

public class LRUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache cache = new LRUCache(2 /* 缓存容量 */ );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1)); // 返回 1
		cache.put(3, 3); // 该操作会使得密钥 2 作废
		System.out.println(cache.get(2)); // 返回 -1 (未找到)
		cache.put(4, 4); // 该操作会使得密钥 1 作废
		System.out.println(cache.get(1)); // 返回 -1 (未找到)
		System.out.println(cache.get(3)); // 返回 3
		System.out.println(cache.get(4));

	}

	private HashMap<Integer, Node> map;
	private DoubleList cache;
	private int cap;

	public LRUCache(int capacity) {
		map = new HashMap<>();
		cache = new DoubleList();
		this.cap = capacity;
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;
		Node node = map.get(key);
		put(key, node.val);
		return node.val;
	}

	public void put(int key, int val) {
		Node s = new Node(key, val);
		if (map.containsKey(key)) {
			cache.remove(map.get(key));
			cache.addFirst(s);
			map.put(key, s);// 是否有必要？
		} else {
			cache.addFirst(s);
			if (cache.size > cap) {
				Node last = cache.removeLast();
				map.remove(last.key);
			}
			map.put(key, s);
		}

	}

	class Node {
		public int key, val;
		public Node next, prev;

		public Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	class DoubleList {
		private Node head, tail;
		private int size;

		public DoubleList() {
			head = new Node(0, 0);
			tail = new Node(0, 0);
			head.next = tail;
			tail.prev = head;
			size = 0;
		}

		public void addFirst(Node x) {
			head.next.prev = x;
			x.next = head.next;
			head.next = x;
			x.prev = head;
			size++;
		}

		public void remove(Node x) {
			x.prev.next = x.next;
			x.next.prev = x.prev;
			size--;
		}

		public Node removeLast() {
			if (tail.prev == head) {
				return null;
			}
			Node last = tail.prev;
			remove(last);
			return last;
		}

		public int size() {
			return size;
		}

	}
}
