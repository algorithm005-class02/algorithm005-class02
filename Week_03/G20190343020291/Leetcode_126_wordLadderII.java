import java.util.*;

/**
 * 单词接龙II
 * https://leetcode.com/problems/word-ladder-ii/
 */
public class Leetcode_126_wordLadderII {

    /**
     * 双端BFS + 回溯法
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);

        if (!wordSet.contains(endWord)) {
            return res;
        }

        // 双端BFS构建单词转换map
        Map<String, List<String>> wordMap = new HashMap<>();
        twoEndBfs(beginWord, endWord, wordSet, wordMap);
        // 回溯
        List<String> oneRes = new ArrayList<>();
        oneRes.add(beginWord);
        generateResult(beginWord, endWord, wordMap, oneRes, res);

        return res;
    }

    private void twoEndBfs(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> wordMap) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        boolean flip = false;
        boolean found = false;

        while (!beginSet.isEmpty() && !endSet.isEmpty() && !found) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
                flip = !flip;
            }
            // 保证生成的map是单向变换
            wordSet.removeAll(beginSet);
            wordSet.removeAll(endSet);

            Set<String> tmpSet = new HashSet<>();
            for (String word : beginSet) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String newWord = String.valueOf(arr);
                        String key = flip ? newWord : word;
                        String value = flip ? word : newWord;
                        List<String> tmpList = wordMap.containsKey(key) ? wordMap.get(key) : new ArrayList<>();
                        if (endSet.contains(newWord)) {
                            tmpList.add(value);
                            wordMap.put(key, tmpList);
                            found = true;
                        }

                        if (!found && wordSet.contains(newWord)) {
                            tmpSet.add(newWord);
                            tmpList.add(value);
                            wordMap.put(key, tmpList);
                        }
                    }
                    arr[i] = old;
                }
            }
            beginSet = tmpSet;
        }
    }


    private void generateResult(String beginWord, String endWord, Map<String, List<String>> wordMap, List<String> oneRes, List<List<String>> res) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(oneRes));
            return;
        }

        if (!wordMap.containsKey(beginWord)) {
            return;
        }

        for (String word : wordMap.get(beginWord)) {
            oneRes.add(word);
            generateResult(word, endWord, wordMap, oneRes, res);
            oneRes.remove(oneRes.size() - 1);
        }
    }


    public static void main(String[] args) {
        Leetcode_126_wordLadderII solution = new Leetcode_126_wordLadderII();
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = new String[]{"hot","dot","dog","lot","log","cog"};

        List<List<String>> ladders = solution.findLadders(beginWord, endWord, Arrays.asList(wordList));

        System.out.println(ladders);
        System.out.println(ladders.size());
    }
}