package G20190343020097;

import java.util.*;

/**
 *  * @author jiangli
 *  * @date 2020/2/27 12:33
 *  * @description
 *  
 */
public class LeetCode_127_0097 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0 || wordList == null || wordList.size() == 0) {
            return 0;
        }
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Map<String, List<String>> wordMap = getWordMap(wordList);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        Integer step = 1;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                visited.add(node);
                Set<String> startWordSet = getWordSet(node);
                for (String startStr : startWordSet) {
                    List<String> childWords = wordMap.get(startStr);
                    if (childWords != null && childWords.size() > 0) {
                        for (String childWord : childWords) {
                            if(!visited.contains(childWord)){
                                if (childWord.equals(endWord)) {
                                    return step;
                                } else {
                                    queue.offer(childWord);
                                    visited.add(childWord);
                                }
                            }

                        }
                    }
                }

            }
        }
        return 0;
    }

    /**
     * 计算单词可能的接龙形式
     *
     * @param word
     * @return
     */
    public Set<String> getWordSet(String word) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char[] chars = word.toCharArray();
            chars[i] = '*';
            set.add(new String(chars));
        }
        return set;
    }

    public Map<String, List<String>> getWordMap(List<String> words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            Set<String> set = getWordSet(word);
            for (String str : set) {
                List<String> list = map.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(word);
                map.put(str, list);
            }
        }
        return map;
    }

    /**
     * 单向BFS第二种解法
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0 || wordList == null || wordList.size() == 0) {
            return 0;
        }
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];
        queue.offer(beginWord);
        Integer step = 1;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                for(int j = 0;j<wordList.size();j++){
                    if(!visited[j]){
                        String word = wordList.get(j);
                        if(canTransfer(node,word)){
                            if(word.equals(endWord)){
                                return step;
                            }else {
                                queue.offer(word);
                                visited[j] = true;
                            }
                        }
                    }
                }
            }
            System.out.println(queue);
        }
        return 0;

    }

    /**
     * 判断两个单词能否接龙
     * @param start
     * @param end
     * @return
     */
    public boolean canTransfer(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    /**
     * 双向BFS
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0 || wordList == null || wordList.size() == 0) {
            return 0;
        }
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> beginQueue = new LinkedList<>();
        beginQueue.offer(beginWord);
        Queue<String> endQueue = new LinkedList<>();
        endQueue.offer(endWord);
        boolean[] visited = new boolean[wordList.size()];
        Integer step = 1;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            step++;
            int size = beginQueue.size();
            for (int i = 0; i < size; i++) {
                String node = beginQueue.poll();
                for(int j = 0;j<wordList.size();j++){
                    if(!visited[j]){
                        String word = wordList.get(j);
                        if(canTransfer(node,word)){
                            if(endQueue.contains(word)){
                                return step;
                            }else {
                                beginQueue.offer(word);
                                visited[j] = true;
                            }
                        }
                    }
                }
            }
            if(beginQueue.size()<endQueue.size()){
                Queue<String> queue = beginQueue;
                beginQueue = endQueue;
                endQueue = queue;
            }
        }
        return 0;

    }

}
