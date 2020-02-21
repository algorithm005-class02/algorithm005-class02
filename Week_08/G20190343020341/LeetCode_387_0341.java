import java.util.Arrays;
import java.util.HashSet;

public class LeetCode_387_0341 {
    public static void main(String[] args) {
        new Solution387().firstUniqChar("leetcode");
    }
}

class Solution387 {
    public int firstUniqChar(String s) {
        if(s.equals(""))
            return -1;
        if(s.length() == 1)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < s.length() - 1; i++) {
            boolean contains = set.contains(Integer.valueOf(s.charAt(i)));
            if(!contains && s.substring(i + 1).indexOf(s.charAt(i)) == -1) {
                return i;
            } else if(!contains) {
                set.add(Integer.valueOf(s.charAt(i)));
            }
        }
        if(!set.contains(Integer.valueOf(s.charAt(s.length()-1))))
            return s.length() -1;
        return -1;
    }
}