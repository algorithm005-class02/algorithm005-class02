package G20190343020097;

import java.util.*;

/**
 * * @author jiangli
 * * @date 2019/12/20 16:34
 * * @description
 */
public class Solution49 {
    //1.先把每个字符串排序，把排序后的字符串按key-value形式存储
    //2.统计每个字符串中每个字母的出现频率 把这个频率作为key 保存字符串

    public static void main(String[] args) {
//        List<List<String>> lists = new Solution49().groupAnagrams3(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});


    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            List<String> strings = map.get(s) == null ? new ArrayList<>() : map.get(s);
            strings.add(strs[i]);
            map.put(s, strings);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 第一种方法的优化写法
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (!map.containsKey(s)) map.put(s, new ArrayList<>());
            map.get(s).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams3(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (!map.containsKey(s)) {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(strs[i]);
                map.put(s, strings);
            } else {
                map.get(s).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 统计字符串中每个字符出现频率，为一个有序数组
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams4(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] counts = new int[26];
            char[] chars = strs[i].toCharArray();
            for(char c:chars) counts[c - 'a']++;
            StringBuilder sb = new StringBuilder("");
            for(int c :counts) sb.append(c+"");
            String key = sb.toString();
            if (!map.containsKey(key)) {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(strs[i]);
                map.put(key, strings);
            } else {
                map.get(key).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }
}
