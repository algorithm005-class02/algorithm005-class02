import java.sql.Array;
import java.util.Arrays;

class LeeCode_242_0321 {
    /**
     * is Anagram
     * 有效的字母异位词
     */
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = new Solution().isAnagram(s, t);

        System.out.println(result);

    }

    static class Solution {
        /**
         * 转化成char数组，排序后比较
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            char[] charS = s.toCharArray();
            char[] charT = t.toCharArray();
            Arrays.sort(charS);
            Arrays.sort(charT);

            return Arrays.equals(charS, charT);
        }

        /**
         * 用hash表，统计字母出现次数，用26位计数器两遍遍历是否归零来判断
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagram_1(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] counts = new int[26];
            for (int i = 0; i < s.length(); i++) {
                    counts[s.charAt(i)-'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                counts[t.charAt(i) - 'a']--;
                if(counts[t.charAt(i) - 'a']<0){
                    // 小于0表示s中无 t中某个字母，
                    return false;
                }
            }
            return true;
        }
    }
}


