<?php

//实现字典树
class Trie {
    public $root;
    /**
     * Initialize your data structure here.
     */
    function __construct() {
        $this -> root = new TriesNode();
    }

    /**
     * Inserts a word into the trie.
     * @param String $word
     * @return NULL
     */
    function insert($word) {
        if (!empty($word)) {
            $co = strlen($word);
            $p = $this -> root;
            for ($i =0; $i < $co; $i++) {
                $strLetter = $word{$i};
                if (!$p -> containKey($strLetter)) {
                    $p -> put($strLetter, new TriesNode());
                }
                $p = $p -> get($strLetter);
            }
            $p -> setEnd();
        }

    }

    /**
     * Returns if the word is in the trie.
     * @param String $word
     * @return Boolean
     */
    function search($word) {
        $p = $this -> isContain($word);
        return !empty($p) && $p -> getEnd();
    }

    private function isContain($word) {
        if (!empty($word)) {
            $co = strlen($word);
            $p = $this -> root;
            for ($i =0; $i < $co; $i++) {
                $strLetter = $word{$i};
                if (!$p -> containKey($strLetter)) {
                    return false;
                }
                $p = $p -> get($strLetter);
            }
            return $p;
        }
        return false;

    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * @param String $prefix
     * @return Boolean
     */
    function startsWith($prefix) {
        $p = $this -> isContain($prefix);
        return !empty($p);
    }
}
class TriesNode {
    private $links = [];
    private $isEnd = false;
    public function containKey($ch) {
        return array_key_exists($ch, $this -> links) !== false;
    }
    public function get($ch) {
        return $this -> links[$ch];
    }
    public function put($ch, $node) {
        $this -> links[$ch] = $node;
    }
    public function setEnd() {
        $this -> isEnd = true;
    }
    public function getEnd() {
        return $this -> isEnd;
    }
}