/**
 * 字母异位词：字母出现的次数一样，但顺序不一样
 * 解题思路：
 * 1.暴力，将字母sort，再比较排序后字符串是否相等，时间复杂度：O(nlogn)
 * 2.hash、map ->统计每个字符的频次，时间复杂度：O(n)
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //time complexity:O(n)
    //用一个26个字母的计数器，一个表示s字母的频率++，一个表示t字符的频率--，再最后看计数器是否归零
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //减去'a'，是获取char的索引位置
            counter[s.charAt(i) - 'a'] ++;
            counter[t.charAt(i) - 'a'] --;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    //time complexity:O(n)
    //用一个26个字母的计数器，先统计s的字母频次，在用t减少计数器每个字母，若计数器低于0说明t包含一个s不存在的额外字母
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) -'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            counter[t.charAt(i) - 'a']--;
            if (counter[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    //time complexity:O(nlogn)
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

