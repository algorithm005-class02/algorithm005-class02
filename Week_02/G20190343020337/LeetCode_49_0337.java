class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            List<String> anangramlist = map.getOrDefault(sorted,new ArrayList<>());
            map.put(sorted,anangramlist);
            anangramlist.add(str);
        }
        List<List<String>> ret= new ArrayList<>();
        ret.addAll(map.values());
        return ret;

    }
}