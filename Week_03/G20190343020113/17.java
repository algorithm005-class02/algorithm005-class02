class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if (digits == null) {
            return list;
        }
        if(digits.length() == 0) {
            return list;
        }
        Map<Character,String> hashmap = new HashMap<Character, String>();
        hashmap.put('2',"abc");
        hashmap.put('3',"def");
        hashmap.put('4',"ghi");
        hashmap.put('5',"jkl");
        hashmap.put('6', "mno");
        hashmap.put('7', "pqrs");
        hashmap.put('8', "tuv");
        hashmap.put('9',"wxyz");
        letter(list, new String(), 0, digits, hashmap);
        return list;
    }

    public void letter(List<String> list, String str, int index, String digits, Map<Character, String> hashmap) {
        if(index == digits.length()) {
            list.add(str);
        } else {
            if(hashmap.containsKey(digits.charAt(index))) {
                String s = hashmap.get(digits.charAt(index));
                for(int i = 0;i < s.length(); i++) {
                    letter(list, str + s.charAt(i), index + 1, digits, hashmap);
                }
            }
        }
    }
}