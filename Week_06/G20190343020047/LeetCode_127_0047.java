class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String key = word.substring(0, i) + "_" + word.substring(i + 1);
                if (!graph.containsKey(key)) {
                    graph.put(key, new ArrayList<>(Collections.singletonList(word)));
                } else {
                    graph.get(key).add(word);
                }
            }
        }

        int step = 1;
        List<String> from = new ArrayList<>(Collections.singletonList(beginWord));
        List<String> to = new ArrayList<>();
        Map<String,Boolean> visited = new HashMap<>();
        while (from.size() > 0) {
            String word = from.remove(0);
            if (!visited.containsKey(word)) {
                visited.put(word, true);
                if (word.equals(endWord)) {
                    return step;
                }
                for (int i = 0; i < word.length(); i++) {
                    String key = word.substring(0, i) + "_" + word.substring(i + 1);
                    if (graph.containsKey(key)) {
                        to.addAll(graph.get(key));
                    }
                }
            }
            if (from.size() == 0) {
                step++;
                from.addAll(to);
                to.clear();
            }

        }
        return 0;

    }
}