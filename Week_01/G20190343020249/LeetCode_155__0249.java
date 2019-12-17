package stack;/**
 * author: Ziv
 * description:
 * Date:Created in
 */

/**
 *
 *
 * @author piper
 * @date 2019/12/11 23:45 
 * @decrisption
 */
public class LeetCode_155__0249 {
private Stack<Integer> stack;
    private Stack<Integer> min_stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(min_stack.isEmpty() || x <= min_stack.peek())  min_stack.push(x);
    }

    public void pop() {
        if(min_stack.peek().equals(stack.pop())) min_stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }

}
