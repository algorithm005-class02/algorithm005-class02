class Solution {
    public int minMutation(String start, String end, String[] bank) {
        char[] chars = {'A', 'C', 'G', 'T'};
        Set<String> bankSet = new HashSet<>();
        bankSet.addAll(Arrays.asList(bank));
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(start);
        endSet.add(end);
        int level = 0;
        Set<String> visitSet = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() < endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }

            Set<String> tmp = new HashSet<>();
            for (String word : beginSet) {
                for (int index=0; index<word.length(); index++) {
                    char[] wordArrays = word.toCharArray();
                    for (char ch : chars) {
                        wordArrays[index] = ch;
                        String value = String.valueOf(wordArrays);
                        if (bankSet.contains(value) && !visitSet.contains(value)) {
                            if (endSet.contains(value)) {
                                return level+1;
                            }
                            visitSet.add(value);
                            tmp.add(value);
                        }
                    }
                }
            }
            beginSet = tmp;
            level++;
        }
        return -1;
    }
}
