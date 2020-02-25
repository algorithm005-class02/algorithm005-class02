package smart33690;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 现 Trie (前缀树)
 */
public class LeetCode208 {
    public static void main(String[] args) {
        LeetCode208 trie = new LeetCode208();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }
    static class TrieNode {
        boolean flag;
        HashMap<Character, TrieNode> next = new HashMap<Character, TrieNode>();

        public TrieNode() {
            flag = false;
        }
    }

    TrieNode root;

    LeetCode208(){
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(Character c : word.toCharArray()){
            if(!node.next.containsKey(c)) {
                TrieNode newNode = new TrieNode();
                node.next.put(c, newNode);
                node = newNode;
            } else{
                node = node.next.get(c);
            }
        }
        node.flag = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word.length() == 0) return true;
        TrieNode node = root;
        for(Character c : word.toCharArray()){
            if(!node.next.containsKey(c)) return false;
            node = node.next.get(c);
        }
        return node.flag;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix.length() == 0) return true;
        TrieNode node = root;
        for(Character c : prefix.toCharArray()){
            if(!node.next.containsKey(c)) return false;
            node = node.next.get(c);
        }
        return true;
    }
}


