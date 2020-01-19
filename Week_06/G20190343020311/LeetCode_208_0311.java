class Trie {
    public char data;
    public Trie[] children = new Trie[26];
    public boolean isEndingChar = false;
    private Trie root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Trie('/');
    }

    public Trie(char data) {
        this.data = data;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie p = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (p.children[index] == null) {
                Trie newNode = new Trie(word.charAt(i));
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie p = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        if (p.isEndingChar == false) return false;
        else return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie p = root;
        for (int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        if (p.isEndingChar == false) return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */