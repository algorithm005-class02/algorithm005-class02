import java.lang.reflect.Array;
import java.util.*;

class LeeCode_049_0321 {
    /**
     * group Anagrams
     * 字母异位词分组
     */
    public static void main(String[] args) {

        List<List<String>> result = new LeeCode_094_0321.Solution().groupAnagrams(new String[]{"3", "65"});


    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) return new ArrayList<>(0);
            Map<String, List<String>> group = new HashMap<>();
            for (String s :strs) {
                char[] cs = s.toCharArray();
                Arrays.sort(cs);
                String key = String.valueOf(cs);
                if (!group.containsKey(key)) {
                    group.put(key, new ArrayList<>());
                }
                group.get(key).add(s);
            }
            return new ArrayList<>(group.values());
        }
    }
}


