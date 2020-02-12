<?php
class LRUCache {
    private $size;
    private $capacity;
    private $arr;
    private $linkList;

    /**
     * @param Integer $capacity
     */
    function __construct($capacity) {
        $this -> size = 0;
        $this -> capacity = $capacity;
        $this -> arr = [];
        $this -> linkList = new DLinkList();
    }

    /**
     * @param Integer $key
     * @return Integer
     */
    function get($key) {
        if (empty($this -> arr[$key])) {
            return -1;
        }
        $node = $this -> arr[$key];
        $this -> linkList -> moveToHead($node);
        return $node -> value;
    }


    /**
     * @param Integer $key
     * @param Integer $value
     * @return NULL
     */
    function put($key, $value) {
        if (empty($this -> arr[$key])) {
            $newNode = new Node();
            $newNode -> key = $key;
            $newNode -> value = $value;
            $this -> arr[$key] = $newNode;
            $this -> linkList -> addNode($newNode);
            $this -> size++;
            if ($this -> size > $this -> capacity) {
                $tail = $this -> linkList -> tailHead();
                unset($this -> arr[$tail -> key]);
                $this -> size--;
            }
        } else {
            $node = $this -> arr[$key];
            $node -> value = $value;
            $this -> linkList -> moveToHead($node);
        }
    }
}

class Node {
    public $key;
    public $value;
    public $prev;
    public $next;
}

class DLinkList {
    public $head;
    public $tail;

    public function __construct()
    {
        $this -> head = new Node();
        $this -> tail = new Node();

        $this -> head -> next = $this -> tail;
        $this -> tail -> pre = $this -> head;
    }

    public function addNode(Node $node) {
        $node -> next = $this -> head -> next;
        $this -> head -> next -> pre = $node;

        $this -> head -> next = $node;
        $node -> pre = $this -> head;
    }

    public function removeNode(Node $node) {
        $pre = $node -> pre;
        $next = $node -> next;

        $pre -> next = $next;
        $next -> pre = $pre;
    }

    public function moveToHead(Node $node) {
        $this -> removeNode($node);
        $this -> addNode($node);
    }
    public function tailHead() {
        $tail = $this -> tail -> pre;
        $this -> removeNode($tail);
        return $tail;
    }
}
