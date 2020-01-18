class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> counter = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = String.valueOf(chars);
            if (counter.get(sortStr) == null) {
                counter.put(sortStr, new ArrayList<>(Arrays.asList(str)));
            } else {
                counter.get(sortStr).add(str);
            }
        }
        return new ArrayList<>(counter.values());
    }
}
