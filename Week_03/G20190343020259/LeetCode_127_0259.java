class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add(beginWord);
        set2.add(endWord);

        return this.helper(dict, 1, new HashSet<>(), set1, set2);
    }

    private int helper(Set<String> dict, int level, Set<String> visited, Set<String> curr, Set<String> next) {
        if (curr.isEmpty()) {
            return 0;
        }
        if (curr.size() > next.size()) {
            return this.helper(dict, level, visited, next, curr);
        }

        visited.addAll(curr);
        visited.addAll(next);

        Set<String> tmp = new HashSet<>();

        for (String str : curr) {
            for (int i = 0; i < str.length(); i++) {
                char[] chars = str.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String word = new String(chars);
                    if (next.contains(word)) {
                        return level + 1;
                    }
                    if (!visited.contains(word) && dict.contains(word)) {
                        tmp.add(word);
                        visited.add(word);
                    }
                }
            }
        }

        return this.helper(dict, level+1, visited, next, tmp);
    }


}