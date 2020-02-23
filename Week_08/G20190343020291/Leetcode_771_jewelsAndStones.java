import java.util.HashSet;
import java.util.Set;

/**
 * 宝石与石头
 * https://leetcode.com/problems/jewels-and-stones/
 */
public class Leetcode_771_jewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        int num = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                num++;
            }
        }
        return num;
    }
}
