/**
 * 最后一个单词的长度
 * https://leetcode.com/problems/length-of-last-word/
 */
public class Leetcode_58_lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int lastLen = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && lastLen > 0) {
                return lastLen;
            } else if (s.charAt(i) != ' ') {
                lastLen++;
            }
        }
        return lastLen;
    }
}
