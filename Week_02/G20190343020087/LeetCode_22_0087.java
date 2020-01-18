import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 * 通过递归的方式，类似于树
 * 记录left括号和right括号的个数
 * left保持继续添加，right在小于left的时候添加并继续调用函数
 * 这样会形成满足条件的树状结构
 * 参数left right string res 都是携带改变状态进行传递的
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(0, 0, n, "", res);
        return res;
    }

    public void generate(int left, int right, int n, String string, List<String> res){
        if (left == n && right == n) {
            res.add(string);
            return;
        }

        if (left < n) generate(left+1, right, n, string+"(", res);
        if (right < left) generate(left, right+1, n, string+")", res);
    }
}
// @lc code=end

