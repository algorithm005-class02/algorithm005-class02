class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,ArrayList> res = new HashMap<>();
        for(int i = 0;i < strs.length;i++){
            int a[] = new int[26];
            for(int j = 0;j < strs[i].length();j++){
                a[strs[i].charAt(j)-'a']++;
            }
            StringBuffer str5 = new StringBuffer();
            for (int s : a) {
                str5.append(s);
            }
            if(res.get(str5.toString().trim())==null){
                res.put(str5.toString().trim(),new ArrayList<String>());
            }
            res.get(str5.toString().trim()).add(strs[i]);
        }
        List<List<String>> re = new ArrayList<>();
        for(List value : res.values()){
            re.add(value);
        }
        return re;
    }
}
