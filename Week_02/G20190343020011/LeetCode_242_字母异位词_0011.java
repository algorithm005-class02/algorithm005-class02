package leetcode.week02;

import java.util.HashMap;
import java.util.Map;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表
public class LeetCode_242_字母异位词_0011 {

    /**
     * HashMap，时间较长
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);
            if (map.containsKey(sc)) {
                map.put(sc, map.get(sc) + 1);
            } else {
                map.put(sc, 1);
            }
            if (map.containsKey(tc)) {
                map.put(tc, map.get(tc) - 1);
            } else {
                map.put(tc, -1);
            }
        }
        for (int i : map.values()) {
            if (i != 0) return false;
        }
        return true;
    }

    /**
     * 容量为26的数组
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
            array[t.charAt(i) - 'a']--;
        }
        for (int v : array) {
            if (v != 0) return false;
        }
        return true;
    }

}
