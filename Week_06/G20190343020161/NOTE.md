# 学习笔记
## Trie（前缀树、字典树）
### 定义
trie，又称前缀树或字典树，是一种有序树，用于保存关联数组，其中的键通常是字符串。与二叉查找树不同，键不是直接保存在节点中，而是由节点在树中的位置决定。一个节点的所有子孙都有相同的前缀，也就是这个节点对应的字符串，而根节点对应空字符串。一般情况下，不是所有的节点都有对应的值，只有叶子节点和部分内部节点所对应的键才有相关的值。

### 特点
- 根节点不包含字符，除根节点外每一个节点都只包含一个字符
- 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串
- 每个节点的所有子节点包含的字符都不相同
### 复杂度
- 参数：单词长度（L），树的出度（N）,树的高度（M）
- 时间复杂度：O(L)
- 空间复杂度：O(N^M)
### 优点
最大限度地减少无谓的字符串比较，查询效率比较高
### 应用
- 词频统计
- 输入提示 

### 实现
    
    class Trie {
    class TrieNode {
        public TrieNode() {
            children = new TrieNode[26];
            is_word = false;
        }
        public boolean is_word;
        public TrieNode[] children;
    }
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = (int)(word.charAt(i) - 'a');
            if (p.children[index] == null)
                p.children[index] = new TrieNode();
            p = p.children[index];
        }
        p.is_word = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.is_word;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = find(prefix);
        return node != null;
    }
    
    private TrieNode find(String prefix) {
        TrieNode p = root;
        for(int i = 0; i < prefix.length(); i++) {
            int index = (int)(prefix.charAt(i) - 'a');
            if (p.children[index] == null) return null;
            p = p.children[index];
        }
        return p;
    }
}
