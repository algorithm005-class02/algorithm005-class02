package com.star.l242;

/**
 * @author star
 * @Date 2019/12/21.
 * @Description: No Description Yet.
 */
public class Solution_3 {
    public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
      counter[s.charAt(i) - 'a'] ++;
      counter[t.charAt(i) - 'a'] ++;
    }

    for (int count : counter) {
      if (count != 0) return false;
    }

    return true;
    }
}