/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class TrieNode {
    private TrieNode[] links;
    private final int R=26;
    private boolean isEnd;
    public TrieNode(){
        links=new TrieNode[R];
    }
    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    public TrieNode get(char ch){
        return links[ch-'a'];
    }
    public void put(char ch,TrieNode node){
        links[ch-'a']=node;
    }
    public void setEnd(){
        isEnd=true;
    }
    public boolean isEnd(){
        return isEnd;
    }
}
class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {//逐层往下递进插入每个字符
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentword = word.charAt(i);
            if (!node.containsKey(currentword)) {
                node.put(currentword, new TrieNode());
            }
            node = node.get(currentword);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    private TrieNode searchperfix(String word) {//逐层往下搜索每个字符，如果存在的话，就不断地向下递进确认
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentword = word.charAt(i);
            if (node.containsKey(currentword)) {
                node = node.get(currentword);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchperfix(word);
        return node != null && node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchperfix(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
// @lc code=end
