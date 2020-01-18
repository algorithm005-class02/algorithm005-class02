class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> HM = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arrOfChar = strs[i].toCharArray();
            Arrays.sort(arrOfChar);
            String k = String.valueOf(arrOfChar);
            if ( HM.containsKey​(k)) {
                HM.get(k).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                HM.put(k, temp);
            }
        }
        return new ArrayList<List<String>>(HM.values());
    }
}