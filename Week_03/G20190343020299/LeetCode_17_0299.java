import java.util.*;

/**
 * 17. 电话号码的字母组合
 */
public class LeetCode_17_0299 {

    Map<Character, String> map = new HashMap();

    public LeetCode_17_0299() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        // 以下省略
    }

    private void search(String curr, String digits, int level, List<String> res) {
        // terminator
        if (digits.length() == level) {
            res.add(curr);
            return;
        }
        // process
        String letters = map.get(digits.charAt(level));
        for (int i = 0; i < letters.length(); i++) {
            // dill down
            search(curr + letters.charAt(i), digits, level + 1, res);
        }
    }

    public static void main(String[] args) {
        List<String> res = new LinkedList<>();
        LeetCode_17_0299 leetCode = new LeetCode_17_0299();
        String digits = "234";
        leetCode.search("", digits, 0, res);
        System.out.println(res);
    }
}
