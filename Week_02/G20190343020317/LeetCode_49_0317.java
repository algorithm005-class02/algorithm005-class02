class Solution {
    //解法一，用hash table
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringListHashMap = new HashMap<>();
        for(String x: strs){
            char[] chars = x.toCharArray();
            Arrays.sort(chars);
            if (stringListHashMap.containsKey(String.valueOf(chars))){
                stringListHashMap.get(String.valueOf(chars)).add(x);
            }else {
                stringListHashMap.put(String.valueOf(chars), new ArrayList<>());
                stringListHashMap.get(String.valueOf(chars)).add(x);
            }
        }
        return new ArrayList<>(stringListHashMap.values());
    }
}