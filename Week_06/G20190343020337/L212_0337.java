package algorithm.leetcode.字典树和并查集;

import java.util.*;

/**
 *
 * 时间复杂度分析：
 *
 * 假设: 有n个单词，每个单词平均长度为k，二维数组board的字符总个数为m*m
 * 那么：构建Trie树：n*k
 * 搜索过程总共循环了 m*m次，每次dfs的时间复杂度为 4 ** k
 * 因此总的时间复杂度为n*k+m*m*(4**k)
 * Trie树+bfs
 *
 */
public class L212_wordsearch2 {


    //右 下 左 上
    int[] dxs = {1,0,-1,0};
    int[] dys = {0,-1,0,1};

    private static Set<String> matchedWorld = null;

    public List<String> findWords(char[][] board, String[] words) {
        matchedWorld = new HashSet<String>();
        if(words.length==0){
            return new ArrayList<String>();
        }

        TrieTree trieTree = new TrieTree();

        for(String word:words){
            trieTree.insert(word);
        }
        int rowlen = board.length;
        int collen = board[0].length;


        for(int i=0;i<rowlen;i++){
            for(int j=0;j<collen;j++){
                Character cij = board[i][j];

                if(trieTree.root.children.containsKey(cij)){
                    //可能存在，从当前位置开始做dfs
                    int[][] indicator = new int[rowlen][collen];
                    dfs(i,j,indicator,board,trieTree.root,"");

                }else{
                    continue;
                }


            }
        }



        return new ArrayList<>(matchedWorld);

    }

    private void dfs(int i,int j, int[][] indicator,char[][] board,TrieNode node,String matched)
    {




        Character c = board[i][j];

        if (node.children.containsKey(c)){
            //将当前节点改成已经访问
            indicator[i][j]=1;
            matched = matched+c;
            TrieNode p = node.children.get(c);
            if(p.children.containsKey(TrieTree.end_of_word)){
                matchedWorld.add(matched);
            }
            for(int k=0;k<4;k++){
                int dx = dxs[k];
                int dy = dys[k];
                if(i+dx>=0 && i+dx<board.length && j+dy>=0 && j+dy<board[0].length){
                    if(indicator[i+dx][j+dy]==0){
                        //没有访问过
                        dfs(i+dx,j+dy,indicator,board,p,matched);
                        //indicator[i+dx][j+dy]=0;
                    }


                }

            }
            indicator[i][j]=0;

        }



    }

    public static void main(String args[]){
        String chararr = "[[\"o\",\"a\",\"a\",\"n\"],[\"e\",\"t\",\"a\",\"e\"],[\"i\",\"h\",\"k\",\"r\"],[\"i\",\"f\",\"l\",\"v\"]] ";
        chararr = chararr.replace("[","{");
        chararr = chararr.replace("]","}");
        chararr = chararr.replace("\"","'");
        System.out.println(chararr);
        //char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};

        //char[][] board = {{'a'}};
        char[][] board = {{'a','b'},{'a','a'}};


        //String[] words = {"oath","pea","eat","rain"};
        //String[] words = {"a"};
        String[] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        L212_wordsearch2 ws2 = new L212_wordsearch2();
        List<String> ret = ws2.findWords(board,words);
        for(String s:ret){
            System.out.println(s);
        }


    }




    static class TrieTree {

        TrieNode root = new TrieNode();
        private static TrieNode end = new TrieNode();
        private static Character end_of_word = '#';


        public TrieTree()
        {

        }

        public void insert(String word){

            TrieNode p = root;
            int length = word.length();
            for(int i=0;i<length;i++){
                Character c = word.charAt(i);
                TrieNode t = p.children.getOrDefault(c,new TrieNode());
                p.children.put(c,t);
                p = t;
            }
            p.children.put(end_of_word,end);

        }
        public boolean search(String word){

            TrieNode p = root;
            for(char c : word.toCharArray()){

                if(p.children.containsKey(c)){
                    p = p.children.get(c);
                }else{
                    return false;
                }

            }
            return p.children.containsKey('#');
        }
        public boolean startWith(String word){
            TrieNode p = root;
            for(char c : word.toCharArray()){

                if(p.children.containsKey(c)){
                    p = p.children.get(c);
                }else{
                    return false;
                }

            }
            return true;
        }

    }

    static class TrieNode {

        public Map<Character,TrieNode> children = new HashMap<>();


    }




}


