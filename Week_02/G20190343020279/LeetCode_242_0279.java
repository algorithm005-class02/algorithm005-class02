/**
 * @method "哈希表法"
 * @explain 创建一个26位的计数器表，计算两个字符串中每个字母的出现次数并进行比较，如果字符串长度不一致则不可能相同。
 * @complexity 时间复杂度：O(n),空间复杂度：O(1)
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        // 1.先判断特殊情况：字数不一致直接返回false
        if (s.length() != t.length()) {
            return false;
        }
        // 2.创建26位计数器表
        int[] counter = new int[26];
        // 3.遍历两个字符串，s的字母出现在对应表里的位置+1，t则反之-1
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }
        //如果字母表内都是0则true
        for(int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) return false;
        }
        return true;
    }
}
