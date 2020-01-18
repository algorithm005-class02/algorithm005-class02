import java.util.Arrays;

/**
 * 方法一:排序
 * 时间复杂度：O(nlogn)，假设 n 是 s 的长度，排序成本 O(nlogn) 和比较两个字符串的成本 O(n)。排序时间占主导地位，总体时间复杂度为 O(nlogn)。
 */
class Solution {
    public boolean isAnagram_1(String s, String t) {
        // 长度都不想等, 不必再进行后面的判断
        if (s.length() != t.length()) return false;
        // string转Array
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr,tArr);
    }

/**
 * 方法二:哈希表
 * 时间复杂度：O(n)。时间复杂度为 O(n) 因为访问计数器表是一个固定的时间操作。
 * https://leetcode-cn.com/problems/valid-anagram/solution/hua-jie-suan-fa-242-you-xiao-de-zi-mu-yi-wei-ci-by/
 */
    public boolean isAnagram_2(String s, String t) {
        // 长度都不想等, 不必再进行后面的判断
        if (s.length() != t.length()) return false;
        // 初始化26个字母哈希表, {a,b,c,d,e...x,y,z}
        int[] counter = new int[26];
        for(int i = 0; i< s.length(); i++) {
            // 找出所在哈希表位置, ++操作
            counter[s.charAt(i) - 'a'] ++;
            // 找出所在哈希表位置, --操作
            counter[t.charAt(i) - 'a'] --;
        }
        for(int value : counter) {
            if(value != 0) return false;
        }  
        return true;
    }
}

