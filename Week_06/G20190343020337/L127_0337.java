package algorithm.leetcode.高级搜索;

import java.util.*;
//双向BFS
public class L127_wordladder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        Set<String> set = new LinkedHashSet<>();
        set.add(beginWord);
        set.addAll(wordList);
        if(set.contains(endWord)){
            set.remove(endWord);
            set.add(endWord);
        }

        int ret = bfs(set,beginWord,endWord);
        return ret;
    }
    public int bfs(Set<String> wordList,String beginWord,String endWord){

        //邻接表法表示
        Map<String,Set<String>> graph  = generateGraph(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();


        beginSet.add(beginWord);
        endSet.add(endWord);
        int length = 0;

        while(beginSet.size()>0 && endSet.size()>0 ){

            if(beginSet.size()>endSet.size()){
                Set<String> tmp = beginSet;
                beginSet=endSet;
                endSet = tmp;
            }
            Set<String> level = new HashSet<>();
            for(String word:beginSet){
                visited.add(word);
                if(endSet.contains(word)){
                    return length+1;
                }

                Set<String> children = graph.get(word);
                if(children!=null)
                    for(String child:children){
                        if(!visited.contains(child)){
                            level.add(child);
                        }
                    }

            }
            length=length+1;
            beginSet = level;
        }
        return 0;
    }



    private Map<String,Set<String>> generateGraph( Set<String> wordList) {
        Map<String,Set<String>> graph = new HashMap<>();
        Map<String,Set<String>> ajd_graph = new HashMap<>();
        int length = wordList.iterator().next().length();
        wordList.forEach(
                word->{
                    char[] wordchar =  word.toCharArray();
                    for(int i=0;i<length;i++){
                        char oldchar = wordchar[i];
                        wordchar[i]='*';
                        String newStr = new String(wordchar);
                        Set<String> transformations =
                                graph.getOrDefault(newStr, new HashSet<>());
                        transformations.add(word);
                        graph.put(newStr, transformations);


                        Set<String> mapping = graph.getOrDefault(word ,new HashSet<>());
                        mapping.add(newStr);
                        graph.put(word,mapping);

                        wordchar[i]=oldchar;
                    }
                }
        );
        for(String word:wordList){
            Set<String> ajd = new HashSet<>();
            Set<String> mapping = graph.get(word);
            for(String m:mapping){
                ajd.addAll(graph.get(m));
            }
            ajd.remove(word);
            ajd_graph.put(word,ajd);
        }



        return ajd_graph;
    }

    public static void main(String args[]){
        String beginword = "hit";
        String endword   = "cog";
        String[] ladders = {"hot","dot","dog","lot","log"};
        List<String> wordList = Arrays.asList(ladders);
        L127_wordladder solution = new L127_wordladder();
        solution.ladderLength(beginword,endword,wordList);
    }


}
