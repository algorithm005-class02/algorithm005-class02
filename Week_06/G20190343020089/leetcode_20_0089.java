import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        
        Map<String, String> strMap = new HashMap<>();
        strMap.put(")", "(");
        strMap.put("]", "[");
        strMap.put("}", "{");

        Stack<String> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char e : charArray) {
            String ele = strMap.get(String.valueOf(e));
            if ( ele == null) {
                stack.push(String.valueOf(e));
            } else {
                if (stack.empty() || !ele.equals(stack.pop())) return false;
            }
        }
        return stack.empty();

        
    }
}
// @lc code=end

