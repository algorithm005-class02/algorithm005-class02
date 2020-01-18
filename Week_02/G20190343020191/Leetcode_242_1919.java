import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 * 思路：1 长度要相等 ，2排序后比较
 * 排序 O(nlogn); 比较 O(n) 综合后为排序时间复杂度
 */

// @lc code=start
class Solution {
    /**
     * 排序法
     * @param s
     * @param t
     * @return
     */
    // public boolean isAnagram(String s, String t) {
    //     if(s.length()!= t.length()){
    //         return false;
    //     }
    //     char [] s1 = s.toCharArray();
    //     char [] t1 = t.toCharArray();
    //     Arrays.sort(s1);
    //     Arrays.sort(t1);
    //     return Arrays.equals(s1, t1);
    // }

    /**
     * hashmap方法
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) {
            return false;
        }

        int [] count = new int [26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }

        for (int i : count) {
            if (i!=0){
                return false;
            }
        }
        return true;
    }

}
// @lc code=end

