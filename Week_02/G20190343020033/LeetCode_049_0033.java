class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> resultMap = new HashMap<>();
        if(strs != null && strs.length >0){
            for(String str : strs){
                char[] srt_byteArray = str.toCharArray();
                Arrays.sort(srt_byteArray);
                String key = Arrays.toString(srt_byteArray);
                List<String> list = null;
                if(resultMap.get(key) != null){
                    list = resultMap.get(key);
                }else{
                    list = new ArrayList<>();
                }
                list.add(str);
                resultMap.put(key,list);
            }
        }
        return new ArrayList<>(resultMap.values());
    }
}