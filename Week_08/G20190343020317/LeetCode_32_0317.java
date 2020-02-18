class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<Integer>();
        int max = 0;
        // 保存上一个有效括号的长度
        int last_num;
        int[] num = new int[s.length()+1];
        boolean[] dp = new boolean[s.length()+1];
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else if(!stack.isEmpty() && s.charAt(i) == ')'){
                //这里的是i是从0开始的，所以这其实是第 i+1 个数
                dp[i+1] = true;
                //如果取出来的数对应的索引的前一位也是有效括号，注意哦，这里的dp是从1开始的！
                // 所以不用减1了，直接就是dp[stack.peek()],num数组同理
                // dp数组和num数组，索引值为 i+1
                if(dp[stack.peek()] == true){
                    last_num = num[stack.peek()];
                }
                else last_num = 0;
                num[i+1] = i - stack.pop() + 1 + last_num;
                max = Math.max(max,num[i+1]);
            }
        }
        return max;
    }
}