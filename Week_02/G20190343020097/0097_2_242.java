package G20190343020097;

import java.util.Arrays;

/**
 * * @author jiangli
 * * @date 2019/12/20 15:56
 * * @description
 */
public class Solution242 {
    //1.先排序后比较字符串是否一样
    //2.统计各字母次数 然后比较两个字符串 每个字母的个数

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] chars1 = s.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 同时(划重点)遍历两个字符串 用hash表记录每个字母出现的次数
     * s字符串出现字母a 则count++ t字符串出现字母a 则count--
     * 用map统计效率低 用数组统计较快
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            chars[c1 - 'a']++;
            char c2 = t.charAt(i);
            chars[c2 - 'a']--;

        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
