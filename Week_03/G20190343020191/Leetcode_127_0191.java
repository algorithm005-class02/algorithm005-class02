/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
import javafx.util.Pair;

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    //单词长度    
    int L = beginWord.length();
    //记录每个单词的通用状态
    HashMap<String ,ArrayList<String>> allComboDict = new HashMap<String,ArrayList<String>>();

    wordList.forEach(
        word -> {
            for(int i=0;i<L;i++){
                String newWord = word.substring(0,i)+'*'+word.substring(i+1,L);
                ArrayList<String> transformations = allComboDict.getOrDefault(newWord,new ArrayList<String>());
                transformations.add(word);
                allComboDict.put(newWord,transformations);
            }
        }
    );

    Queue<Pair<String,Integer>> Q = new LinkedList<Pair<String,Integer>>();
    Q.add(new Pair(beginWord,1));

    //是否访问
    HashMap<String,Boolean>visited = new HashMap<String,Boolean>();
    visited.put(beginWord,true);

    while(!Q.isEmpty()){
        Pair<String,Integer> node = Q.remove();
        String word = node.getKey();
        int level = node.getValue();
        for(int i =0;i<L;i++){
            String newWord = word.substring(0,i)+'*'+word.substring(i+1,L);
            for(String adjacentWord:allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                if(adjacentWord.equals(endWord)){
                    return level+1;
                }
                if(!visited.containsKey(adjacentWord)){
                    visited.put(adjacentWord,true);
                    Q.add(new Pair(adjacentWord,level+1));
                }

            }
        }
    }
    return 0;

  }
}