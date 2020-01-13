import java.util.*;

/**
 * 异位词分组
 * https://leetcode.com/problems/group-anagrams/
 */
public class Leetcode_49_groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> res = new HashMap<>();
        for (String s : strs) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String sSorted = String.valueOf(sArray);
            if (!res.containsKey(sSorted)) {
                res.put(sSorted, new ArrayList());
            }
            res.get(sSorted).add(s);
        }

        return new ArrayList(res.values());
    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List> res = new HashMap<>();

        for (String s : strs) {
            int[] counter = new int[26];
            Arrays.fill(counter, 0);

            for (int i = 0; i < s.length(); i++) {
                counter[s.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < counter.length; i++) {
                sb.append("#" + counter[i]);
            }

            String key = sb.toString();
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList());
            }

            res.get(key).add(s);
        }

        return new ArrayList(res.values());
    }
}
