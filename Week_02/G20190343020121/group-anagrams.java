class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         if (strs.length == 0) {
            return  new ArrayList<>();
        }
        Map<String,List> map = new HashMap<>();
        for (String s in strs) {
            char[] s_ary = s.toCharArray();
            Arrays.sort(s_ary);
            String key = String.valueOf(s_ary);
            if (!map.containsKey(key))  {
                map.put(key,new ArrayList());

            }
            map.get(key).add(s);

        }
        return new ArrayList<>(map.values());
    }
}