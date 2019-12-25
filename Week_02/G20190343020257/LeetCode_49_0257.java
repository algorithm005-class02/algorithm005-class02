class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String st = String.valueOf(temp);
            List<String> record = map.get(st);
            if (record == null) {
                record = new ArrayList<String>();
                map.put(st, record);
            }
            record.add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
