import java.util.HashMap;
import java.util.Map;

public class LeetCode_387_0299 {

    public static void main(String[] args) {
        String str = "leetcode";
        int res = new LeetCode_387_0299().firstUniqChar(str);
        System.out.println(res);
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
