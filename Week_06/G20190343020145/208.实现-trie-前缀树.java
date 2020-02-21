class Trie {
    public TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode node = root;
        for(int i = 0;i < word.length(); ++ i){
            char curChar = word.charAt(i);
            if(!node.ContainCh(curChar)){
                node.put(curChar,new TrieNode());
            }
            node = node.get(curChar);
        }
        node.setEnd();
        node.val = word;
    }
    public  TrieNode searchPre(String word){
        TrieNode node = root;
        for(int i = 0;i < word.length(); ++ i){
            char curChar = word.charAt(i);
            if(node.ContainCh(curChar)){
                node = node.get(curChar);
            }else {
                return null;
            }
        }
        return node;
    }

    public boolean search(String word){
        TrieNode node = searchPre(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix){
        TrieNode node = searchPre(prefix);
        return node != null;
    }
}

class TrieNode{
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;
    public String val;
    public TrieNode(){
        links = new TrieNode[R];
    }
    public boolean ContainCh(char ch){
        return links[ch - 'a'] != null;
    }
    public TrieNode get(char ch){
        return links[ch - 'a'];
    }
    public void put(char ch,TrieNode node){
        links[ch - 'a'] = node;
    }
    public  void setEnd(){
        isEnd = true;
    }
    public  boolean isEnd(){
        return isEnd;
    }
}