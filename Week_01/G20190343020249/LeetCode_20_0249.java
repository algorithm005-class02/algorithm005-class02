package stack;
/**
 * author: Ziv
 * description:
 * Date:Created in
 */

import java.util.Stack;

/**
 *
 *
 * @author piper
 * @date 2019/12/3 12:41 
 * @decrisption
 */
public class LeetCode_20_0249 {

    public static void main(String[] args) {
        LeetCode_20_0249 leetCode_20_0249 = new LeetCode_20_0249();
        boolean valid = leetCode_20_0249.isValid("[][][][][][][][()()(){}{}{}{}]");
        System.out.println("valid:"+valid);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '{') {
                stack.push('}');
            } else if(c =='[') {
                stack.push(']');
            }
            else if(c =='(') {
                stack.push(')');
            } else if(stack.isEmpty() || stack.pop() != c) {
                return  false;
            }
        }
        return stack.isEmpty();
    }
}
