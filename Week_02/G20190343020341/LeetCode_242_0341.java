import java.util.Arrays;

public class LeetCode_242_0341 {
}
class Solution {
    public boolean isAnagram(String s, String t) {
        //先排序，再逐个比较
        if (s.length() != t.length()) {
            return false;
        }
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);


//        if (!String.valueOf(schars).equals(String.valueOf(tchars))) {
//            return false;
//        }
        return Arrays.equals(schars, tchars);
    }
}