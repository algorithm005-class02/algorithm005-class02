/**
*设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

 push(x) -- 将元素 x 推入栈中。
 pop() -- 删除栈顶的元素。
 top() -- 获取栈顶元素。
 getMin() -- 检索栈中的最小元素。
 示例:

 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> 返回 -3.
 minStack.pop();
 minStack.top();      --> 返回 0.
 minStack.getMin();   --> 返回 -2.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/min-stack
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class MinStack {
    private Stack<Integer> stackOne, stackTwo;
    /** initialize your data structure here. */
    public MinStack() {
        stackOne = new Stack<Integer>();
        stackTwo = new Stack<Integer>();
    }

    public void push(int x) {
        stackOne.push(x);
        if (stackTwo.isEmpty()) {
            stackTwo.push(x);
        } else {
            if (stackTwo.peek() >= x) {
                stackTwo.push(x);
            }
        }
    }

    public void pop() {
        if (stackOne.isEmpty()) {
            throw new NullPointerException();
        }
        int tmp = stackOne.pop();
        if (tmp <= stackTwo.peek()) {
            stackTwo.pop();
        }
    }

    public int top() {
        if (stackOne.isEmpty()) {
            throw new NullPointerException();
        }
        return stackOne.peek();
    }

    public int getMin() {
        if (stackOne.isEmpty()) {
            throw new NullPointerException();
        }
        return stackTwo.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */