package smart33690;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 位1的个数
 */
public class LeetCode387 {
    public static void main(String[] args) {

        int res = firstUniqChar("leetcode");
        System.out.println(res);
    }


    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

}
