class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0){
            return new ArrayList();
        }
        //和字母异位词相同，维护一个哈希
        Map<String, List> map = new HashMap<String, List>();
        for (String str : strs) {
            char[] st = str.toCharArray();
            Arrays.sort(st);
            String key = String.valueOf(st);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList());
            }
            //相同异位词放在一起
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}