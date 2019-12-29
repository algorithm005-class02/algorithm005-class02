/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设字符串只包含小写字母。
 */
class Solution {
    /**
     * 排序比较法一
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        // 排序
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        // 取字符串的值
        String str1 = String.valueOf(sChar);
        String str2 = String.valueOf(tChar);
        return str1.equals(str2);
    }

    /**
     * 排序比较法二（用时更短）
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        // 排序
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }

    /**
     * 哈希表处理一
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hashInt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hashInt[s.charAt(i) - 'a']++;
            hashInt[t.charAt(i) - 'a']--;
        }
        for (int hash : hashInt) {
            if (hash != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 哈希表处理二
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hashInt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hashInt[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            hashInt[t.charAt(j) - 'a']--;
            if (hashInt[t.charAt(j) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}