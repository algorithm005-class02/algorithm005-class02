package com.hash;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> list = map.get(key);
            if (!map.containsKey(key)) {
                list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            } else {
                list.add(str);
            }
        }

        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(arr);
        System.out.println();
    }
}
