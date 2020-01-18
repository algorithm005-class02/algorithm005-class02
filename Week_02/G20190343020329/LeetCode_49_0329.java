import java.util.*;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (null == strs || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sortedStr = _sortStr(str);
            List<String> data = map.computeIfAbsent(sortedStr, k -> new ArrayList<>());
            data.add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String _sortStr(String str) {
        char[] a = str.toCharArray();
        Arrays.sort(a);
        return Arrays.toString(a);
    }
}
