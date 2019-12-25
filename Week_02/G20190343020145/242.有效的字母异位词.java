import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (57.15%)
 * Likes:    134
 * Dislikes: 0
 * Total Accepted:    61.9K
 * Total Submissions: 108K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start
//暴力法，时间复杂度O(nlogn)，空间复杂度O（1）
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if(s.length() != t.length())
//             return false;
//         char[] ss = s.toCharArray();
//         char[] tt = t.toCharArray();
//         Arrays.sort(ss);
//         Arrays.sort(tt);
//         return Arrays.equals(ss, tt);
//     }
// }

//哈希表 时间复杂度O（n），空间复杂度O（1）
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        //建立一个数组存放hash
        int[] counter = new int[26];

        for(int i = 0; i<s.length();++ i){
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for(int count : counter) {
            if (count != 0){
                return false;
            }
        }
        return true;

    }
}


// @lc code=end

