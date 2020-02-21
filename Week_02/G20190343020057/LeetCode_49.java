class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) return new ArrayList<>();
        Map<String,List> map = new HashMap<String,List>();
        for(String str:strs){
            char[] ch = str.toCharArray();//将String拆成char数组
            Arrays.sort(ch);//调用Arrys的排序函数对char数组进行排序
            String key = String.valueOf(ch);//将char数组再次转化为String，这样异位词就会相等，相当于哈希表中属于同一个Key
            if(!map.containsKey(key)) map.put(key,new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}