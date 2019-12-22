class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> m = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!m.containsKey(key)) {
                m.put(key, new ArrayList<>());
            }
            m.get(key).add(str);
        }

        return new ArrayList<>(m.values());
    }
}