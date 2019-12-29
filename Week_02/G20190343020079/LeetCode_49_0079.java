package com.star.l49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author star
 * @Date 2019/12/21.
 * @Description: No Description Yet.
 * 字符串排序，用作key，value为原始字符串
 */
public class Solution_1 {
    public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> res = new HashMap<>();
    for (String s:strs) {
      char[] charArr = s.toCharArray();
      Arrays.sort(charArr);
      String sortedStr = new String(charArr);

      List<String> list = res.getOrDefault(sortedStr, new ArrayList<>());
      list.add(s);
      res.put(sortedStr, list);
    }

    List<List<String>> l = new ArrayList<>();
    for (Map.Entry<String, List<String>> entry:res.entrySet()) {
      l.add(entry.getValue());
    }
    return l;
    }
}